/**
 * 
 */
package fr.imag.erods.robair.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Property;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Requires;

import fr.imag.erods.robair.IRobotCommunication;
import fr.imag.erods.robair.IRobotController;

/**
 * @author Thomas Calmant
 */
@Component(name = "robair-controller-factory")
@Provides(specifications = IRobotController.class)
@Instantiate(name = "robair-controller")
public class RobotController implements IRobotController {

	/** "reset" command */
	private static final String CMD_RESET = "reset";

	/** "set" command */
	private static final String CMD_SET = "set";

	/** Left speed */
	private static final String CMD_SET_PARAM_SPEED_LEFT = "speedL";

	/** Right speed */
	private static final String CMD_SET_PARAM_SPEED_RIGHT = "speedR";

	/** Command name in order map */
	private static final String ORDER_CMD = "cmd";

	/** Target name in order map */
	private static final String ORDER_TARGET = "target";

	/** The communication service */
	@Requires
	private IRobotCommunication pCommunication;

	/** The robot xmpp address */
	@Property(name = "robot.xmpp.address", value = "tom87.21@gmail.com")
	private String pRobotXmppAddress;

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
	 */
	private void sendCommand(final String aCommand,
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
		pCommunication.sendMessage(pRobotXmppAddress, toJson(command));
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
		parameters.put(CMD_SET_PARAM_SPEED_LEFT, normalizeSpeed(aSpeedLeft));
		parameters.put(CMD_SET_PARAM_SPEED_RIGHT, normalizeSpeed(aSpeedRight));

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
}
