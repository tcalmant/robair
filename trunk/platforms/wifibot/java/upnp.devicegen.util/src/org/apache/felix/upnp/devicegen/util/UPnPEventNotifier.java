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
import java.beans.PropertyChangeListener;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPEventListener;
import org.osgi.service.upnp.UPnPService;
import org.osgi.service.upnp.UPnPStateVariable;

/**
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */
public class UPnPEventNotifier implements PropertyChangeListener,
		ServiceListener {
	BundleContext context;
	UPnPDevice device;
	String deviceId;
	UPnPService service;

	String serviceId;
	EventSource source;
	List<ServiceReference> upnpListeners = new LinkedList<ServiceReference>();
	Properties UPnPTargetListener;

	public UPnPEventNotifier(final BundleContext context,
			final UPnPDevice device, final UPnPService service,
			final EventSource source) {
		if ((context == null) || (device == null) || (service == null)) {
			throw new IllegalArgumentException(
					"Illegal arguments in UPnPEventNotifier constructor.");
		}
		this.context = context;
		this.device = device;
		this.service = service;
		this.source = source;
		this.serviceId = service.getId();
		setupUPnPListenerHouseKeeping(device);
	}

	private void addNewListener(final ServiceReference reference) {
		upnpListeners.add(reference);
		final UPnPStateVariable[] vars = service.getStateVariables();
		if (vars != null) {
			for (int i = 0; i < vars.length; i++) {
				if (vars[i].sendsEvents()) {
					final Object value = ((UPnPStateVariableDescriptor) vars[i])
							.getValue();
					propertyChange(new PropertyChangeEvent(this,
							vars[i].getName(), value, value));
				}
			}
		}
	}

	public void destroy() {
		context.removeServiceListener(this);
		upnpListeners.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.
	 * PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		final Iterator<ServiceReference> list = upnpListeners.iterator();
		final String property = evt.getPropertyName();
		final Object value = evt.getNewValue();
		// String valueString = value.toString();
		final Properties events = new Properties();
		// events.put(property,valueString);
		events.put(property, value);
		while (list.hasNext()) {
			final ServiceReference sr = list.next();
			// final String[] props = sr.getPropertyKeys();
			new Thread(null, null, "UPnPEventNotifier") {
				@Override
				public void run() {
					try {
						final UPnPEventListener listener = (UPnPEventListener) context
								.getService(sr);
						listener.notifyUPnPEvent(deviceId, serviceId, events);
						context.ungetService(sr);
					} catch (final Exception ex) {
						System.out.println("UPnPEventNotifier Err: " + ex);
						System.out.println("UPnPEventNotifier bundleId: "
								+ context.getBundle().getBundleId());
						System.out.println("UPnPEventNotifier listener: "
								+ context.getService(sr));
						System.out.println("UPnPEventNotifier sr: " + sr);
						ex.printStackTrace(System.out);
					}
				}
			}.start();
		}
	}

	private void removeListener(final ServiceReference reference) {
		upnpListeners.remove(reference);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.
	 * ServiceEvent)
	 */
	@Override
	public void serviceChanged(final ServiceEvent e) {
		switch (e.getType()) {
		case ServiceEvent.REGISTERED: {
			final ServiceReference sr = e.getServiceReference();
			final Filter filter = (Filter) sr
					.getProperty(UPnPEventListener.UPNP_FILTER);
			if (filter == null) {
				addNewListener(sr);
			} else {
				if (filter.match(UPnPTargetListener)) {
					addNewListener(sr);
				}
			}
		}
			;
			break;

		case ServiceEvent.MODIFIED: {
			final ServiceReference sr = e.getServiceReference();
			final Filter filter = (Filter) sr
					.getProperty(UPnPEventListener.UPNP_FILTER);
			removeListener(sr);
			if (filter == null) {
				addNewListener(sr);
			} else {
				if (filter.match(UPnPTargetListener)) {
					addNewListener(sr);
				}
			}
		}
			;
			break;

		case ServiceEvent.UNREGISTERING: {
			removeListener(e.getServiceReference());
		}
			;
			break;

		}

	}

	/**
	 * @param deviceId
	 */
	private void setupUPnPListenerHouseKeeping(final UPnPDevice device) {
		UPnPTargetListener = new Properties();
		@SuppressWarnings("unchecked")
		final Dictionary<String, ?> dict = device.getDescriptions(null);
		deviceId = (String) dict.get(UPnPDevice.ID);
		UPnPTargetListener.put(UPnPDevice.ID, deviceId);
		UPnPTargetListener.put(UPnPService.ID, serviceId);
		UPnPTargetListener.put(UPnPDevice.TYPE, dict.get(UPnPDevice.TYPE));
		UPnPTargetListener.put(UPnPService.TYPE, service.getType());
		final String ANY_UPnPEventListener = "(" + Constants.OBJECTCLASS + "="
				+ UPnPEventListener.class.getName() + ")";

		ServiceReference[] listeners = null;
		try {
			listeners = context.getServiceReferences(
					UPnPEventListener.class.getName(), null);
			if (listeners != null) {
				for (int i = 0; i < listeners.length; i++) {
					final ServiceReference sr = listeners[i];
					final Filter filter = (Filter) sr
							.getProperty(UPnPEventListener.UPNP_FILTER);
					if (filter == null) {
						addNewListener(sr);
					} else {
						if (filter.match(UPnPTargetListener)) {
							addNewListener(sr);
						}
					}
				}
			}
		} catch (final Exception ex) {
			System.out.println(ex);
		}

		try {
			final String filter = ANY_UPnPEventListener;
			context.addServiceListener(this, filter);
		} catch (final Exception ex) {
			System.out.println(ex);
		}

		if (source != null) {
			final UPnPStateVariable[] vars = service.getStateVariables();
			if (vars != null) {
				for (int i = 0; i < vars.length; i++) {
					if (vars[i].sendsEvents()) {
						source.addPropertyChangeListener(vars[i].getName(),
								this);
					}
				}
			}
		}

	}
}
