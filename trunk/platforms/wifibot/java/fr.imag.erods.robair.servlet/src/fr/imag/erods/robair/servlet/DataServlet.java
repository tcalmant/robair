/**
 * 
 */
package fr.imag.erods.robair.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

import fr.imag.erods.robair.IRobotDataListener;

/**
 * Servlet to redirect orders to the robot
 * 
 * @author Thomas Calmant
 */
@Component(name = "robair-data-servlet-factory")
@Instantiate(name = "robair-data-servlet")
public class DataServlet extends HttpServlet {

	/** iPOJO dependency ID */
	private static final String IPOJO_DEP_LISTENERS = "data-listeners";

	/** Serialization UID */
	private static final long serialVersionUID = 1L;

	/** The HTTP Service */
	@Requires
	private HttpService pHttpService;

	/** Listeners */
	private final Map<String, List<IRobotDataListener>> pListeners = new LinkedHashMap<String, List<IRobotDataListener>>();

	/** The servlet path */
	@Property(name = "robair.control.servlet.path")
	private final String pPath = "/data";

	/**
	 * Called by iPOJO when a listener is bound
	 * 
	 * @param aListener
	 */
	@Bind(id = IPOJO_DEP_LISTENERS, aggregate = true, optional = true)
	protected void bindListener(final IRobotDataListener aListener) {

		final String[] devices = aListener.getDevices();
		if (devices != null) {

			for (final String device : devices) {

				List<IRobotDataListener> devListeners = pListeners.get(device);
				if (devListeners == null) {
					devListeners = new LinkedList<IRobotDataListener>();
					pListeners.put(device, devListeners);
				}

				if (!devListeners.contains(aListener)) {
					devListeners.add(aListener);
				}
			}
		}
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
		builder.append("<html>\n<head>\n<title>RobAIR Data</title>\n</head>\n");
		builder.append("<body>\n<h1>RobAIR Data</h1>\n");
		builder.append("<p>RobAIR data servlet is active.</p>\n");
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

		int code;
		String message;
		try {
			// Parse the POST content
			final JSONObject data = readJson(aReq.getReader());

			// Notify listeners
			notifyData(data);

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
	 * Component invalidated
	 */
	@Invalidate
	public void invalidate() {

		// Unregister the servlet
		pHttpService.unregister(pPath);
	}

	/**
	 * Converts a JSON object to a map
	 * 
	 * @param aData
	 * @return
	 * @throws JSONException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, ?> jsonToMap(final JSONObject aData)
			throws JSONException {

		final Map<String, Object> result = new LinkedHashMap<>();

		final Iterator<String> keys = aData.keys();
		while (keys.hasNext()) {
			final String key = keys.next();
			final Object value = aData.get(key);
			result.put(key, value);
		}

		return result;
	}

	/**
	 * Handle a data update
	 * 
	 * @param aData
	 *            Data content
	 * @throws JSONException
	 *             Error reading the stream
	 */
	private void notifyData(final JSONObject aData) throws JSONException {

		// Get the sending device
		final String device = aData.getString("device");

		// Notify listeners
		final List<IRobotDataListener> listeners = pListeners.get(device);
		if (listeners != null) {

			// Convert the JSON to a map
			final Map<String, ?> mapData = jsonToMap(aData);

			// Notify listeners
			for (final IRobotDataListener listener : listeners) {

				try {
					listener.handleData(device, mapData);

				} catch (final Exception ex) {
					System.err.println("Error notifying listener");
					ex.printStackTrace();
				}
			}
		}
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
	 * Called by iPOJO when a listener is gone
	 * 
	 * @param aListener
	 */
	@Unbind(id = IPOJO_DEP_LISTENERS)
	protected void unbindListener(final IRobotDataListener aListener) {

		for (final List<IRobotDataListener> devListeners : pListeners.values()) {
			devListeners.remove(aListener);
		}
	}

	/**
	 * Component validated
	 */
	@Validate
	public void validate() {

		try {
			pHttpService.registerServlet(pPath, this, null, null);
			System.out.println("Data servlet validated");

		} catch (final ServletException e) {
			e.printStackTrace();

		} catch (final NamespaceException e) {
			e.printStackTrace();
		}
	}
}
