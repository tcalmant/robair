/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.model;

import org.apache.felix.upnp.devicegen.holder.DateHolder;
import org.apache.felix.upnp.devicegen.holder.FloatHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.osgi.service.upnp.UPnPException;

public interface DistanceSensorModel {

	/**
	 * This method is "add description here" currentName out parameter
	 */
	public void getName(StringHolder currentName) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" currentApplication out parameter
	 */
	public void getApplication(StringHolder currentApplication)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" currentValue out parameter
	 * 
	 * currentError out parameter
	 * 
	 * unit out parameter
	 * 
	 * timestamp out parameter
	 */
	public void getCurrentValue(FloatHolder currentValue,

	FloatHolder currentError,

	StringHolder unit,

	DateHolder timestamp) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" currentHighValueThreshold out
	 * parameter
	 */
	public void getHighValueThreshold(FloatHolder currentHighValueThreshold)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" newHighValueThreshold in parameter
	 */
	public void setHighValueThreshold(float newHighValueThreshold)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" currentLowValueThreshold out
	 * parameter
	 */
	public void getLowValueThreshold(FloatHolder currentLowValueThreshold)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" newHighValueThreshold in parameter
	 */
	public void setLowValueThreshold(float newHighValueThreshold)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	// Those getters are used for the first notification just after a
	// subscription

	public java.lang.Float getValueStateVariableValue();

	public java.lang.Float getErrorStateVariableValue();

	public java.util.Date getTimestampStateVariableValue();

	public java.lang.Float getHighValueThresholdStateVariableValue();

	public java.lang.Float getLowValueThresholdStateVariableValue();

}
