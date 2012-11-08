/*
 * __BANNER__
 */
// this file was generated at 1-June-2005 03:50 PM by ${author}
package fr.imag.adele.bundle.upnp.position;

import fr.imag.adele.util.upnp.holder.*;

public interface PositionSensorModel {

	/**
	 * This method is "add description here" currentLatitude out parameter
	 * 
	 * currentLongitude out parameter
	 * 
	 * currentAltitude out parameter
	 * 
	 * currentSpeed out parameter
	 * 
	 * currentTrack out parameter
	 * 
	 * timestamp out parameter
	 * 
	 *  
	 */
	public void getCurrentPosition(FloatHolder currentLatitude,

	FloatHolder currentLongitude,

	FloatHolder currentAltitude,

	FloatHolder currentSpeed,

	FloatHolder currentTrack,

	DateHolder timestamp);

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" currentName out parameter
	 * 
	 *  
	 */
	public void getName(StringHolder currentName);

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" newName in parameter
	 * 
	 *  
	 */
	public void setName(java.lang.String newName);

	// TODO return the type of the return argument when specified

	// Those getters are used for the first notification just after a
	// subscription
	java.lang.Float getCurrentLatitudeStateVariableValue();

	java.lang.Float getCurrentLongitudeStateVariableValue();

	java.lang.Float getCurrentAltitudeStateVariableValue();

	java.lang.Float getCurrentSpeedStateVariableValue();

	java.lang.Float getCurrentTrackStateVariableValue();

	java.util.Date getTimestampStateVariableValue();

}