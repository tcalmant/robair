/**
 * 
 */
package fr.imag.erods.robair.ui;

import java.awt.Dimension;
import java.awt.Point;

public interface IGridButton {

	/**
	 * Retrieves the button mnemonic
	 * 
	 * @return A key code
	 */
	int getMnemonic();

	/**
	 * Retrieves the (x,y) position where the button must be shown
	 * 
	 * @return A (x,y) position
	 */
	Point getPoint();

	/**
	 * Retrieves the (x,y) size of the button
	 * 
	 * @return The size of the button
	 */
	Dimension getSize();
}