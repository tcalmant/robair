/**
 * 
 */
package fr.imag.erods.robair;

import java.util.Map;

/**
 * @author Thomas Calmant
 * 
 */
public interface IRobotCommunication {

	/**
	 * Sends an IM message
	 * 
	 * @param aTo
	 *            Target contact address
	 * @param aMessage
	 *            Message content
	 * @return The command result map
	 * @throws Exception
	 */
	Map<String, ?> sendMessage(String aTo, String aMessage) throws Exception;
}