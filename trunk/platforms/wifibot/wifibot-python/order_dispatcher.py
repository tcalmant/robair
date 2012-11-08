#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

from pelix.ipopo.decorators import ComponentFactory, Instantiate, Validate, \
    Invalidate, Property, Requires, Provides, Bind, Unbind
import pelix.framework as pelix

import logging
import json
import threading
import xmpp

_logger = logging.getLogger(__name__)

# ------------------------------------------------------------------------------

ORDER_HANDLER = 'robair.handler.order'
ORDER_TARGETS = 'robair.handler.targets'

@ComponentFactory("order-dispatcher-factory")
@Instantiate("order-dispatcher")
@Provides('robair.order.dispatcher')
@Requires('_order_handlers', ORDER_HANDLER, aggregate=True, optional=True)
@Requires('_robot', 'robair.control', optional=True)
class OrderDispatcher(object):
    """
    The XMPP communication component
    """
    def __init__(self):
        """
        Sets up the object
        """
        self._order_handlers = []
        self._target_handlers = {}

        self._robot = None
        self._lock = threading.Lock()


    def is_active(self):
        """
        Tests if the dispatcher is active, i.e. if the robot controller
        dependency has been bound
        """
        with self._lock:
            return self._robot is not None


    def execute_order(self, order):
        """
        Executes the given order
        
        Order must contain the following keys:
        * 'target': the order target ('robot', 'sensor-id', ...)
        * 'cmd': the command to execute. For 'robot': 'set', 'get', 'reset'.
        
        :param order: A dictionary
        :return: A result message string
        :raise KeyError: An argument is missing in the order
        :raise Exception: An error occurred
        """
        with self._lock:
            if not self._robot:
                raise Exception("No robot control service available")

            # Get the target
            target = order['target']
            handlers = self._target_handlers.get(target, None)
            if handlers is None:
                # No handler for this target
                raise Exception("No handler for target {0}".format(target))

            # Get the command
            command = order['cmd']

            # Get the arguments, i.e. what's left
            arguments = order.copy()
            del arguments['target']
            del arguments['cmd']

            results = []
            for handler in handlers:
                # Call handlers
                try:
                    result = handler.handle_order(target, command, arguments)
                    if result is not None:
                        # Ignore None results
                        results.append(result)

                except Exception as ex:
                    # Just log it
                    _logger.exception("Error calling order handler: %s", ex)

            if len(results) == 0:
                return json.dumps({'message': 'No result'})

            if len(results) == 1:
                return json.dumps(results[0])

            else:
                return json.dumps({'results': results})


    @Bind
    def bind(self, svc, svc_ref):
        """
        Called when a dependency is bound
        """
        with self._lock:
            if ORDER_HANDLER in svc_ref.get_property(pelix.OBJECTCLASS):
                targets = svc_ref.get_property(ORDER_TARGETS)
                if isinstance(targets, (list, tuple)):
                    for target in targets:
                        self._target_handlers.setdefault(target, []).append(svc)

                else:
                    self._target_handlers.setdefault(str(targets), []).append(svc)


    @Unbind
    def unbind(self, svc, svc_ref):
        """
        Called when a dependency is gone
        """
        with self._lock:
            if ORDER_HANDLER in svc_ref.get_property(pelix.OBJECTCLASS):
                targets = svc_ref.get_property(ORDER_TARGETS)
                if isinstance(targets, (list, tuple)):
                    for target in targets:
                        associates = self._target_handlers.get(target, None)
                        if svc in associates:
                            del associates[svc]

                else:
                    associates = self._target_handlers.get(str(targets), None)
                    if svc in associates:
                        del associates[svc]

    @Validate
    def validate(self, context):
        """
        Component validation"
        """
        self._target_handlers.clear()
        _logger.info("OrderDispatcher validated")


    @Invalidate
    def invalidate(self, context):
        """
        Component invalidation"
        """
        self._target_handlers.clear()
        _logger.info("OrderDispatcher invalidated")
