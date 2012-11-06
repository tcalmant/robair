/**
 * 
 */
package fr.imag.erods.robair.wiimote;

/**
 * @author Thomas Calmant
 * 
 */
public class PadButtonsData {

	private boolean pPadDown;

	private boolean pPadLeft;

	private boolean pPadRight;

	private boolean pPadUp;

	public PadButtonsData(final boolean aPadUp, final boolean aPadDown,
			final boolean aPadLeft, final boolean aPadRight) {

		pPadUp = aPadUp;
		pPadDown = aPadDown;
		pPadLeft = aPadLeft;
		pPadRight = aPadRight;
	}

	/**
	 * @return the padDown
	 */
	public boolean isPadDown() {
		return pPadDown;
	}

	/**
	 * @return the padLeft
	 */
	public boolean isPadLeft() {
		return pPadLeft;
	}

	/**
	 * @return the padRight
	 */
	public boolean isPadRight() {
		return pPadRight;
	}

	/**
	 * @return the padUp
	 */
	public boolean isPadUp() {
		return pPadUp;
	}

	/**
	 * @param aPadDown
	 *            the padDown to set
	 */
	public void setPadDown(final boolean aPadDown) {
		pPadDown = aPadDown;
	}

	/**
	 * @param aPadLeft
	 *            the padLeft to set
	 */
	public void setPadLeft(final boolean aPadLeft) {
		pPadLeft = aPadLeft;
	}

	/**
	 * @param aPadRight
	 *            the padRight to set
	 */
	public void setPadRight(final boolean aPadRight) {
		pPadRight = aPadRight;
	}

	/**
	 * @param aPadUp
	 *            the padUp to set
	 */
	public void setPadUp(final boolean aPadUp) {
		pPadUp = aPadUp;
	}
}
