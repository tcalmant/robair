/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.impl;

import org.apache.felix.upnp.devicegen.holder.FloatHolder;
import org.apache.felix.upnp.devicegen.holder.IntegerHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.osgi.service.upnp.UPnPException;
import org.robair.wifibot.model.PositionSensorModel;

public class PositionSensorModelImpl implements PositionSensorModel {

	/**
	 * This method is "add description here" name out parameter
	 */
	public void getName(StringHolder name) throws UPnPException {
		// TODO
		throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
				"Not implemented");
	}

	/**
	 * This method is "add description here" currentDistanceArray out parameter
	 * 
	 * currentError out parameter
	 */
	public void getCurrentDistanceArray(StringHolder currentDistanceArray,

	FloatHolder currentError) throws UPnPException {
		// TODO
		throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
				"Not implemented");
	}

	/**
	 * This method is "add description here" name out parameter
	 * 
	 * application out parameter
	 * 
	 * angle out parameter
	 * 
	 * angleStep out parameter
	 * 
	 * minDetection out parameter
	 * 
	 * maxDetection out parameter
	 */
	public void getDistanceSensorInfo(StringHolder name,

	StringHolder application,

	FloatHolder angle,

	IntegerHolder angleStep,

	FloatHolder minDetection,

	FloatHolder maxDetection) throws UPnPException {
		// TODO
		throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
				"Not implemented");
	}

	/**
	 * This method is "add description here"
	 * currentAbsoluteDeltaDetectionThreshold out parameter
	 */
	public void getAbsoluteDeltaDetectionThreshold(
			FloatHolder currentAbsoluteDeltaDetectionThreshold)
			throws UPnPException {
		// TODO
		throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
				"Not implemented");
	}

	/**
	 * This method is "add description here" newAbsoluteDeltaDetectionThreshold
	 * in parameter
	 */
	public void setAbsoluteDeltaDetectionThreshold(
			float newAbsoluteDeltaDetectionThreshold) throws UPnPException {
		// TODO
		throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
				"Not implemented");
	}

	// Those getters are used for the first notification just after a
	// subscription

	public java.lang.String getCurrentDistanceArrayStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.Float getCurrentErrorStateVariableValue() {
		// TODO
		return null;
	}

}
