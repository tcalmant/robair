/**
 * 
 */
package fr.imag.erods.robair;

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
	 */
	void sendMessage(String aTo, String aMessage);
}