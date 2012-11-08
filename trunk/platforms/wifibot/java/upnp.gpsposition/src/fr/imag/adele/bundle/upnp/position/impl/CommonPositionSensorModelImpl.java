/*
 * __BANNER__
 */
// this file was generated at 1-June-2005 03:50 PM by ${author}
package fr.imag.adele.bundle.upnp.position.impl;

import it.cnr.isti.niche.osgi.upnp.util.UPnPEventNotifier;

import java.beans.PropertyChangeEvent;
import java.util.Date;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import fr.imag.adele.bundle.upnp.position.PositionSensorModel;
import fr.imag.adele.bundle.upnp.position.service.PositionSensor;
import fr.imag.adele.util.upnp.holder.DateHolder;
import fr.imag.adele.util.upnp.holder.FloatHolder;
import fr.imag.adele.util.upnp.holder.StringHolder;

public abstract class CommonPositionSensorModelImpl implements PositionSensorModel, BundleActivator {

	protected String name=""; 

	protected String method=""; 
	
	protected float latitude = Float.NaN;

	protected float longitude  = Float.NaN;

	protected float altitude  = Float.NaN;

	protected float speed  = Float.NaN;

	protected float track  = Float.NaN;

	protected long timestamp = 0;

	protected float oldLatitude = Float.NaN;

	protected float oldLongitude  = Float.NaN;

	protected float oldAltitude  = Float.NaN;

	protected float oldSpeed  = Float.NaN;

	protected float oldTrack  = Float.NaN;

	protected long oldTimestamp = 0;

	
	/**
	 * This method is "add description here" currentLatitude out parameter
	 * 
	 * currentLongitude out parameter currentAltitude out parameter currentSpeed
	 * out parameter currentTrack out parameter timestamp out parameter
	 */
	public void getCurrentPosition(FloatHolder currentLatitude,
			FloatHolder currentLongitude, FloatHolder currentAltitude,
			FloatHolder currentSpeed, FloatHolder currentTrack,
			DateHolder timestamp) {
		currentLatitude.setValue(latitude);
		currentLongitude.setValue(longitude);
		currentAltitude.setValue(altitude);
		currentSpeed.setValue(speed);
		currentTrack.setValue(track);
		timestamp.setValue(new Date(this.timestamp));
	}

	/**
	 */
	public void getName(StringHolder currentName) {
		currentName.setValue(name);
	}

	/**
	 */
	public void getMethod(StringHolder method) {
		method.setValue(this.method);
	}

	/**
	 */
	public void setName(java.lang.String newName) {
		name=newName;
	}

	// Those getters are used for the first notification just after a
	// subscription
	public java.lang.Float getCurrentLatitudeStateVariableValue() {
		return new Float(latitude);
	}

	public java.lang.Float getCurrentLongitudeStateVariableValue() {
		return new Float(longitude);
	}

	public java.lang.Float getCurrentAltitudeStateVariableValue() {
		return new Float(altitude);
	}

	public java.lang.Float getCurrentSpeedStateVariableValue() {
		return new Float(speed);
	}

	public java.lang.Float getCurrentTrackStateVariableValue() {
		return new Float(track);
	}

	public java.util.Date getTimestampStateVariableValue() {
		return new Date(timestamp);
	}

	private UPnPEventNotifier notifier;
	
	protected final void notifyChanges() {
		
		if(notifier!=null){
			PropertyChangeEvent propertyChangeEvent;
			propertyChangeEvent=new PropertyChangeEvent(this,PositionSensor.CurrentLatitudeStateVariable.NAME,new Float(oldLatitude),new Float(latitude));
			notifier.propertyChange(propertyChangeEvent);
			propertyChangeEvent=new PropertyChangeEvent(this,PositionSensor.CurrentLongitudeStateVariable.NAME,new Float(oldLongitude),new Float(longitude));
			notifier.propertyChange(propertyChangeEvent);
			propertyChangeEvent=new PropertyChangeEvent(this,PositionSensor.CurrentAltitudeStateVariable.NAME,new Float(oldAltitude),new Float(altitude));
			notifier.propertyChange(propertyChangeEvent);
			// speed
			// track
			propertyChangeEvent=new PropertyChangeEvent(this,PositionSensor.TimestampStateVariable.NAME,new Date(oldTimestamp),new Date(timestamp));
			notifier.propertyChange(propertyChangeEvent);
		}
	}

	/**
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public abstract void start(BundleContext bundleContext) throws Exception;

	/**
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public abstract void stop(BundleContext bundleContext) throws Exception;

	/**
	 * @param notifier
	 */
	public void setNotifier(UPnPEventNotifier notifier) {
		this.notifier=notifier;
	}
	
	//--------------
	private boolean debug=false;
	final protected void trace(String msg){
		if(debug){ System.err.println(getClass().getName()+":"+msg); }
	}



}