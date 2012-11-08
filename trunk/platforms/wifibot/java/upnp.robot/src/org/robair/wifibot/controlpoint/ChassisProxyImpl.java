/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.controlpoint;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.service.upnp.UPnPAction;
import org.osgi.service.upnp.UPnPException;
import org.osgi.service.upnp.UPnPService;
import org.robair.wifibot.model.ChassisModel;

public class ChassisProxyImpl implements ChassisModel {

	private UPnPService upnpService;

	public ChassisProxyImpl(UPnPService upnpService) {
		super();
		this.upnpService = upnpService;
	}

	/**
	 * This method is "add description here" newRightSpeed in parameter
	 * 
	 * newLeftSpeed in parameter
	 */
	public void setSpeedTarget(int newRightSpeed,

	int newLeftSpeed) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("setSpeedTarget");

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
	 * This method is "add description here" radius in parameter
	 * 
	 * radiusSpeed in parameter
	 */
	public void rotate(int radius,

	int radiusSpeed) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("rotate");

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
	 */
	public void stop(

	) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("stop");

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

	public void addListenerOnLeftSpeedStatusStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO java.lang.Integer
		return;
	}

	public void removeListenerOnLeftSpeedStatusStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnRightSpeedStatusStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO java.lang.Integer
		return;
	}

	public void removeListenerOnRightSpeedStatusStateVariableValue(/*
																	 * TODO
																	 * Listener
																	 * listener
																	 */) {
		// TODO
		return;
	}

	// Those getters are used for ??? may be not useful !!!

	public java.lang.Integer getLeftSpeedStatusStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.Integer getRightSpeedStatusStateVariableValue() {
		// TODO
		return null;
	}

}
