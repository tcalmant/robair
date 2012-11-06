#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

from pelix.ipopo.decorators import ComponentFactory, Instantiate, Validate, \
    Invalidate, Property, Requires, Bind
import pelix.framework as pelix

import io
import logging
import serial
import threading

_logger = logging.getLogger(__name__)

WIIMOTE_LISTENER = 'arduino.wiimote.listener'

# ------------------------------------------------------------------------------

@ComponentFactory("arduino-wiimote-factory")
@Instantiate("arduino-wiimote")
@Requires('_listeners', WIIMOTE_LISTENER, True, True)
@Property('_threshold', 'data.threshold', 2)
@Property('_com_port', 'com.port', '/dev/ttyUSB0')
@Property('_baud_rate', 'com.baud_rate', 19200)
class ArduinoWiimote(object):
    """
    Reads lines from an Arduino
    """
    def __init__(self):
        """
        Sets up the object
        """
        self._baud_rate = 0
        self._com_port = None
        self._serial = None

        self._lock = threading.Lock()
        self._threshold = 0
        self._values = {}

        self._listeners = []

        self._stop_event = threading.Event()
        self._thread = None


    def __notify_listeners(self, values):
        """
        Notifies listeners of the given read value.
        """
        if not self._listeners:
            return

        for listener in self._listeners[:]:
            listener.handleWiimoteValues(self._values.copy())


    @Bind
    def _bind(self, svc, svc_ref):
        """
        Called when a dependency is bound
        """
        if svc_ref.get_property(pelix.OBJECTCLASS) == WIIMOTE_LISTENER:
            with self._lock:
                if self._values:
                    svc.handleWiimoteValues(self._values.copy())


    def _parse_line(self, line):
        """
        Parses an Arduino Wiimote line:
        
        $WICHK,JOYX,JOYY,ACCX,ACCY,ACCZ,ZBUT,CBUT*CHECKSUM[CR][LF] 
        """
        parts = line.split('*')[0].split(',')
        if parts[0] != '$WICHK':
            # Invalid line
            return

        with self._lock:
            idx = 1
            needs_update = False
            value_copy = None

            for key in ('joyX', 'joyY'):
                new_value = int(parts[idx])
                cur_value = self._values.get(key, 1000)

                # Biased values
                if new_value >= 46:
                    new_value -= 46

                else:
                    new_value = 255 - new_value

                if abs(cur_value - new_value) > self._threshold:
                    self._values[key] = new_value
                    needs_update = True

                idx += 1

            for key in ('accX', 'accY', 'accZ'):
                new_value = int(parts[idx])
                cur_value = self._values.get(key, 1000)
                if abs(cur_value - new_value) > self._threshold:
                    self._values[key] = new_value
                    needs_update = True

                idx += 1

            for key in ('Zbut', 'Cbut'):
                new_value = (int(parts[idx]) != 0)
                cur_value = self._values.get(key, None)
                if cur_value != new_value:
                    self._values[key] = new_value
                    needs_update = True

                idx += 1

            if needs_update:
                value_copy = self._values.copy()

        if needs_update:
            self.__notify_listeners(value_copy)


    def _read_data(self):
        """
        Reads data from the serial port
        """
        if self._serial is None:
            # Nothing to do
            return

        try:
            while not self._stop_event.is_set():
                self._parse_line(self._serial.readline())

        except:
            _logger.exception("Error reading serial port")
            self._stop_event.set()


    def get_data(self):
        """
        Retrieves a copy of the latest read values
        """
        with self._lock:
            return self._values.copy()


    @Invalidate
    def invalidate(self, context):
        """
        Component invalidated
        """
        self._stop_event.set()
        if self._thread is not None:
            self._thread.join()
            self._thread = None

        if self._serial is not None:
            self._serial.close()
            self._serial = None


    @Validate
    def validate(self, context):
        """
        Component validated
        """
        self._serial = serial.Serial(self._com_port, int(self._baud_rate))
        _logger.info("Serial port %s opened at %s", self._com_port,
                     self._baud_rate)

        self._stop_event.clear()
        self._thread = threading.Thread(target=self._read_data)
        self._thread.start()
