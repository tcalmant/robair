#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

from pelix.ipopo.decorators import ComponentFactory, Instantiate, Validate, \
    Invalidate, Property, Requires, Bind, Provides
import pelix.framework as pelix

import httplib
import json

import logging
_logger = logging.getLogger(__name__)

# ------------------------------------------------------------------------------

WIIMOTE_LISTENER = 'arduino.wiimote.listener'

@ComponentFactory("wiimote-notifier-factory")
@Instantiate("wiimote-notifier")
@Provides(WIIMOTE_LISTENER)
@Property('_host', 'robair.controller.server', 'localhost')
@Property('_port', 'robair.controller.port', 8090)
@Property('_uri', 'robair.controller.uri', '/control')
class WiimoteNotifier(object):
    """
    Reads lines from an Arduino
    """
    def __init__(self):
        """
        Sets up the object
        """
        self._host = None
        self._port = 0
        self._uri = None
        self._last_speeds = (None, None)

    def __compute_speeds(self, joy_x, joy_y, boost):
        """
        Computes a tuple of (left, right) speeds
        """
        # Normalize the values (bugs over 200)
        if joy_x > 200:
            joy_x = 200

        if joy_y > 200:
            joy_y = 200

        # Compute speed according to X
        if joy_x < 30:
            speedL = -1
            speedR = 1

        elif joy_x < 70:
            speedL = -0.5
            speedR = 1

        elif joy_x > 160:
            speedL = 1
            speedR = -1

        elif joy_x > 100:
            speedL = 1
            speedR = -0.5

        else:
            speedL = 1
            speedR = 1


        if joy_y < 30:
            ratio = -20

        elif joy_y < 70:
            ratio = -10

        elif joy_y > 160:
            ratio = 20

        elif joy_y > 100:
            ratio = 10

        else:
            if speedL == speedR:
                ratio = 0

            else:
                # Robot turns on itself
                ratio = 10

        # Use the boost!
        if boost:
            ratio *= 2

        # Compute the final speed
        speedL *= ratio
        speedR *= ratio

        return (speedL, speedR)


    def __send_notification(self, values):
        """
        Sends a notification over HTTP according to the given Wiimote values
        """
        # Connect the server
        try:
            conn = httplib.HTTPConnection(self._host, self._port)

        except IOError as ex:
            _logger.error("Error connecting to [%s]:%s", self._host, self._port)
            return

        # Prepare the order
        speedL, speedR = self.__compute_speeds(values['joyX'], values['joyY'],
                                               values['Zbut'])

        if self._last_speeds != (speedL, speedR):
            # New values
            self._last_speeds = (speedL, speedR)

            params = json.dumps({'target': 'robot',
                                 'cmd': 'set',
                                 'speedL': speedL,
                                 'speedR': speedR})
            headers = {
                       'content-type': 'application/json',
                       'content-length': len(params),
                       }

            # Send it
            try:
                conn.request('POST', self._uri, params, headers)

                # Get the answer
                conn.getresponse()
                conn.close()

            except Exception as ex:
                _logger.error("Error sending order to [%s]:%s", self._host,
                              self._port)
                return


    def handle_wiimote_values(self, values):
        """
        Notified of new values
        """
        self.__send_notification(values)


    @Invalidate
    def invalidate(self, context):
        """
        Component invalidated
        """
        self._last_speeds = (None, None)
        _logger.info("Wiimote notifier invalidated")


    @Validate
    def validate(self, context):
        """
        Component validated
        """
        self._last_speeds = (None, None)
        _logger.info("Wiimote notifier validated")
