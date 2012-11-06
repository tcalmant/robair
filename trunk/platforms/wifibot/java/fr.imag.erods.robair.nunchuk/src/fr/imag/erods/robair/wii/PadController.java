/**
 * 
 */
package fr.imag.erods.robair.wii;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Property;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.StaticServiceProperty;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireConstants;

import fr.imag.erods.robair.IRobotController;
import fr.imag.erods.robair.wiimote.PadButtonsData;

/**
 * @author Thomas Calmant
 * 
 */
@Component(name = "robair-wiipad-controller-factory")
@Provides(specifications = Consumer.class, properties = @StaticServiceProperty(name = WireConstants.WIREADMIN_CONSUMER_FLAVORS, value = "fr.imag.erods.robair.wiimote.PadButtonsData", type = "String"))
@Instantiate(name = "robair-wiipad-controller")
public class PadController implements Consumer {

	/** The robot controller */
	@Requires
	private IRobotController pRobot;

	/** The maximum computed motor speed */
	@Property(name = "motor.maxspeed", value = "60")
	private int pStep;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Consumer#producersConnected(org.osgi.service
	 * .wireadmin.Wire[])
	 */
	@Override
	public void producersConnected(final Wire[] aWires) {

		// Do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Consumer#updated(org.osgi.service.wireadmin
	 * .Wire, java.lang.Object)
	 */
	@Override
	public void updated(final Wire aWire, final Object aData) {

		if (!(aData instanceof PadButtonsData)) {
			return;
		}

		final PadButtonsData buttons = (PadButtonsData) aData;

		int speedL = 0;
		int speedR = 0;

		if (buttons.isPadUp()) {
			// Pad UP: forward
			speedL += 60;
			speedR += 60;
		}

		if (buttons.isPadDown()) {
			// Pad DOWN: backward
			speedL -= 60;
			speedR -= 60;
		}

		if (buttons.isPadLeft()) {
			// Pad LEFT: reduce left speed, increase right speed
			speedL -= 20;
			speedR += 20;
		}

		if (buttons.isPadRight()) {
			// Pad RIGHT: reduce right speed, increase left speed
			speedL += 20;
			speedR -= 20;
		}

		// Update motors speed
		pRobot.setMotors(speedL, speedR);
	}
}
