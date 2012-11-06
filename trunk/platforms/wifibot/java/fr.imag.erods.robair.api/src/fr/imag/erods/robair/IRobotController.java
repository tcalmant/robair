/**
 * 
 */
package fr.imag.erods.robair;

/**
 * @author Thomas Calmant
 * 
 */
public interface IRobotController {

	/**
	 * Resets the motors values
	 */
	void reset();

	/**
	 * Sets the motors speed
	 * 
	 * Speeds must be between -60 and +60. Negative values means backward.
	 * 
	 * @param aSpeedLeft
	 * @param aSpeedRight
	 */
	void setMotors(int aSpeedLeft, int aSpeedRight);
}
