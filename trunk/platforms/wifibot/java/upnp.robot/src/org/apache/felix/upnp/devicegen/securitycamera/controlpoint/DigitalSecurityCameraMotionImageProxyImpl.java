/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.apache.felix.upnp.devicegen.securitycamera.controlpoint;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.felix.upnp.devicegen.holder.LongHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.apache.felix.upnp.devicegen.securitycamera.model.DigitalSecurityCameraMotionImageModel;
import org.osgi.service.upnp.UPnPAction;
import org.osgi.service.upnp.UPnPException;
import org.osgi.service.upnp.UPnPService;

public class DigitalSecurityCameraMotionImageProxyImpl implements
		DigitalSecurityCameraMotionImageModel {

	private UPnPService upnpService;

	public DigitalSecurityCameraMotionImageProxyImpl(UPnPService upnpService) {
		super();
		this.upnpService = upnpService;
	}

	/**
	 * This method is "add description here" retAvailableEncodings out parameter
	 */
	public void getAvailableEncodings(StringHolder retAvailableEncodings)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getAvailableEncodings");

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
	 * This method is "add description here" retEncoding out parameter
	 */
	public void getDefaultEncoding(StringHolder retEncoding)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getDefaultEncoding");

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
	 * This method is "add description here" reqEncoding in parameter
	 */
	public void setDefaultEncoding(java.lang.String reqEncoding)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("setDefaultEncoding");

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
	 * This method is "add description here" retAvailableCompressionLevels out
	 * parameter
	 */
	public void getAvailableCompressionLevels(
			StringHolder retAvailableCompressionLevels) throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("getAvailableCompressionLevels");

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
	 * This method is "add description here" retCompressionLevel out parameter
	 */
	public void getDefaultCompressionLevel(StringHolder retCompressionLevel)
			throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("getDefaultCompressionLevel");

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
	 * This method is "add description here" reqCompressionLevel in parameter
	 */
	public void setDefaultCompressionLevel(java.lang.String reqCompressionLevel)
			throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("setDefaultCompressionLevel");

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
	 * This method is "add description here" retAvailableResolutions out
	 * parameter
	 */
	public void getAvailableResolutions(StringHolder retAvailableResolutions)
			throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("getAvailableResolutions");

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
	 * This method is "add description here" retResolution out parameter
	 */
	public void getDefaultResolution(StringHolder retResolution)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getDefaultResolution");

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
	 * This method is "add description here" reqResolution in parameter
	 */
	public void setDefaultResolution(java.lang.String reqResolution)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("setDefaultResolution");

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
	 * This method is "add description here" reqEncoding in parameter
	 * 
	 * reqCompression in parameter
	 * 
	 * reqResolution in parameter
	 * 
	 * retVideoURL out parameter
	 */
	public void getVideoURL(java.lang.String reqEncoding,

	java.lang.String reqCompression,

	java.lang.String reqResolution,

	StringHolder retVideoURL) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getVideoURL");

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
	 * This method is "add description here" retVideoURL out parameter
	 */
	public void getDefaultVideoURL(StringHolder retVideoURL)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getDefaultVideoURL");

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
	 * This method is "add description here" reqEncoding in parameter
	 * 
	 * reqCompression in parameter
	 * 
	 * reqResolution in parameter
	 * 
	 * retVideoPresentationURL out parameter
	 */
	public void getVideoPresentationURL(java.lang.String reqEncoding,

	java.lang.String reqCompression,

	java.lang.String reqResolution,

	StringHolder retVideoPresentationURL) throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("getVideoPresentationURL");

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
	 * This method is "add description here" retVideoPresentationURL out
	 * parameter
	 */
	public void getDefaultVideoPresentationURL(
			StringHolder retVideoPresentationURL) throws UPnPException {

		UPnPAction upnpAction = upnpService
				.getAction("getDefaultVideoPresentationURL");

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
	 * This method is "add description here" reqMaxBandwidth in parameter
	 */
	public void setMaxBandwidth(long reqMaxBandwidth) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("setMaxBandwidth");

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
	 * This method is "add description here" retMaxBandwidth out parameter
	 */
	public void getMaxBandwidth(LongHolder retMaxBandwidth)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getMaxBandwidth");

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
	 * This method is "add description here" reqTargetFrameRate in parameter
	 */
	public void setTargetFrameRate(long reqTargetFrameRate)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("setTargetFrameRate");

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
	 * This method is "add description here" retTargetFrameRate out parameter
	 */
	public void getTargetFrameRate(LongHolder retTargetFrameRate)
			throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getTargetFrameRate");

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

	public void addListenerOnDefaultEncodingStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO java.lang.String
		return;
	}

	public void removeListenerOnDefaultEncodingStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnDefaultCompressionLevelStateVariableValue(/*
																		 * TODO
																		 * Listener
																		 * listener
																		 */) {
		// TODO java.lang.String
		return;
	}

	public void removeListenerOnDefaultCompressionLevelStateVariableValue(/*
																		 * TODO
																		 * Listener
																		 * listener
																		 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnDefaultResolutionStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO java.lang.String
		return;
	}

	public void removeListenerOnDefaultResolutionStateVariableValue(/*
																	 * TODO
																	 * Listener
																	 * listener
																	 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnMaxBandwidthStateVariableValue(/*
															 * TODO Listener
															 * listener
															 */) {
		// TODO java.lang.Long
		return;
	}

	public void removeListenerOnMaxBandwidthStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO
		return;
	}

	// TODO current listeners list

	public void addListenerOnTargetFrameRateStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO java.lang.Long
		return;
	}

	public void removeListenerOnTargetFrameRateStateVariableValue(/*
																 * TODO Listener
																 * listener
																 */) {
		// TODO
		return;
	}

	// Those getters are used for ??? may be not useful !!!

	public java.lang.String getDefaultEncodingStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.String getDefaultCompressionLevelStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.String getDefaultResolutionStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.Long getMaxBandwidthStateVariableValue() {
		// TODO
		return null;
	}

	public java.lang.Long getTargetFrameRateStateVariableValue() {
		// TODO
		return null;
	}

}
