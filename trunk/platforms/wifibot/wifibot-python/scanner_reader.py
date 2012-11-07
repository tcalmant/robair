#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

from pelix.ipopo.decorators import ComponentFactory, Instantiate, Validate, \
    Invalidate, Property, Requires, Bind, Provides
import pelix.framework as pelix

import threading

import logging
_logger = logging.getLogger(__name__)

# ------------------------------------------------------------------------------

SERIAL_LISTENER = 'serial.nmea.listener'
FLAME_LISTENER = 'robair.flame.listener'
SCANNER_LISTENER = 'robair.scanner.listener'

# ------------------------------------------------------------------------------

@ComponentFactory("arduino-flame-factory")
@Instantiate("arduino-flame")
@Provides(SERIAL_LISTENER)
@Requires('_serial', 'serial.nmea.reader')
@Requires('_listeners', FLAME_LISTENER, True, True)
@Property('_nmea_kinds', 'nmea.kinds', '$FLAME')
@Property('_com_port', 'com.port', '/dev/ttyUSB0')
@Property('_baud_rate', 'com.baud_rate', 4800)
class FlameNotifier(object):
    """
    Reads lines from the flame detector
    """
    def __init__(self):
        """
        Sets up the object
        """
        self._baud_rate = 0
        self._com_port = None
        self._nmea_kinds = None

        self._listeners = []
        self._serial = None

        self._lock = threading.Lock()
        self._values = {}


    def __notify_listeners(self, values):
        """
        Notifies listeners of the given read value.
        """
        if not self._listeners:
            return

        for listener in self._listeners[:]:
            listener.handle_flame_values(values)


    def _parse_nmea(self, parts):
        """
        Parses a Scanner line:
        
        $FLAME,FLAME_DETECT_ANA,FLAME_DETC_DIO*CHECKSUM
        
        .. important:: Must be called with self._lock acquired
        """
        idx = 1
        needs_update = False

        for key in ('analogicValue', 'flameDetected'):
            new_value = int(parts[idx])
            cur_value = self._values.get(key, None)

            if cur_value != new_value:
                # Value needs to be updated
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


    @Bind
    def _bind(self, svc, svc_ref):
        """
        Called when a dependency is bound
        """
        if FLAME_LISTENER in svc_ref.get_property(pelix.OBJECTCLASS):
            with self._lock:
                if self._values:
                    svc.handle_flame_values(self._values.copy())


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

# ------------------------------------------------------------------------------

@ComponentFactory("arduino-scanner-factory")
@Instantiate("arduino-scanner")
@Provides(SERIAL_LISTENER)
@Requires('_serial', 'serial.nmea.reader')
@Requires('_listeners', SCANNER_LISTENER, True, True)
@Property('_nmea_kinds', 'nmea.kinds', '$USDIS')
@Property('_com_port', 'com.port', '/dev/ttyUSB0')
@Property('_baud_rate', 'com.baud_rate', 4800)
class ScannerNotifier(object):
    """
    Reads lines from the 'sonar'
    """
    def __init__(self):
        """
        Sets up the object
        """
        self._baud_rate = 0
        self._com_port = None
        self._nmea_kinds = None

        self._listeners = []
        self._serial = None

        self._lock = threading.Lock()
        self._values = {}


    def __notify_listeners(self, values):
        """
        Notifies listeners of the given read value.
        """
        if not self._listeners:
            return

        for listener in self._listeners[:]:
            listener.handle_scanner_values(values)


    def _parse_nmea(self, parts):
        """
        Parses a Scanner line:
        
        $USDIS,LEFT_DISTANCE_IN_CM,CENTER_DISTANCE_IN_CM,RIGHT_DISTANCE_IN_CM,SERVOPOS*CHECKSUM
        
        .. important:: Must be called with self._lock acquired
        """
        idx = 1
        needs_update = False

        for key in ('leftDist', 'centerDist', 'rightDist', 'servopos'):
            new_value = int(parts[idx])
            cur_value = self._values.get(key, None)

            if cur_value != new_value:
                # Value needs to be updated
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


    @Bind
    def _bind(self, svc, svc_ref):
        """
        Called when a dependency is bound
        """
        if SCANNER_LISTENER in svc_ref.get_property(pelix.OBJECTCLASS):
            with self._lock:
                if self._values:
                    svc.handle_scanner_values(self._values.copy())


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
