#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

from pelix.ipopo.decorators import ComponentFactory, Instantiate, Validate, \
    Invalidate, Property, Provides
import pelix.framework as pelix

import wifibot_helper

import logging
_logger = logging.getLogger(__name__)

# ------------------------------------------------------------------------------

ORDER_HANDLER = 'robair.handler.order'
ORDER_TARGETS = 'robair.handler.targets'

@ComponentFactory("wifibot-tcp-controller")
@Instantiate('wifibot-tcp-controller')
@Provides(('robair.control', ORDER_HANDLER), '_svc_controller')
@Property('_order_target', ORDER_TARGETS, 'robot')
@Property('_server', 'wifibot.server', '192.168.16.173')
@Property('_port', 'wifibot.port', 15020)
class WifibotController(object):
    """
    Wifibot TCP controller component
    """
    def __init__(self):
        """
        Sets up the object
        """
        self._robot = None
        self._svc_controller = False

        self._server = None
        self._port = None


    def handle_order(self, target, command, extra):
        """
        Handles a direct order
        """
        if target != 'robot':
            # Not for us
            raise Exception('Unhandled target: {0}'.format(target))

        if command == 'get':
            return self.get_data()

        elif command == 'reset':
            self.reset()
            return "Control reset"

        elif command == 'set':

            if 'speed' in extra:
                speedL = speedR = extra['speed']

            else:
                speedL = extra['speedL']
                speedR = extra['speedR']

            self.set_motors(speedL, speedR)
            return "Speed set: left {0}; right {1}".format(speedL, speedR)

        else:
            raise Exception('Unknown command: {0}'.format(command))


    def get_data(self):
        """
        Retrieves the last read data
        """
        return self._robot.get_data()


    def reset(self):
        """
        Resets the robot control
        """
        self._robot.reset()


    def set_motors(self, speed_left, speed_right):
        """
        Sets the motors speed
        """
        self._robot.set_motors(speed_left, speed_right)


    def robot_connected(self):
        """
        Called back by the Wifibot handler method when the connection succeeds
        """
        _logger.info("Robot connected. Activating robot control service")
        self._svc_controller = True


    def robot_lost(self):
        """
        Called back by the Wifibot handler method when the connection is lost
        """
        _logger.info("Robot lost. Deactivating robot control service")
        self._svc_controller = False


    @Validate
    def validate(self, context):
        """
        Component validation
        """
        self._svc_controller = False
        self._robot = wifibot_helper.Wifibot(self)
        self._robot.start_tcp(self._server, int(self._port), blocking=False)
        _logger.info("Robot controller validated")


    @Invalidate
    def invalidate(self, context):
        """
        Component invalidation
        """
        _logger.info("Robot controller invalidated")
        self._robot.stop()
        self._robot = None
