/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.apache.felix.upnp.devicegen.securitycamera.model;

import org.apache.felix.upnp.devicegen.holder.BooleanHolder;
import org.apache.felix.upnp.devicegen.holder.IntegerHolder;
import org.apache.felix.upnp.devicegen.holder.LongHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.osgi.service.upnp.UPnPException;

public interface DigitalSecurityCameraSettingsModel {

	/**
	 * This method is "add description here" newAutomaticWhiteBalance in
	 * parameter
	 */
	public void setAutomaticWhiteBalance(boolean newAutomaticWhiteBalance)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retAutomaticWhiteBalance out
	 * parameter
	 */
	public void getAutomaticWhiteBalance(BooleanHolder retAutomaticWhiteBalance)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" newFixedWhiteBalance in parameter
	 */
	public void setFixedWhiteBalance(long newFixedWhiteBalance)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retFixedWhiteBalance out parameter
	 */
	public void getFixedWhiteBalance(LongHolder retFixedWhiteBalance)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retAvailableRotations out parameter
	 */
	public void getAvailableRotations(StringHolder retAvailableRotations)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" newRotation in parameter
	 */
	public void setDefaultRotation(java.lang.String newRotation)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retRotation out parameter
	 */
	public void getDefaultRotation(StringHolder retRotation)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" newBrightness in parameter
	 */
	public void setBrightness(int newBrightness) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retBrightness out parameter
	 */
	public void getBrightness(IntegerHolder retBrightness) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here"
	 */
	public void increaseBrightness(

	) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here"
	 */
	public void decreaseBrightness(

	) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" newColorSaturation in parameter
	 */
	public void setColorSaturation(int newColorSaturation) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retColorSaturation out parameter
	 */
	public void getColorSaturation(IntegerHolder retColorSaturation)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here"
	 */
	public void increaseColorSaturation(

	) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here"
	 */
	public void decreaseColorSaturation(

	) throws UPnPException;

	// TODO return the type of the return argument when specified

	// Those getters are used for the first notification just after a
	// subscription

	public java.lang.Boolean getAutomaticWhiteBalanceStateVariableValue();

	public java.lang.Long getFixedWhiteBalanceStateVariableValue();

	public java.lang.String getDefaultRotationStateVariableValue();

	public java.lang.Integer getBrightnessStateVariableValue();

	public java.lang.Integer getColorSaturationStateVariableValue();

}
