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
package org.robair.wifibot.activator.impl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPService;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/**
 * this class instantiates proxy instance for each UPnPService object getted for
 * UPnPDevice services and registers them in the OSGi service registry
 * 
 * @TODO complete the extender model in order to load the UPnPService proxy
 *       classes from other bundles
 * 
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */
public class UPnPServiceBridge implements BundleActivator,
		ServiceTrackerCustomizer, BundleListener {

	private static final int ITF = 0;
	private static final int IMPL = 1;

	private static final String UPNPSERVICEMAP = "/upnpservicemap.txt";
	private ServiceTracker st;
	private BundleContext bundleContext;
	// private Map<String, String[]> upnpservicemap;
	private Map<ServiceReference, List<ServiceRegistration>> upnpdevserviceref = new HashMap<ServiceReference, List<ServiceRegistration>>();

	/**
	 * Call by the framework on bundle starting
	 * 
	 * @param bundleContext
	 *            the bundle context
	 * @exception BundleException
	 */
	public void start(BundleContext bundleContext) throws Exception {
		this.bundleContext = bundleContext;

		loadMaps();
		bundleContext.addBundleListener(this);
		Filter filter = bundleContext.createFilter("(" + Constants.OBJECTCLASS
				+ "=" + UPnPDevice.class.getName() + ")");
		st = new ServiceTracker(bundleContext, filter, this);
		st.open();
	}

	/**
	 * Call by the framework on bundle stopping
	 * 
	 * @param bundleContext
	 *            the bundle context
	 * @exception BundleException
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		st.close();
		bundleContext.removeBundleListener(this);
	}

	public Object addingService(ServiceReference serviceReference) {
		UPnPDevice udevice = (UPnPDevice) bundleContext
				.getService(serviceReference);
		if (udevice == null)
			return null;
		List<ServiceRegistration> list = new LinkedList<ServiceRegistration>();
		addUPnPServices(serviceReference, udevice, list);
		if (!list.isEmpty()) {
			upnpdevserviceref.put(serviceReference, list);
		}
		return udevice;
	}

	private void addUPnPServices(ServiceReference serviceReference,
			UPnPDevice udevice, List<ServiceRegistration> list) {
		UPnPService[] uservices = udevice.getServices();
		if (uservices != null) {
			for (int i = 0; i < uservices.length; i++) {
				UPnPService uservice = uservices[i];
				try {
					Class[] uServiceItfImpl = getUServiceItfImpl(uservice
							.getType());
					if (uServiceItfImpl == null) {
						System.out.println("Not found proxy class for "
								+ uservice.getType());
						continue;
					} else {
						System.out.println("Itf class   for "
								+ uservice.getType() + " is "
								+ uServiceItfImpl[ITF].getName());
						System.out.println("Proxy class for "
								+ uservice.getType() + " is "
								+ uServiceItfImpl[IMPL].getName());
					}

					Constructor ctor = uServiceItfImpl[IMPL]
							.getConstructor(new Class[] { UPnPService.class });
					Object userviceproxy = ctor
							.newInstance(new Object[] { uservice });

					Dictionary regProperties = new Hashtable();
					regProperties.put(UPnPDevice.UDN,
							serviceReference.getProperty(UPnPDevice.UDN));
					Object parentUDN = serviceReference
							.getProperty(UPnPDevice.PARENT_UDN);
					if (parentUDN != null) {
						regProperties.put(UPnPDevice.PARENT_UDN, parentUDN);
					}
					regProperties.put(UPnPDevice.UPC,
							serviceReference.getProperty(UPnPDevice.UPC));
					regProperties.put(UPnPDevice.ID,
							serviceReference.getProperty(UPnPDevice.ID));
					regProperties.put(UPnPDevice.TYPE,
							serviceReference.getProperty(UPnPDevice.TYPE));

					regProperties.put(UPnPService.ID, uservice.getId());
					regProperties.put(UPnPService.TYPE, uservice.getType());
					regProperties.put("UPnPDevice." + Constants.SERVICE_ID,
							serviceReference.getProperty(Constants.SERVICE_ID));
					Object pid = serviceReference
							.getProperty(Constants.SERVICE_PID);
					if (pid != null) {
						regProperties.put(
								"UPnPDevice." + Constants.SERVICE_PID, pid);
					}

					ServiceRegistration servreg = bundleContext
							.registerService(uServiceItfImpl[ITF].getName(),
									userviceproxy, regProperties);
					list.add(servreg);

				} catch (Exception e) {
					// TODO LogService
					e.printStackTrace();
					continue;
				}
			}
		}
	}

	public void modifiedService(ServiceReference serviceReference,
			Object servant) {
		// TODO
	}

	public void removedService(ServiceReference serviceReference, Object o) {
		UPnPDevice udevice = (UPnPDevice) o;
		List<ServiceRegistration> servregs = upnpdevserviceref
				.remove(serviceReference);
		if (servregs == null)
			return;
		for (ServiceRegistration serviceRegistration : servregs) {
			serviceRegistration.unregister();
		}
	}

	public void bundleChanged(BundleEvent bundleEvent) {
		Bundle bundle = bundleEvent.getBundle();
		switch (bundleEvent.getType()) {
		case BundleEvent.RESOLVED: {
			loadMap(bundleEvent.getBundle());
			break;
		}
		case BundleEvent.UNRESOLVED: {
			unloadMap(bundleEvent.getBundle());
			// TODO unregistering UPnPService proxies created with classes
			// imported from this bundle to avoid stale references.
			break;
		}
		}
	}

	private Map<Bundle, Map<String, String[]>> uservicemaps = new HashMap<Bundle, Map<String, String[]>>();

	private void loadMaps() {
		Bundle[] bundles = bundleContext.getBundles();
		for (int i = 0; i < bundles.length; i++) {
			Bundle bundle = bundles[i];
			int state = bundle.getState();
			switch (state) {
			case Bundle.ACTIVE:
			case Bundle.RESOLVED:
			case Bundle.STARTING:
			case Bundle.STOPPING:
				loadMap(bundle);
				break;
			default:
				break;
			}
		}
	}

	private void loadMap(Bundle bundle) {
		if (bundle.getEntry(UPNPSERVICEMAP) != null) {
			System.out.println("Bundle " + bundle.getBundleId()
					+ " has proxy classes for UPnPDevice");
			uservicemaps.remove(bundle);
			Map<String, String[]> uservicemap = loadUPnPServiceMap(bundle);
			uservicemaps.put(bundle, uservicemap);
		}

	}

	private void unloadMap(Bundle bundle) {
		uservicemaps.remove(bundle);
	}

	private Class[] getUServiceItfImpl(Map<String, String[]> upnpservicemap,
			String type) throws ClassNotFoundException {
		String[] ii = upnpservicemap.get(type);
		if (ii == null)
			return null;
		Class[] clazzes = new Class[2];
		clazzes[ITF] = bundleContext.getBundle().loadClass(ii[ITF]);
		clazzes[IMPL] = bundleContext.getBundle().loadClass(ii[IMPL]);
		return clazzes;
	}

	private Class[] getUServiceItfImpl(String type)
			throws ClassNotFoundException {
		for (Map<String, String[]> u : uservicemaps.values()) {
			Class[] cs = getUServiceItfImpl(u, type);
			if (cs != null)
				return cs;
		}
		return null;
	}

	private Map<String, String[]> loadUPnPServiceMap(Bundle bundle) {
		Map<String, String[]> upnpservicemap = new HashMap<String, String[]>();
		DataInputStream in = null;
		try {
			URL upnpservicemapUrl = bundle.getEntry(UPNPSERVICEMAP);
			in = new DataInputStream(upnpservicemapUrl.openStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				if (strLine.startsWith("#") || strLine.startsWith("!")
						|| strLine.startsWith(" ") || strLine.startsWith("\t"))
					continue;
				String[] ii = new String[2];
				strLine = strLine.trim();
				String type = strLine.substring(0, strLine.indexOf("="));
				strLine = strLine.substring(strLine.indexOf("=") + 1);
				ii[ITF] = strLine.substring(0, strLine.indexOf(";"));
				ii[IMPL] = strLine.substring(strLine.indexOf(";") + 1);
				upnpservicemap.put(type, ii);
			}
		} catch (Exception e) {
			upnpservicemap = null;
			System.err.println("Error while parsing " + UPNPSERVICEMAP + ": "
					+ e.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return upnpservicemap;
	}

}
