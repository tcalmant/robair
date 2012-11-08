#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

from pelix.ipopo.decorators import ComponentFactory, Instantiate, Validate, \
    Invalidate, Property, Requires
import pelix.framework as pelix

import logging
import json
import threading
import xmpp

_logger = logging.getLogger(__name__)

# ------------------------------------------------------------------------------

@ComponentFactory("robot-com-gtalk-factory")
@Instantiate("robot-com-gtalk")
@Requires('_dispatcher', 'robair.order.dispatcher')
@Property('_domain', 'xmpp.domain')
@Property('_server', 'xmpp.server')
@Property('_user', 'xmpp.userid')
@Property('_password', 'xmpp.password')
class RobotGtalkCom(object):
    """
    The XMPP communication component
    """
    def __init__(self):
        """
        Sets up the object
        """
        self._xmpp = None
        self._thread = None
        self._stop_event = threading.Event()

        self._dispatcher = None
        self._domain = None
        self._server = None
        self._user = None
        self._password = None


    def _send(self, to_jid, message, *args, **kwargs):
        """
        Sends the XMPP message
        """
        if args or kwargs:
            # Format the message if needed
            message = message.format(*args, **kwargs)

        if message and self._xmpp:
            self._xmpp.send(xmpp.Message(to_jid, message))


    def _xmpp_message(self, con, event):
        """
        XMPP message handler
        """
        cmd = event.getType()
        fromjid = event.getFrom().getStripped()
        if cmd in ('message', 'chat', None):

            try:
                # Parse the message
                order = json.loads(event.getBody())

            except Exception as ex:
                # Error parsing the JSON order
                self._send(fromjid, "Error reading the JSON content: {0}", ex)
                return

            try:
                # Execute the order
                result = self._dispatcher.execute_order(order)
                self._send(fromjid, result)

            except Exception as ex:
                # Error executing order
                self._send(fromjid, "Error executing the order: {0}", ex)
                return


    def _xmpp_thread(self):
        """
        Processes XMPP events until stop event is set
        """
        while not self._stop_event.is_set():
            if not self._xmpp.Process(1):
                self._stop_event.set()


    @Validate
    def validate(self, context):
        """
        Component validation
        """
        # Connect to gTalk
        # self._xmpp = xmpp.Client('gmail.com')
        #  self._xmpp.connect(server=('talk.google.com', 5223))
        self._xmpp = xmpp.Client(self._domain)
        self._xmpp.connect(server=(self._server, 5223))
        self._xmpp.auth(self._user, self._password, 'botty')
        self._xmpp.RegisterHandler('message', self._xmpp_message)

        # Start the message handler
        self._stop_event.clear()
        self._thread = threading.Thread(target=self._xmpp_thread)
        self._thread.daemon = True
        self._thread.start()

        # Show us
        self._xmpp.send(xmpp.Presence(show="available"))

        _logger.info("XMPP Com servlet validated")


    @Invalidate
    def invalidate(self, context):
        """
        Component invalidation
        """
        _logger.info("XMPP Com servlet invalidated")

        # Say we're away
        self._xmpp.send(xmpp.Presence(show="away"))

        # Stop the message handler
        self._stop_event.set()
        if self._thread is not None:
            self._thread.join()
            self._thread = None

        # Disconnect
        if self._xmpp is not None:
            self._xmpp.disconnect()
            self._xmpp = None
