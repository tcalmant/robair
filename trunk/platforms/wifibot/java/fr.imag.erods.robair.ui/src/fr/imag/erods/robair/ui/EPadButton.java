/**
 * 
 */
package fr.imag.erods.robair.ui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;

public enum EPadButton implements IGridButton {

	/** Backward */
	BACKWARD {

		/*
		 * (non-Javadoc)
		 * 
		 * @see fr.imag.erods.robair.ui.IGridButton#getMnemonic()
		 */
		@Override
		public int getMnemonic() {
			return KeyEvent.VK_DOWN;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see fr.imag.erods.robair.ui.IGridButton#getPoint()
		 */
		@Override
		public Point getPoint() {
			return new Point(1, 2);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return "Backward";
		}
	},

	/** Forward */
	FORWARD {

		/*
		 * (non-Javadoc)
		 * 
		 * @see fr.imag.erods.robair.ui.IGridButton#getMnemonic()
		 */
		@Override
		public int getMnemonic() {
			return KeyEvent.VK_UP;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see fr.imag.erods.robair.ui.IGridButton#getPoint()
		 */
		@Override
		public Point getPoint() {
			return new Point(1, 0);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return "Forward";
		}

	},

	/** Left */
	LEFT {

		/*
		 * (non-Javadoc)
		 * 
		 * @see fr.imag.erods.robair.ui.IGridButton#getMnemonic()
		 */
		@Override
		public int getMnemonic() {
			return KeyEvent.VK_LEFT;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see fr.imag.erods.robair.ui.IGridButton#getPoint()
		 */
		@Override
		public Point getPoint() {
			return new Point(0, 1);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return "Left";
		}
	},

	/** Reset button */
	RESET {

		/*
		 * (non-Javadoc)
		 * 
		 * @see fr.imag.erods.robair.ui.IGridButton#getMnemonic()
		 */
		@Override
		public int getMnemonic() {
			return KeyEvent.VK_R;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see fr.imag.erods.robair.ui.IGridButton#getPoint()
		 */
		@Override
		public Point getPoint() {
			return new Point(1, 1);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {

			return "Reset";
		}
	},

	/** Right */
	RIGHT {

		/*
		 * (non-Javadoc)
		 * 
		 * @see fr.imag.erods.robair.ui.IGridButton#getMnemonic()
		 */
		@Override
		public int getMnemonic() {
			return KeyEvent.VK_RIGHT;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see fr.imag.erods.robair.ui.IGridButton#getPoint()
		 */
		@Override
		public Point getPoint() {
			return new Point(2, 1);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return "Right";
		}
	},
	;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imag.erods.robair.ui.IGridButton#getSize()
	 */
	@Override
	public Dimension getSize() {

		return new Dimension(150, 30);
	}
}