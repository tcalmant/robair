/*
 */
package fr.imag.adele.bundle.upnp.activator.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import fr.imag.adele.bundle.upnp.position.device.PositionDevice;

/**
 * @author donsez
 */
public class Activator implements BundleActivator {

	PositionDevice positionDevice;
	
	public void start(BundleContext bundleContext) throws Exception {
		positionDevice=new PositionDevice(bundleContext,null);
		positionDevice.start(bundleContext);
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		positionDevice.stop(bundleContext);
	}
}
