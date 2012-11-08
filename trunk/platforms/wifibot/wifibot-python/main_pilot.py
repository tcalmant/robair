#!/usr/bin/python
# -- Content-Encoding: UTF-8 --
"""
Entry point script to run on the pilot.

Only reads the Nunchuk information and sends it to the local Java RobAIR client
"""

import pelix.framework as pelix
import logging
import signal
import sys

# ------------------------------------------------------------------------------

BUNDLES = ('serial_reader',  # The serial port reader
           'arduino_wiimote',  # The Wiimote reader
           'wiimote_notifier',  # Sends orders to the Java client
           )

def main():
    """
    Program entry point
    """
    _logger = logging.getLogger("robair.main")

    props = {}

    _logger.info("Starting the framework...")
    framework = pelix.FrameworkFactory.get_framework(props)

    _logger.info("... installing iPOPO")
    framework.install_bundle('pelix.ipopo.core')

    for bundle_name in BUNDLES:
        _logger.info("... installing %s", bundle_name)
        framework.install_bundle(bundle_name)

    _logger.info("Starting everything...")
    framework.start()

    # Register to the SIGINT signal
    def sig_handler(signal, frame):
        """
        Stops the framework on signal
        """
        _logger.info("Signal caught: stopping")
        framework.stop()

    signal.signal(signal.SIGINT, sig_handler)

    # Wait for the framework to stop
    _logger.info("Waiting for framework to stop")
    try:
        framework.wait_for_stop()
    except KeyboardInterrupt:
        # Not sufficient to stop the framework properly
        _logger.info("Keyboard interruption. Stopping.")
        framework.stop()

    return 0

# ------------------------------------------------------------------------------

if __name__ == "__main__":
    # Set up the logging system
    logging.basicConfig(level=logging.INFO)

    try:
        # Run the program
        code = main()

    except:
        logging.exception("Error running main()")
        code = -1

    sys.exit(code)
