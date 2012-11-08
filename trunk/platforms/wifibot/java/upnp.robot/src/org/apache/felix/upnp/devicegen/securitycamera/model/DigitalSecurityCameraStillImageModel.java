/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.apache.felix.upnp.devicegen.securitycamera.model;

import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.osgi.service.upnp.UPnPException;

public interface DigitalSecurityCameraStillImageModel {

	/**
	 * This method is "add description here" retAvailableEncodings out parameter
	 */
	public void getAvailableEncodings(StringHolder retAvailableEncodings)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retEncoding out parameter
	 */
	public void getDefaultEncoding(StringHolder retEncoding)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" reqEncoding in parameter
	 */
	public void setDefaultEncoding(java.lang.String reqEncoding)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retAvailableCompressionLevels out
	 * parameter
	 */
	public void getAvailableCompressionLevels(
			StringHolder retAvailableCompressionLevels) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retCompressionLevel out parameter
	 */
	public void getDefaultCompressionLevel(StringHolder retCompressionLevel)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" reqCompressionLevel in parameter
	 */
	public void setDefaultCompressionLevel(java.lang.String reqCompressionLevel)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retAvailableResolutions out
	 * parameter
	 */
	public void getAvailableResolutions(StringHolder retAvailableResolutions)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retResolution out parameter
	 */
	public void getDefaultResolution(StringHolder retResolution)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" reqResolution in parameter
	 */
	public void setDefaultResolution(java.lang.String reqResolution)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" reqEncoding in parameter
	 * 
	 * reqCompression in parameter
	 * 
	 * reqResolution in parameter
	 * 
	 * retImageURL out parameter
	 */
	public void getImageURL(java.lang.String reqEncoding,

	java.lang.String reqCompression,

	java.lang.String reqResolution,

	StringHolder retImageURL) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retImageURL out parameter
	 */
	public void getDefaultImageURL(StringHolder retImageURL)
			throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" reqEncoding in parameter
	 * 
	 * reqCompression in parameter
	 * 
	 * reqResolution in parameter
	 * 
	 * retImagePresentationURL out parameter
	 */
	public void getImagePresentationURL(java.lang.String reqEncoding,

	java.lang.String reqCompression,

	java.lang.String reqResolution,

	StringHolder retImagePresentationURL) throws UPnPException;

	// TODO return the type of the return argument when specified

	/**
	 * This method is "add description here" retImagePresentationURL out
	 * parameter
	 */
	public void getDefaultImagePresentationURL(
			StringHolder retImagePresentationURL) throws UPnPException;

	// TODO return the type of the return argument when specified

	// Those getters are used for the first notification just after a
	// subscription

	public java.lang.String getDefaultEncodingStateVariableValue();

	public java.lang.String getDefaultCompressionLevelStateVariableValue();

	public java.lang.String getDefaultResolutionStateVariableValue();

}
