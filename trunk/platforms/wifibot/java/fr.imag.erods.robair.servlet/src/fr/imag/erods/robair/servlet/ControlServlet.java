/**
 * 
 */
package fr.imag.erods.robair.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.felix.ipojo.annotations.Bind;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Property;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.Unbind;
import org.apache.felix.ipojo.annotations.Validate;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

import fr.imag.erods.robair.IRobotController;

/**
 * Servlet to redirect orders to the robot
 * 
 * @author Thomas Calmant
 */
@Component(name = "robair-control-servlet-factory")
@Instantiate(name = "robair-control-servlet")
public class ControlServlet extends HttpServlet {

	/** The iPOJO dependency ID */
	private static final String IPOJO_DEP_CONTROLLER = "robot-controller";

	/** Serialization UID */
	private static final long serialVersionUID = 1L;

	/** The robot controller */
	@Requires(id = IPOJO_DEP_CONTROLLER, optional = true)
	private IRobotController pController;

	/** Controller presence flag */
	private boolean pControllerPresent = false;

	/** The HTTP Service */
	@Requires
	private HttpService pHttpService;

	/** The servlet path */
	@Property(name = "robair.control.servlet.path")
	private final String pPath = "/control";

	/**
	 * Called when a robot controller is bound
	 * 
	 * @param aController
	 */
	@Bind(id = IPOJO_DEP_CONTROLLER)
	protected void bindController(final IRobotController aController) {
		pControllerPresent = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(final HttpServletRequest aReq,
			final HttpServletResponse aResp) throws ServletException,
			IOException {

		final StringBuilder builder = new StringBuilder();
		builder.append("<html>\n<head>\n<title>RobAIR Control</title>\n</head>\n");
		builder.append("<body>\n<h1>RobAIR Control</h1>\n");
		builder.append("<p>RobAIR command servlet is active.</p>\n");
		builder.append("<p>RobAIR control service is ");
		if (pControllerPresent) {
			builder.append("active");
		} else {
			builder.append("missing");
		}

		builder.append(".</p>\n</body>\n</html>\n");

		// Send the page
		aResp.setContentType("text/html");
		aResp.setContentLength(builder.length());
		aResp.getWriter().write(builder.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(final HttpServletRequest aReq,
			final HttpServletResponse aResp) throws ServletException,
			IOException {

		if (!pControllerPresent) {
			// No controller present: send a 500
			aResp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}

		int code;
		String message;
		try {
			// Parse the POST content
			final JSONObject order = readJson(aReq.getReader());

			// Execute the order and send the response
			executeOrder(order);

			code = HttpServletResponse.SC_OK;
			message = "Success";

		} catch (final Exception ex) {
			// An error occurred
			code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			message = ex.toString();

			ex.printStackTrace();
		}

		// Send the response
		aResp.setStatus(code);
		aResp.getWriter().write(message);
	}

	/**
	 * Executes the given order
	 * 
	 * @param aOrder
	 * @return
	 * @throws Exception
	 */
	private void executeOrder(final JSONObject aOrder) throws Exception {

		final String target = aOrder.getString("target");
		final String command = aOrder.getString("cmd");

		if (!target.equals("robot")) {
			// Not for us
			throw new Exception("Unknown command target: " + target);
		}

		if (command.equals("reset")) {
			// Reset the motors
			pController.reset();

		} else if (command.equals("set")) {
			// Set the motors speeds
			final int speedL = aOrder.getInt("speedL");
			final int speedR = aOrder.getInt("speedR");

			pController.setMotors(speedL, speedR);

		} else {
			// Unknown command
			throw new Exception("Unknown command: " + command);
		}
	}

	/**
	 * Component invalidated
	 */
	@Invalidate
	public void invalidate() {

		// Unregister the servlet
		pHttpService.unregister(pPath);
	}

	/**
	 * Reads the JSON object in the given reader
	 * 
	 * @param aReader
	 *            A buffered reader
	 * @return The parsed JSON content
	 * @throws IOException
	 *             Error reading the buffer
	 * @throws JSONException
	 *             Error parsing the data
	 */
	private JSONObject readJson(final BufferedReader aReader)
			throws IOException, JSONException {

		final StringBuilder builder = new StringBuilder();

		String line = null;
		while ((line = aReader.readLine()) != null) {
			builder.append(line);
		}

		return new JSONObject(builder.toString());
	}

	/**
	 * Called when a robot controller is gone
	 * 
	 * @param aController
	 */
	@Unbind(id = IPOJO_DEP_CONTROLLER)
	protected void unbindController(final IRobotController aController) {

		pControllerPresent = false;
	}

	/**
	 * Component validated
	 */
	@Validate
	public void validate() {

		try {
			pHttpService.registerServlet(pPath, this, null, null);
			System.out.println("Control servlet validated");

		} catch (final ServletException e) {
			e.printStackTrace();

		} catch (final NamespaceException e) {
			e.printStackTrace();
		}
	}
}
