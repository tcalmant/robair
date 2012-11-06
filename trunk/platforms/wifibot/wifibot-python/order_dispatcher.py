#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

from pelix.ipopo.decorators import ComponentFactory, Instantiate, Validate, \
    Invalidate, Property, Requires, Provides
import pelix.framework as pelix

import logging
import json
import threading
import xmpp

_logger = logging.getLogger(__name__)

# ------------------------------------------------------------------------------

@ComponentFactory("order-dispatcher-factory")
@Instantiate("order-dispatcher")
@Provides('robair.order.dispatcher')
@Requires('_robot', 'robair.control', optional=True)
class OrderDispatcher(object):
    """
    The XMPP communication component
    """
    def __init__(self):
        """
        Sets up the object
        """
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

            target = order['target']
            cmd = order['cmd']

            if target == 'robot':
                if cmd == 'set':
                    if 'speedL' in order:
                        speedL = order['speedL']
                        speedR = order.get('speedR', speedL)

                    elif 'speed' in order:
                        speedL = speedR = order['speed']

                    self._robot.set_motors(speedL, speedR)
                    return "Speed set: left {0}; right {1}" \
                        .format(speedL, speedR)

                elif cmd == 'reset':
                    self._robot.reset()
                    return "Control reset"

                elif cmd == 'get':
                    return json.dumps(self._robot.get_data())

                else:
                    raise Exception("Unknown command '{0}' for target '{1}'" \
                                    .format(cmd, target))

            else:
                raise Exception("Unknown target: {0}".format(target))

        return "No result for command '{0}' on target '{1}'".format(cmd, target)


    @Validate
    def validate(self, context):
        """
        Component validation"
        """
        _logger.info("OrderDispatcher validated")


    @Invalidate
    def invalidate(self, context):
        """
        Component invalidation"
        """
        _logger.info("OrderDispatcher invalidated")
