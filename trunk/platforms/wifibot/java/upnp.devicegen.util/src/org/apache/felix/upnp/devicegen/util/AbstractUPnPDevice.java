/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.felix.upnp.devicegen.util;

import java.beans.PropertyChangeEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPIcon;
import org.osgi.service.upnp.UPnPService;

/**
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */
public abstract class AbstractUPnPDevice implements BundleActivator, UPnPDevice {

	protected BundleContext bundleContext;

	protected List/* <AbstractUPnPDevice> */children;

	protected String DEVICE_ID;

	protected Dictionary dictionary;

	protected UPnPIcon[] icons;

	/**
	 *  
	 */
	private String myUDN;

	protected UPnPEventNotifier[] notifiers;

	protected AbstractUPnPDevice parent;
	private ServiceRegistration serviceRegistration;

	protected UPnPService[] services;

	public AbstractUPnPDevice(final BundleContext bundleContext,
			final AbstractUPnPDevice parent) {
		this.bundleContext = bundleContext;
		this.parent = parent;

		dictionary = new Properties();
		dictionary.put(UPnPDevice.UPNP_EXPORT, "");
		dictionary.put(org.osgi.service.device.Constants.DEVICE_CATEGORY,
				new String[] { UPnPDevice.DEVICE_CATEGORY });
		if (parent != null) {
			dictionary.put(UPnPDevice.PARENT_UDN, parent.getUDN());
		}

		final List servicesList = new ArrayList();
		final List iconList = new ArrayList();
	}

	protected void addChild(final AbstractUPnPDevice childDevice) {
		if (children == null) {
			children = new LinkedList();
		}
		children.add(childDevice);
	}

	/**
	 *  
	 */
	private void buildEventNotifier() {
		notifiers = new UPnPEventNotifier[services.length];
		for (int n = 0; n < notifiers.length; n++) {
			notifiers[n] = new UPnPEventNotifier(bundleContext, this,
					services[n], null);
		}
	}

	/**
	 * @see org.osgi.service.upnp.UPnPDevice#getDescriptions(java.lang.String)
	 */
	@Override
	public Dictionary getDescriptions(final String locale) {
		return dictionary;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPDevice#getIcons(java.lang.String)
	 */
	@Override
	public UPnPIcon[] getIcons(final String locale) {
		return icons;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPDevice#getService(java.lang.String)
	 */
	@Override
	public UPnPService getService(final String serviceId) {
		for (int s = 0; s < services.length; s++) {
			if (serviceId.equals(services[s].getId())) {
				return services[s];
			}
		}
		return null;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPDevice#getServices()
	 */
	@Override
	public UPnPService[] getServices() {
		return services;
	}

	public String getUDN() {
		if (myUDN == null) {
			try {
				myUDN = DEVICE_ID + '@'
						+ InetAddress.getLocalHost().getHostAddress();
			} catch (final UnknownHostException e) {
				myUDN = DEVICE_ID;
			}
		}
		return myUDN;
	}

	/**
	 *  
	 */
	final public void propertyChange(
			final PropertyChangeEvent propertyChangeEvent) {
		for (int n = 0; n < notifiers.length; n++) {
			notifiers[n].propertyChange(propertyChangeEvent);
		}
	}

	protected abstract void setupDeviceProperties();

	/**
	 * @throws Exception
	 * 
	 */
	@Override
	public void start(final BundleContext bundleContext) throws Exception {
		this.bundleContext = bundleContext;

		setupDeviceProperties();

		if (children != null) {
			final Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				try {
					final AbstractUPnPDevice embeddedDevice = ((AbstractUPnPDevice) iterator
							.next());
					System.out.println("start " + embeddedDevice.getUDN()
							+ " ...");
					embeddedDevice.start(bundleContext);
				} catch (final Exception e) {
					// TODO compensate previous starting ???
					e.printStackTrace(System.err);
				}
			}
		}
		System.out.println(this.toString());
		serviceRegistration = bundleContext.registerService(
				UPnPDevice.class.getName(), this, dictionary);
		buildEventNotifier();
	}

	/**
	 *  
	 */
	@Override
	public void stop(final BundleContext bundleContext) throws Exception {
		for (int n = 0; n < notifiers.length; n++) {
			notifiers[n].destroy();
		}
		serviceRegistration.unregister();
		if (children != null) {
			final Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				try {
					((BundleActivator) iterator.next()).stop(bundleContext);
				} catch (final Exception e) {
					// TODO compensate previous starting ???
				}
			}
		}
	}
}