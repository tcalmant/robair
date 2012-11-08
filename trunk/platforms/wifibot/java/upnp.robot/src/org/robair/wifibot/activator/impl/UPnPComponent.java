/**
 * 
 */
package org.robair.wifibot.activator.impl;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.Validate;
import org.osgi.framework.BundleContext;
import org.robair.wifibot.device.Robot;

import fr.imag.erods.robair.IRobotController;

/**
 * @author Thomas Calmant
 * 
 */
@Component(name = "robot-upnp-factory")
@Instantiate(name = "robot-upnp")
public class UPnPComponent {

	/** The bundle context */
	private final BundleContext pBundleContext;

	/** The robot controller */
	@Requires
	private IRobotController pRobotController;

	/** The robot UPnP device */
	private Robot pRobotUpnp;

	/**
	 * Component initialization
	 * 
	 * @param aContext
	 *            The bundle context
	 */
	public UPnPComponent(final BundleContext aContext) {

		pBundleContext = aContext;
	}

	/**
	 * Component invalidated
	 * 
	 * @throws Exception
	 */
	@Invalidate
	public void invalidate() throws Exception {

		pRobotUpnp.stop(pBundleContext);
		pRobotUpnp = null;
	}

	/**
	 * Component validated
	 * 
	 * @throws Exception
	 */
	@Validate
	public void validate() throws Exception {

		pRobotUpnp = new Robot(pBundleContext, null, pRobotController);
		pRobotUpnp.start(pBundleContext);
	}
}
