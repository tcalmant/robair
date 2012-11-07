#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

from pelix.ipopo.decorators import ComponentFactory, Instantiate, Validate, \
    Invalidate, Property, Requires, Bind, Provides
import pelix.framework as pelix

import serial
import threading

import logging
_logger = logging.getLogger(__name__)

# ------------------------------------------------------------------------------

SERIAL_LISTENER = 'serial.nmea.listener'
WIIMOTE_LISTENER = 'arduino.wiimote.listener'

@ComponentFactory("arduino-wiimote-factory")
@Instantiate("arduino-wiimote")
@Provides(SERIAL_LISTENER)
@Requires('_listeners', WIIMOTE_LISTENER, True, True)
@Requires('_serial', 'serial.nmea.reader')
@Property('_nmea_kinds', 'nmea.kinds', '$WICHK')
@Property('_com_port', 'com.port', '/dev/ttyUSB0')
@Property('_baud_rate', 'com.baud_rate', 19200)
@Property('_threshold', 'data.threshold', 2)
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
        self._nmea_kinds = None

        self._lock = threading.Lock()
        self._threshold = 0
        self._values = {}

        self._serial = None
        self._listeners = []


    def __notify_listeners(self, values):
        """
        Notifies listeners of the given read value.
        """
        if not self._listeners:
            return

        for listener in self._listeners[:]:
            listener.handle_wiimote_values(values)


    @Bind
    def _bind(self, svc, svc_ref):
        """
        Called when a dependency is bound
        """
        if WIIMOTE_LISTENER in svc_ref.get_property(pelix.OBJECTCLASS):
            with self._lock:
                if self._values:
                    svc.handle_wiimote_values(self._values.copy())


    def _parse_nmea(self, parts):
        """
        Parses an Arduino Wiimote line:
        
        $WICHK,JOYX,JOYY,ACCX,ACCY,ACCZ,ZBUT,CBUT*CHECKSUM
        
        .. important:: Must be called with self._lock acquired 
        """
        idx = 1
        needs_update = False

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

        return needs_update


    def get_data(self):
        """
        Retrieves a copy of the latest read values
        """
        with self._lock:
            return self._values.copy()


    def handle_nmea_data(self, nmea_parts):
        """
        A NMEA line has been decoded
        """
        with self._lock:
            needs_update = self._parse_nmea(nmea_parts)
            values_copy = self._values.copy()

        if needs_update:
            self.__notify_listeners(values_copy)


    @Invalidate
    def invalidate(self, context):
        """
        Component invalidated
        """
        # Close the port
        self._serial.close_port(self._com_port)


    @Validate
    def validate(self, context):
        """
        Component validated
        """
        # Open the port
        self._serial.open_port(self._com_port, int(self._baud_rate))
