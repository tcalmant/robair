#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

import logging
import select
import serial
import socket
import struct
import threading
import time

import wifibot

_logger = logging.getLogger(__name__)

class Wifibot(object):
    """
    Represents a *wifibot*. Connected either using the TCP server or the serial
    connection
    """
    def __init__(self, handler=None):
        """
        Sets up the wifibot representation
        """
        # Thread control stuff
        self._lock = threading.Lock()
        self._stop_event = threading.Event()
        self._thread = None
        self._read_thread = None

        # Call backs handler
        self._handler = handler

        # Robot data
        self._robot_data = None

        # Control values
        self._left_speed = 0
        self._right_speed = 0
        self._control_flag = True

        # Connection information
        self._connected = False
        self._socket = None
        self._serial = None


    def __notify_handler(self):
        """
        Notifies the handler of a connection activated or lost
        """
        if self._handler is None:
            return

        try:
            if self._connected:
                name = "robot_connected"

            else:
                name = "robot_lost"

            method = getattr(self._handler, name, None)
            if method is not None:
                method()

        except:
            _logger.exception('Error calling back the handler.')


    def __start_tcp_loop(self, server_ip, server_port):
        """
        Loops until the TCP connection succeeds
        """
        while not self._stop_event.is_set():
            try:
                if self.__start_tcp(server_ip, server_port):
                    return

            except Exception as ex:
                # Some error occurred, log and wait
                _logger.exception("Error connecting the TCP server: %s", ex)
                time.sleep(.200)


    def __start_tcp(self, server_ip, server_port):
        """
        Starts a wifibot TCP connection
        
        :param server_ip: IP of the wifibot TCP server
        :param server_port: Port of the wifibot TCP server
        :return: True if the connection is a success
        :raise Exception: Error connecting the server
        """
        if self._connected:
            return True

        # Connect the server
        self._socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self._socket.connect((server_ip, server_port))
        self._connected = True

        # Common start
        self._thread_start()

        # Notify the handler
        self.__notify_handler()
        return True


    def start_tcp(self, server_ip, server_port=15020, blocking=True):
        """
        Starts a wifibot TCP connection
        
        :param server_ip: IP of the wifibot TCP server
        :param server_port: Port of the wifibot TCP server
        :return: True if the connection is a success
        :raise Exception: Error opening the connection
                          (only if blocking is True)
        """
        if self._connected:
            return True

        if blocking:
            return __start_tcp(server_ip, server_port)

        else:
            # Start the connection loop in a new thread
            thread = threading.Thread(target=self.__start_tcp_loop,
                                      args=(server_ip, server_port))
            thread.daemon = True
            thread.start()


    def start_raw(self, com_port="/dev/ttyS0"):
        """
        Starts a wifibot serial connection
        
        .. warning:: Not working yet
        
        :param com_port: Serial COM port to use to access the wifibot
        :raise Exception: Error opening the port
        """
        if self._connected:
            raise Exception("Already connected to the wifibot.")

        # Connect the server
        self._serial = serial.Serial(baudrate=19200)
        self._serial.port = com_port

        # Raises an exception on error
        self._serial.open()
        self._connected = True

        # Common start
        self._thread_start()

        # Notify the handler
        self.__notify_handler()


    def stop(self):
        """
        Closes the wifibot connection and stop the sending thread
        """
        # Reset
        self.reset()

        # Stop the thread
        self._stop_event.set()
        if self._thread is not None:
            self._thread.join()
            self._thread = None

        if self._read_thread is not None:
            self._read_thread.join()
            self._read_thread = None

        # Disconnect the robot
        self._connected = False
        self.__notify_handler()

        if self._socket is not None:
            self._socket.close()
            self._socket = None

        if self._serial is not None:
            self._serial.close()
            self._serial = None


    def reset(self):
        """
        Resets motors values
        """
        with self._lock:
            self._left_speed = 0
            self._right_speed = 0
            self._control_flag = True


    def set_motors(self, left_speed, right_speed, control=True):
        """
        Sets the motors speed
        
        :param left_speed: Left speed, between -60 and +60
        :param right_speed: Right speed, between -60 and +60
        :param control: The wifibot loop control flag
        """
        with self._lock:
            self._left_speed = left_speed
            self._right_speed = right_speed
            self._control_flag = control


    def get_data(self):
        """
        Retrieves the last values read from the robot
        """
        with self._lock:
            return self._robot_data


    def _data_tcp_loop(self):
        """
        Reads the data sent by the TCP server
        
        .. warning:: Not yet usable
        """
        buf = ""

        while not self._stop_event.is_set():
            # Get the packet
            try:
                rl = select.select([self._socket], [], [], .500)[0]
                if not rl:
                    # Time out
                    continue

                to_read = 15 - len(buf)
                buf += self._socket.recv(to_read)
                if not buf:
                    _logger.error("No packet to read. Stopping")
                    return

            except IOError as ex:
                _logger.exception("Error reading socket: %s", ex)
                break

            if len(buf) != 15:
                _logger.debug("Received only %d bytes.", len(buf))
                continue

            # Extract data
            unpacked = struct.unpack("<BbBbbBBLL", buf)
            result = {}
            result["batLevel"] = unpacked[0]
            result["leftSpeed"] = unpacked[1]
            result["leftCurrent"] = unpacked[2]
            result["rightSpeed"] = unpacked[3]
            result["rightCurrent"] = unpacked[4]
            result["IRL"] = unpacked[5]
            result["IRR"] = unpacked[6]
            result["leftOdometry"] = unpacked[7]
            result["rightOdometry"] = unpacked[8]

            # Clear the buffer
            buf = ""

            with self._lock:
                self._robot_data = result

        # Connection lost
        self.stop()


    def _data_raw_loop(self):
        """
        Reads the data from the serial port
        
        .. warning:: Not yet usable
        """
        while not self._stop_event.is_set():

            try:
                # Synchronize...
                buf = "\x00"
                while ord(buf[0]) != 255:
                    buf = self._serial.read(1)

                # Read data
                buf = ""
                while len(buf) != 21:
                    data = self._serial.read(21)
                    buf += data
                    buf = buf[:21]

            except:
                _logger.exception("Error reading the COM port")
                break

            # Validate packet
            crc_rcv = struct.unpack("<H", buf[-2:])[0]
            crc_comp = wifibot.crc16(buf[:-2])
            if crc_rcv != crc_comp:
                _logger.warning("Different CRC found: Packet=%s Computed=%s",
                                crc_rcv, crc_comp)

            # Extract data
            unpacked = struct.unpack("<hBbbLhbbLBB", buf[:-2])

            result = {}
            result["leftSpeed"] = unpacked[0]
            result["batLevel"] = unpacked[1]
            result["IRL"] = unpacked[2]
            result["IR2L"] = unpacked[3]
            result["leftOdometry"] = unpacked[4]
            result["rightSpeed"] = unpacked[5]
            result["IRR"] = unpacked[6]
            result["IR2R"] = unpacked[7]
            result["rightOdometry"] = unpacked[8]
            result["current"] = result["leftCurrent"] = result["rightCurrent"] = unpacked[9]
            result["version"] = unpacked[10]

            with self._lock:
                self._robot_data = result

        # Connection lost
        self.stop()


    def _motors_tcp_loop(self):
        """
        Motors update thread loop
        """
        while not self._stop_event.is_set():
            with self._lock:
                self._socket.send(wifibot.construct_tcp_motors_packet(\
                                    self._left_speed, self._right_speed,
                                    self._control_flag))

            self._stop_event.wait(.100)


    def _motors_raw_loop(self):
        """
        Motors update thread loop
        """
        while not self._stop_event.is_set():
            with self._lock:
                self._serial.write(wifibot.construct_serial_motors_packet(\
                                    self._left_speed, self._right_speed,
                                    self._control_flag))

            # Wait a little (outside of the lock scope)
            self._stop_event.wait(.100)


    def _thread_start(self):
        """
        Starts the control thread
        """
        # Reset controls
        self.reset()

        # Reset the event, to be sure
        self._stop_event.clear()

        # Prepare the threads
        if self._socket is not None:
            self._thread = threading.Thread(target=self._motors_tcp_loop)
            self._read_thread = threading.Thread(target=self._data_tcp_loop)

        elif self._serial is not None:
            self._thread = threading.Thread(target=self._motors_raw_loop)

        else:
            raise Exception("Neither socket nor serial connection available")

        # Start the threads
        self._thread.daemon = True
        self._thread.start()

        if self._read_thread is not None:
            self._read_thread.daemon = True
            self._read_thread.start()
