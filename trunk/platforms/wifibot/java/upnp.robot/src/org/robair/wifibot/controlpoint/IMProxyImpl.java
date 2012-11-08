/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.controlpoint;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.felix.upnp.devicegen.holder.BooleanHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.osgi.service.upnp.UPnPAction;
import org.osgi.service.upnp.UPnPException;
import org.osgi.service.upnp.UPnPService;
import org.robair.wifibot.model.IMModel;

public class IMProxyImpl implements IMModel {

	private UPnPService upnpService;

	public IMProxyImpl(UPnPService upnpService) {
		super();
		this.upnpService = upnpService;
	}

	/**
	 * This method is "add description here" xMPP_URL out parameter
	 * 
	 * supportJingleForAV out parameter
	 */
	public void getXMPPInfo(StringHolder xMPP_URL,

	BooleanHolder supportJingleForAV) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getXMPPInfo");

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
	 * This method is "add description here" sIP_URL out parameter
	 * 
	 * supportSimpleForCommandData out parameter
	 */
	public void getSIPInfo(StringHolder sIP_URL,

	BooleanHolder supportSimpleForCommandData) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getSIPInfo");

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
	 * This method is "add description here" skype_ID out parameter
	 * 
	 * supportMessageForCommandData out parameter
	 */
	public void getSkypeInfo(StringHolder skype_ID,

	BooleanHolder supportMessageForCommandData) throws UPnPException {

		UPnPAction upnpAction = upnpService.getAction("getSkypeInfo");

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

	// Those getters are used for ??? may be not useful !!!

}
