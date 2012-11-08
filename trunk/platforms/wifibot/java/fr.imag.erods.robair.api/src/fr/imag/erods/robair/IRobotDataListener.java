/**
 * 
 */
package fr.imag.erods.robair;

import java.util.Map;

/**
 * @author Thomas Calmant
 * 
 */
public interface IRobotDataListener {

	/**
	 * Retrieves the devices handled by this listener
	 * 
	 * @return
	 */
	String[] getDevices();

	/**
	 * Called when a data has been received from the given device
	 * 
	 * @param aDevice
	 * @param aData
	 */
	void handleData(String aDevice, Map<String, ?> aData);
}
