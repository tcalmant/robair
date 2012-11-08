/**
 * 
 */
package fr.imag.erods.robair.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Property;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.Validate;

import fr.imag.erods.robair.IRobotCommunication;
import fr.imag.erods.robair.IRobotController;

/**
 * @author Thomas Calmant
 */
@Component(name = "robair-controller-factory")
@Provides(specifications = IRobotController.class)
@Instantiate(name = "robair-controller")
public class RobotController implements IRobotController {

	/** "get_speed" command */
	private static final String CMD_GET_SPEED = "get_speed";

	/** "reset" command */
	private static final String CMD_RESET = "reset";

	/** "set" command */
	private static final String CMD_SET = "set";

	/** Command name in order map */
	private static final String ORDER_CMD = "cmd";

	/** Target name in order map */
	private static final String ORDER_TARGET = "target";

	/** Left speed */
	private static final String PARAM_SPEED_LEFT = "speedL";

	/** Right speed */
	private static final String PARAM_SPEED_RIGHT = "speedR";

	/** The communication service */
	@Requires
	private IRobotCommunication[] pCommunications;

	/** The command sender */
	private ExecutorService pExecutor;

	/** The robot XMPP address */
	@Property(name = "robot.xmpp.address", value = "tom87.21@gmail.com")
	private String pRobotXmppAddress;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imag.erods.robair.IRobotController#getMotorsSpeed()
	 */
	@Override
	public int[] getMotorsSpeed() {

		// Send the order
		final Future<Map<String, ?>> future = sendCommand(CMD_GET_SPEED, null);

		final int[] result = new int[2];
		result[0] = 1024;
		result[1] = -1024;

		try {
			final Map<String, ?> cmdResult = future.get(5, TimeUnit.SECONDS);

			// Compute the value content
			final Integer leftSpeed = (Integer) cmdResult.get(PARAM_SPEED_LEFT);
			final Integer rightSpeed = (Integer) cmdResult
					.get(PARAM_SPEED_RIGHT);

			if (leftSpeed != null) {
				result[0] = leftSpeed;
			}

			if (rightSpeed != null) {
				result[1] = rightSpeed;
			}

		} catch (final InterruptedException e) {
			System.out.println("getMotorsSpeed(): interrupted");

		} catch (final ExecutionException e) {
			System.out.println("getMotorsSpeed(): error during call");
			e.printStackTrace();

		} catch (final TimeoutException e) {
			System.out.println("getMotorsSpeed(): time out expired");
		}

		return result;
	}

	/**
	 * Component invalidated
	 */
	@Invalidate
	public void invalidate() {

		// Send a final reset
		pExecutor.shutdownNow();
		reset();
		try {
			pExecutor.awaitTermination(5, TimeUnit.SECONDS);

		} catch (final InterruptedException e) {
			// Do nothing...
		}

		// Clean up
		pExecutor.shutdownNow();
		pExecutor = null;
	}

	/**
	 * Normalizes the speed between -60 and +60
	 * 
	 * @param aSpeed
	 *            A speed value
	 * @return A speed value between -60 and +60
	 */
	private int normalizeSpeed(final int aSpeed) {

		if (aSpeed < -60) {
			return -60;
		}

		if (aSpeed > 60) {
			return 60;
		}

		return aSpeed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imag.erods.robair.IRobotController#reset()
	 */
	@Override
	public void reset() {

		sendCommand(CMD_RESET, null);
	}

	/**
	 * Sends a robot command
	 * 
	 * @param aCommand
	 *            A command name
	 * @param aParameters
	 *            Command arguments if any
	 * @return The future result
	 */
	private Future<Map<String, ?>> sendCommand(final String aCommand,
			final Map<String, Object> aParameters) {

		// Prepare a map
		final Map<String, Object> command = new HashMap<>();
		if (aParameters != null) {
			// Copy parameters
			command.putAll(aParameters);
		}

		command.put(ORDER_TARGET, "robot");
		command.put(ORDER_CMD, aCommand);

		// Send the message
		final Callable<Map<String, ?>> job = new Callable<Map<String, ?>>() {

			@Override
			public Map<String, ?> call() throws Exception {
				// Call the runner method
				return sendRunner(toJson(command));
			}
		};

		return pExecutor.submit(job);
	}

	/**
	 * Method to be ran in the sending thread
	 * 
	 * @param aData
	 *            Data to send
	 */
	private Map<String, ?> sendRunner(final String aData) {

		for (final IRobotCommunication com : pCommunications) {
			try {
				return com.sendMessage(pRobotXmppAddress, aData);

			} catch (final Exception ex) {
				ex.printStackTrace();
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imag.erods.robair.IRobotController#setMotors(int, int)
	 */
	@Override
	public void setMotors(final int aSpeedLeft, final int aSpeedRight) {

		// Prepare the order
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(PARAM_SPEED_LEFT, normalizeSpeed(aSpeedLeft));
		parameters.put(PARAM_SPEED_RIGHT, normalizeSpeed(aSpeedRight));

		// Send the message
		sendCommand(CMD_SET, parameters);
	}

	/**
	 * Converts the given map to a JSON object
	 * 
	 * @param aCommand
	 *            A command representation map
	 * @return A JSON string
	 */
	private String toJson(final Map<String, Object> aCommand) {

		final StringBuilder builder = new StringBuilder();
		builder.append("{");

		for (final Entry<String, Object> entry : aCommand.entrySet()) {

			// Set the key name
			builder.append("\"").append(entry.getKey()).append("\":");

			// Set the value
			final Object value = entry.getValue();
			if (value instanceof CharSequence) {
				builder.append("\"").append(value.toString()).append("\"");
			} else {
				builder.append(String.valueOf(value));
			}

			// Add a trailing comma
			builder.append(",\n");
		}

		// Remove the last comma
		builder.replace(builder.length() - 2, builder.length() - 1, "");

		builder.append("}");
		return builder.toString();
	}

	/**
	 * Component validated
	 */
	@Validate
	public void validate() {

		pExecutor = Executors.newSingleThreadScheduledExecutor();
	}
}
