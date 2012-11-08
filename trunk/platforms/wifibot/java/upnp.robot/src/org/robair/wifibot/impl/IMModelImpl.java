/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.impl;

import org.apache.felix.upnp.devicegen.holder.BooleanHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.osgi.service.upnp.UPnPException;
import org.robair.wifibot.model.IMModel;

public class IMModelImpl implements IMModel {

	/**
	 * This method is "add description here" xMPP_URL out parameter
	 * 
	 * supportJingleForAV out parameter
	 */
	public void getXMPPInfo(StringHolder xMPP_URL,

	BooleanHolder supportJingleForAV) throws UPnPException {
		// TODO
		throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
				"Not implemented");
	}

	/**
	 * This method is "add description here" sIP_URL out parameter
	 * 
	 * supportSimpleForCommandData out parameter
	 */
	public void getSIPInfo(StringHolder sIP_URL,

	BooleanHolder supportSimpleForCommandData) throws UPnPException {
		// TODO
		throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
				"Not implemented");
	}

	/**
	 * This method is "add description here" skype_ID out parameter
	 * 
	 * supportMessageForCommandData out parameter
	 */
	public void getSkypeInfo(StringHolder skype_ID,

	BooleanHolder supportMessageForCommandData) throws UPnPException {
		// TODO
		throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,
				"Not implemented");
	}

	// Those getters are used for the first notification just after a
	// subscription

}
