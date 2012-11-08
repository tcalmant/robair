/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.model;

import org.osgi.service.upnp.UPnPException;

public interface ChassisModel {

	/**
	 * This method is "add description here" newRightSpeed in parameter
	 * 
	 * newLeftSpeed in parameter
	 */
	public void setSpeedTarget(int newRightSpeed,

	int newLeftSpeed) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" radius in parameter
	 * 
	 * radiusSpeed in parameter
	 */
	public void rotate(int radius,

	int radiusSpeed) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here"
	 */
	public void stop(

	) throws UPnPException;

	// TODO return the type of the return argument when specified

	// Those getters are used for the first notification just after a
	// subscription

	public java.lang.Integer getLeftSpeedStatusStateVariableValue();

	public java.lang.Integer getRightSpeedStatusStateVariableValue();

}
