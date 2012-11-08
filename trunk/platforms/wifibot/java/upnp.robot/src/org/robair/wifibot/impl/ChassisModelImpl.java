/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.impl;

import org.osgi.service.upnp.UPnPException;
import org.robair.wifibot.model.ChassisModel;

import fr.imag.erods.robair.IRobotController;

public class ChassisModelImpl implements ChassisModel {

	/** The robot controller */
	private final IRobotController pRobot;

	/**
	 * Sets up the service implementation
	 * 
	 * @param aRobotController
	 *            The robot controller
	 */
	public ChassisModelImpl(final IRobotController aRobotController) {

		pRobot = aRobotController;
	}

	// Those getters are used for the first notification just after a
	// subscription
	public Integer getLeftSpeedStatusStateVariableValue() {
		return pRobot.getMotorsSpeed()[0];
	}

	public Integer getRightSpeedStatusStateVariableValue() {
		return pRobot.getMotorsSpeed()[1];
	}

	/**
	 * This method is "add description here" radius in parameter
	 * 
	 * radiusSpeed in parameter
	 */
	public void rotate(final int radius, final int radiusSpeed)
			throws UPnPException {

		pRobot.setMotors(radiusSpeed, -radiusSpeed);
	}

	/**
	 * This method is "add description here" newRightSpeed in parameter
	 * 
	 * newLeftSpeed in parameter
	 */
	public void setSpeedTarget(final int newRightSpeed, final int newLeftSpeed)
			throws UPnPException {

		// Set the motors speed
		pRobot.setMotors(newLeftSpeed, newRightSpeed);
	}

	/**
	 * This method is "add description here"
	 */
	public void stop() throws UPnPException {

		// Resets the motors
		pRobot.reset();
	}
}
