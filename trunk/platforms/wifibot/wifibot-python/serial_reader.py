#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

from pelix.ipopo.decorators import ComponentFactory, Instantiate, Validate, \
    Invalidate, Property, Provides, Bind, Unbind, Requires
import pelix.framework as pelix

import serial
import threading

import logging
_logger = logging.getLogger(__name__)

# ------------------------------------------------------------------------------

SERIAL_LISTENER = 'serial.nmea.listener'

@ComponentFactory("serial-nmea-listener-factory")
@Instantiate("serial-nmea-listener")
@Provides('serial.nmea.reader')
@Requires('_raw_listeners', SERIAL_LISTENER, True, True)
class SerialNMEAReader(object):
    """
    Reads data from serial ports
    """
    def __init__(self):
        """
        Sets up the object
        """
        self._raw_listeners = []
        self._listeners = {}
        self._lock = threading.Lock()

        self._ports = {}

        self._events = {}
        self._threads = {}


    def __read_port(self, com_port, baud_rate, stop_event):
        """
        Reads the lines of the given serial port
        """
        serport = None

        while not stop_event.is_set():
            # Open the COM port
            while serport is None:
                try:
                    serport = serial.Serial(com_port, baud_rate)
                    # Success
                    _logger.info("Serial port %s opened at %s", com_port,
                                 baud_rate)
                    break

                except:
                    _logger.error("Port %s can't be open yet...", com_port)

                # Wait until next try
                stop_event.wait(1)

            try:
                while not stop_event.is_set():
                    # Read the line
                    try:
                        line = serport.readline()

                    except Exception as ex:
                        # Break the loop
                        _logger.critical("Error reading from %s: %s",
                                         com_port, ex)
                        break

                    # Notify listeners
                    self.__notify_listeners(line)

            finally:
                serport.close()
                serport = None


    def __notify_listeners(self, line):
        """
        Notifies the listeners that 
        """
        # Ignore the checksum
        data = line.split('*')[0]

        # Extract parts
        parts = data.split(',')

        # Call listeners according to the kind of line
        kind = parts[0]
        with self._lock:
            for listener in self._listeners.get(kind, []):
                try:
                    listener.handle_nmea_data(parts)

                except Exception as ex:
                    _logger.exception("Error notifying listener: %s", ex)


    def open_port(self, com_port, baud_rate):
        """
        Opens a serial port reading thread
        """
        # Start the reading thread
        event = threading.Event()
        thread = threading.Thread(target=self.__read_port,
                                  args=(com_port, baud_rate, event))
        thread.daemon = True

        self._events[com_port] = event
        self._threads[com_port] = thread

        thread.start()


    def close_port(self, com_port):
        """
        Closes the serial port
        """
        if com_port in self._events:
            self._events[com_port].set()
            del self._events[com_port]

        if com_port in self._threads:
            self._threads[com_port].join()
            del self._threads[com_port]


    @Bind
    def bind(self, svc, svc_ref):
        """
        Called by iPOPO when a service is bound
        """
        if SERIAL_LISTENER in svc_ref.get_property(pelix.OBJECTCLASS):
            kinds = svc_ref.get_property('nmea.kinds')
            with self._lock:
                if isinstance(kinds, list) or isinstance(kinds, tuple):
                    for kind in kinds:
                        self._listeners.setdefault(kind, []).append(svc)

                else:
                    self._listeners.setdefault(str(kinds), []).append(svc)


    @Unbind
    def unbind(self, svc, svc_ref):
        """
        Called by iPOPO when a service is gone
        """
        if SERIAL_LISTENER in svc_ref.get_property(pelix.OBJECTCLASS):
            kinds = svc_ref.get_property('nmea.kinds')

            with self._lock:
                if isinstance(kinds, list) or isinstance(kinds, tuple):
                    for kind in kinds:
                        listeners = self._listeners.get(kind, None)
                        if listeners is not None and svc in listeners:
                            listeners.remove(svc)

                else:
                    listeners = self._listeners.get(str(kinds), None)
                    if listeners is not None and svc in listeners:
                        listeners.remove(svc)


    @Invalidate
    def invalidate(self, context):
        """
        Component invalidated
        """
        # Stop all threads
        for event in self._events.values():
            event.set()

        # Wait for all threads
        for thread in self._threads.values():
            thread.join(1)

        self._events.clear()
        self._threads.clear()


    @Validate
    def validate(self, context):
        """
        Component validated
        """
        self._events.clear()
        self._threads.clear()
