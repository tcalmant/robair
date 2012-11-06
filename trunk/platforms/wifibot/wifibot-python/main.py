#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

import pelix.framework as pelix
import logging
import signal
import sys

try:
    # Disable XMPP debugging
    import xmpp.debug
    xmpp.debug.Debug = xmpp.debug.NoDebug

except:
    pass

# ------------------------------------------------------------------------------

BUNDLES = ('httpsvc',  # The HTTP service
           'com_http',  # The HTTP control servlet
           'com_xmpp',  # The XMPP control client
           'order_dispatcher',  # The order dispatcher
           'ctrl_wifibot',  # The wifibot controller
           'pelix.shell.core',
           'pelix.shell.ipopo',
           'pelix.shell.remote'
           )

def main():
    """
    Program entry point
    """
    _logger = logging.getLogger("robair.main")

    props = {
             'http.port': 8000,
             # Change if the script is ran outside the robo
             'wifibot.server': 'localhost',
             'wifibot.port': 15020,
             # TODO: to change according to your XMPP provider
             'xmpp.domain': 'localhost', # gmail.com for GTalk
             'xmpp.server': 'localhost', # talk.google.com for GTalk
             'xmpp.userid': 'robair', # User ID, without @gmail.com
             'xmpp.password': 'robair',
             }

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
