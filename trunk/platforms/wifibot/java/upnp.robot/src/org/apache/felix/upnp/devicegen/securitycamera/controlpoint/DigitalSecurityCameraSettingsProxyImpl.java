/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.apache.felix.upnp.devicegen.securitycamera.controlpoint;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.felix.upnp.devicegen.holder.BooleanHolder;
import org.apache.felix.upnp.devicegen.holder.IntegerHolder;
import org.apache.felix.upnp.devicegen.holder.LongHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.apache.felix.upnp.devicegen.securitycamera.model.DigitalSecurityCameraSettingsModel;
import org.osgi.service.upnp.UPnPAction;
import org.osgi.service.upnp.UPnPException;
import org.osgi.service.upnp.UPnPService;

public class DigitalSecurityCameraSettingsProxyImpl implements
		DigitalSecurityCameraSettingsModel {

	private UPnPService upnpService;

	public DigitalSecurityCameraSettingsProxyImpl(UPnPService upnpService) {
		super();
		this.upnpService = upnpService;
	}

	/**
	 * This method is "add description here" newAutomaticWhiteBalance in
	 * parameter
	 */
	public void setAutomaticWhiteBalance(boolean newAutomaticWhiteBalance)
			throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("setAutomaticWhiteBalance");

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
	 * This method is "add description here" retAutomaticWhiteBalance out
	 * parameter
	 */
	public void getAutomaticWhiteBalance(BooleanHolder retAutomaticWhiteBalance)
			throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("getAutomaticWhiteBalance");

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
	 * This method is "add description here" newFixedWhiteBalance in parameter
	 */
	public void setFixedWhiteBalance(long newFixedWhiteBalance)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("setFixedWhiteBalance");

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
	 * This method is "add description here" retFixedWhiteBalance out parameter
	 */
	public void getFixedWhiteBalance(LongHolder retFixedWhiteBalance)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getFixedWhiteBalance");

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
	 * This method is "add description here" retAvailableRotations out parameter
	 */
	public void getAvailableRotations(StringHolder retAvailableRotations)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getAvailableRotations");

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
	 * This method is "add description here" newRotation in parameter
	 */
	public void setDefaultRotation(java.lang.String newRotation)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("setDefaultRotation");

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
	 * This method is "add description here" retRotation out parameter
	 */
	public void getDefaultRotation(StringHolder retRotation)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getDefaultRotation");

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
	 * This method is "add description here" newBrightness in parameter
	 */
	public void setBrightness(int newBrightness) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("setBrightness");

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
	 * This method is "add description here" retBrightness out parameter
	 */
	public void getBrightness(IntegerHolder retBrightness) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getBrightness");

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
	public void increaseBrightness(

	) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("increaseBrightness");

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
	public void decreaseBrightness(

	) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("decreaseBrightness");

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
	 * This method is "add description here" newColorSaturation in parameter
	 */
	public void setColorSaturation(int newColorSaturation) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("setColorSaturation");

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
	 * This method is "add description here" retColorSaturation out parameter
	 */
	public void getColorSaturation(IntegerHolder retColorSaturation)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getColorSaturation");

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
	public void increaseColorSaturation(

	) throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("increaseColorSaturation");

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
	public void decreaseColorSaturation(

	) throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("decreaseColorSaturation");

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

	public void addListenerOnAutomaticWhiteBalanceStateVariableValue(/*
																	 * TODO
																	 * Listener
																	 * listener
																	 */) {
		// TODO java.lang.Boolean
		return;
	}

	public void removeListenerOnAutomaticWhiteBalanceStateVariableValue(/*
																		 * TODO
																		 * Listener
																		 * listener
																		 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnFixedWhiteBalanceStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO java.lang.Long
		return;
	}

	public void removeListenerOnFixedWhiteBalanceStateVariableValue(/*
																	 * TODO
																	 * Listener
																	 * listener
																	 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnDefaultRotationStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO java.lang.String
		return;
	}

	public void removeListenerOnDefaultRotationStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnBrightnessStateVariableValue(/*
														 * TODO Listener
														 * listener
														 */) {
		// TODO java.lang.Integer
		return;
	}

	public void removeListenerOnBrightnessStateVariableValue(/*
															 * TODO Listener
															 * listener
															 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnColorSaturationStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO java.lang.Integer
		return;
	}

	public void removeListenerOnColorSaturationStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO
		return;
	}

	// Those getters are used for ??? may be not useful !!!

	public java.lang.Boolean getAutomaticWhiteBalanceStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.Long getFixedWhiteBalanceStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.String getDefaultRotationStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.Integer getBrightnessStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.Integer getColorSaturationStateVariableValue() {
		// TODO
		return null;
	}

}
