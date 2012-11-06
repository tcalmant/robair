#!/usr/bin/python
# -- Content-Encoding: UTF-8 --

from pelix.ipopo.decorators import ComponentFactory, Instantiate, Validate, \
    Invalidate, Property, Requires
import pelix.framework as pelix

import logging
import json
import threading

_logger = logging.getLogger(__name__)

# ------------------------------------------------------------------------------

def read_from_handler(handler):
    """
    Reads POST data from the HTTP handler
    
    :param handler: A HTTP request handler
    :return: The data read from the request
    """
    max_chunk_size = 10 * 1024 * 1024
    size_remaining = int(handler.headers["content-length"])
    chunks_list = []
    while size_remaining:
        chunk_size = min(size_remaining, max_chunk_size)
        chunks_list.append(handler.rfile.read(chunk_size).decode())
        size_remaining -= len(chunks_list[-1])

    return ''.join(chunks_list)


def send_page(handler, code, title, message, *args, **kwargs):
    """
    Sends a small message in an HTML page
    """
    # Prepare the HTML
    response = """<html>
<head>
<title>{title}</title>
</head>
<body>
<h1>{title}</h1>
<p>{message}</p>
</body>
</html>""".format(title=title, message=message)

    if args or kwargs:
        # Fill the holes if needed
        response = response.format(*args, **kwargs)

    handler.send_response(code)
    handler.send_header("Content-type", "text/html")
    handler.send_header("Content-length", str(len(response)))
    handler.end_headers()
    handler.wfile.write(response)
    handler.wfile.flush()

# ------------------------------------------------------------------------------

@ComponentFactory("robot-com-http-factory")
@Instantiate("robot-com-http")
@Requires('_http', 'HttpService')
@Requires('_dispatcher', 'robair.order.dispatcher')
class RobotHttpCom(object):
    """
    The XMPP communication component
    """
    def __init__(self):
        """
        Sets up the object
        """
        self._dispatcher = None


    def do_GET(self, handler):
        """
        Handles a 'GET' request: prints the robot dependency state
        """
        if self._dispatcher.is_active():
            control_state = "Active"

        else:
            control_state = "Absent"

        send_page(handler, 200, "RobAIR HTTP Com",
                  "Robot control service is {0}", control_state)


    def do_POST(self, handler):
        """
        Handles a 'POST' request
        """
        try:
            # Parse the content
            data = read_from_handler(handler)
            order = json.loads(data)

        except Exception as ex:
            # Error parsing the JSON order
            _logger.exception("Error parsing JSON: %s\n%s", ex, data)
            send_page(handler, 500, "Exception",
                      "Error reading the JSON content: {0}", ex)
            return


        try:
            # Execute the order
            result = self._dispatcher.execute_order(order)
            send_page(handler, 200, "Success", result)

        except Exception as ex:
            # Error executing order
            _logger.exception("Error executing the order: %s", ex)
            send_page(handler, 500, "Exception",
                      "Error executing the order: {0}", ex)
            return


    @Validate
    def validate(self, context):
        """
        Component validation
        """
        self._http.register_servlet('/robair', self)
        _logger.info("HTTP Com servlet validated")


    @Invalidate
    def invalidate(self, context):
        """
        Component invalidation
        """
        _logger.info("HTTP Com servlet invalidated")
        self._http.unregister_servlet(self)
