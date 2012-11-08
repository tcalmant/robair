/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.controlpoint;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.felix.upnp.devicegen.holder.DateHolder;
import org.apache.felix.upnp.devicegen.holder.FloatHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.osgi.service.upnp.UPnPAction;
import org.osgi.service.upnp.UPnPException;
import org.osgi.service.upnp.UPnPService;
import org.robair.wifibot.model.SensorModel;

public class SensorProxyImpl implements SensorModel {

	private UPnPService upnpService;

	public SensorProxyImpl(UPnPService upnpService) {
		super();
		this.upnpService = upnpService;
	}

	/**
	 * This method is "add description here" currentName out parameter
	 */
	public void getName(StringHolder currentName) throws UPnPException {

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
	 * This method is "add description here" currentApplication out parameter
	 */
	public void getApplication(StringHolder currentApplication)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getApplication");

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

	DateHolder timestamp) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getCurrentValue");

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
	 * This method is "add description here" currentHighValueThreshold out
	 * parameter
	 */
	public void getHighValueThreshold(FloatHolder currentHighValueThreshold)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getHighValueThreshold");

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
	 * This method is "add description here" newHighValueThreshold in parameter
	 */
	public void setHighValueThreshold(float newHighValueThreshold)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("setHighValueThreshold");

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
	 * This method is "add description here" currentLowValueThreshold out
	 * parameter
	 */
	public void getLowValueThreshold(FloatHolder currentLowValueThreshold)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getLowValueThreshold");

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
	 * This method is "add description here" newHighValueThreshold in parameter
	 */
	public void setLowValueThreshold(float newHighValueThreshold)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("setLowValueThreshold");

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

	public void addListenerOnValueStateVariableValue(/* TODO Listener listener */) {
		// TODO java.lang.Float
		return;
	}

	public void removeListenerOnValueStateVariableValue(/*
														 * TODO Listener
														 * listener
														 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnErrorStateVariableValue(/* TODO Listener listener */) {
		// TODO java.lang.Float
		return;
	}

	public void removeListenerOnErrorStateVariableValue(/*
														 * TODO Listener
														 * listener
														 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnTimestampStateVariableValue(/*
														 * TODO Listener
														 * listener
														 */) {
		// TODO java.util.Date
		return;
	}

	public void removeListenerOnTimestampStateVariableValue(/*
															 * TODO Listener
															 * listener
															 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnHighValueThresholdStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO java.lang.Float
		return;
	}

	public void removeListenerOnHighValueThresholdStateVariableValue(/*
																	 * TODO
																	 * Listener
																	 * listener
																	 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnLowValueThresholdStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO java.lang.Float
		return;
	}

	public void removeListenerOnLowValueThresholdStateVariableValue(/*
																	 * TODO
																	 * Listener
																	 * listener
																	 */) {
		// TODO
		return;
	}

	// Those getters are used for ??? may be not useful !!!

	public java.lang.Float getValueStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.Float getErrorStateVariableValue() {
		// TODO
		return null;
	}

	public java.util.Date getTimestampStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.Float getHighValueThresholdStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.Float getLowValueThresholdStateVariableValue() {
		// TODO
		return null;
	}

}
