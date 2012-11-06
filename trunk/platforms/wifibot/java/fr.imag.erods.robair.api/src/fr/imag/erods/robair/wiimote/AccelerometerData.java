/**
 * 
 */
package fr.imag.erods.robair.wiimote;

/**
 * @author Thomas Calmant
 * 
 */
public class AccelerometerData {

	private final int pAccX;

	private final int pAccY;

	private final int pAccZ;

	/**
	 * 
	 */
	public AccelerometerData(final int aX, final int aY, final int aZ) {
		pAccX = aX;
		pAccY = aY;
		pAccZ = aZ;
	}

	/**
	 * @return the accX
	 */
	public int getX() {
		return pAccX;
	}

	/**
	 * @return the accY
	 */
	public int getY() {
		return pAccY;
	}

	/**
	 * @return the accZ
	 */
	public int getZ() {
		return pAccZ;
	}
}
