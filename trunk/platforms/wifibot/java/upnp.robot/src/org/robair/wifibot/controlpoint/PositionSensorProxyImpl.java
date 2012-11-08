/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.controlpoint;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.felix.upnp.devicegen.holder.FloatHolder;
import org.apache.felix.upnp.devicegen.holder.IntegerHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.osgi.service.upnp.UPnPAction;
import org.osgi.service.upnp.UPnPException;
import org.osgi.service.upnp.UPnPService;
import org.robair.wifibot.model.PositionSensorModel;

public class PositionSensorProxyImpl implements PositionSensorModel {

	private UPnPService upnpService;

	public PositionSensorProxyImpl(UPnPService upnpService) {
		super();
		this.upnpService = upnpService;
	}

	/**
	 * This method is "add description here" name out parameter
	 */
	public void getName(StringHolder name) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getName");

		Dictionary _parameters = new Hashtable();

		// TODO _parameters.put("InParam", inparam);

		Dictionary _result;
		try {
			_result = upnpAction.invoke(_parameters);
		} catch (UPnPException e) {
			throw e;
		} catch (Exception e) {
			throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
					e.getMessage());
		}

		// TODO outparam.setType((Type) _result.get("OutParam"));
	}

	/**
	 * This method is "add description here" currentDistanceArray out parameter
	 * 
	 * currentError out parameter
	 */
	public void getCurrentDistanceArray(StringHolder currentDistanceArray,

	FloatHolder currentError) throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("getCurrentDistanceArray");

		Dictionary _parameters = new Hashtable();

		// TODO _parameters.put("InParam", inparam);

		Dictionary _result;
		try {
			_result = upnpAction.invoke(_parameters);
		} catch (UPnPException e) {
			throw e;
		} catch (Exception e) {
			throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
					e.getMessage());
		}

		// TODO outparam.setType((Type) _result.get("OutParam"));
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

		UPnPAction upnpAction = upnpService.getAction("getDistanceSensorInfo");

		Dictionary _parameters = new Hashtable();

		// TODO _parameters.put("InParam", inparam);

		Dictionary _result;
		try {
			_result = upnpAction.invoke(_parameters);
		} catch (UPnPException e) {
			throw e;
		} catch (Exception e) {
			throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
					e.getMessage());
		}

		// TODO outparam.setType((Type) _result.get("OutParam"));
	}

	/**
	 * This method is "add description here"
	 * currentAbsoluteDeltaDetectionThreshold out parameter
	 */
	public void getAbsoluteDeltaDetectionThreshold(
			FloatHolder currentAbsoluteDeltaDetectionThreshold)
			throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("getAbsoluteDeltaDetectionThreshold");

		Dictionary _parameters = new Hashtable();

		// TODO _parameters.put("InParam", inparam);

		Dictionary _result;
		try {
			_result = upnpAction.invoke(_parameters);
		} catch (UPnPException e) {
			throw e;
		} catch (Exception e) {
			throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
					e.getMessage());
		}

		// TODO outparam.setType((Type) _result.get("OutParam"));
	}

	/**
	 * This method is "add description here" newAbsoluteDeltaDetectionThreshold
	 * in parameter
	 */
	public void setAbsoluteDeltaDetectionThreshold(
			float newAbsoluteDeltaDetectionThreshold) throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("setAbsoluteDeltaDetectionThreshold");

		Dictionary _parameters = new Hashtable();

		// TODO _parameters.put("InParam", inparam);

		Dictionary _result;
		try {
			_result = upnpAction.invoke(_parameters);
		} catch (UPnPException e) {
			throw e;
		} catch (Exception e) {
			throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
					e.getMessage());
		}

		// TODO outparam.setType((Type) _result.get("OutParam"));
	}

	// Those listeners are used for the subscription to state variable change

	// TODO current listeners list

	public void addListenerOnCurrentDistanceArrayStateVariableValue(/*
																	 * TODO
																	 * Listener
																	 * listener
																	 */) {
		// TODO java.lang.String
		return;
	}

	public void removeListenerOnCurrentDistanceArrayStateVariableValue(/*
																		 * TODO
																		 * Listener
																		 * listener
																		 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnCurrentErrorStateVariableValue(/*
															 * TODO Listener
															 * listener
															 */) {
		// TODO java.lang.Float
		return;
	}

	public void removeListenerOnCurrentErrorStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO
		return;
	}

	// Those getters are used for ??? may be not useful !!!

	public java.lang.String getCurrentDistanceArrayStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.Float getCurrentErrorStateVariableValue() {
		// TODO
		return null;
	}

}
