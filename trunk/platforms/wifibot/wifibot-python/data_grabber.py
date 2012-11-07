#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

from pelix.ipopo.decorators import ComponentFactory, Instantiate, Validate, \
    Invalidate, Property, Requires, Bind, Provides
import pelix.framework as pelix

import httplib
import json
import time

import logging
_logger = logging.getLogger(__name__)

# ------------------------------------------------------------------------------

FLAME_LISTENER = 'robair.flame.listener'
SCANNER_LISTENER = 'robair.scanner.listener'

@ComponentFactory("data-notifier-factory")
@Instantiate("data-notifier")
@Provides((FLAME_LISTENER, SCANNER_LISTENER))
@Property('_host', 'robair.data.server', 'localhost')
@Property('_port', 'robair.data.port', 8080)
@Property('_uri', 'robair.data.uri', '/data')
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


    def __send_notification(self, data_dict):
        """
        Sends a notification over HTTP according to the given Wiimote values
        """
        # Connect the server
        try:
            conn = httplib.HTTPConnection(self._host, self._port)

        except IOError as ex:
            _logger.error("Error connecting to [%s]:%s", self._host, self._port)
            return

        # Prepare the notification
        params = json.dumps(data_dict)
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
            _logger.error("Error sending notification to [%s]:%s", self._host,
                          self._port)
            return


    def handle_flame_values(self, values):
        """
        Notified of new values from the flame detector
        """
        data = values.copy()
        data['device'] = 'flame_detector'
        data['timestamp'] = time.time() * 1000

        self.__send_notification(data)


    def handle_scanner_values(self, values):
        """
        Notified of new values from the scanner
        """
        data = values.copy()
        data['device'] = 'scanner'
        data['timestamp'] = time.time() * 1000

        self.__send_notification(data)


    @Invalidate
    def invalidate(self, context):
        """
        Component invalidated
        """
        _logger.info("Serial data notifier invalidated")


    @Validate
    def validate(self, context):
        """
        Component validated
        """
        _logger.info("Serial data notifier validated")
