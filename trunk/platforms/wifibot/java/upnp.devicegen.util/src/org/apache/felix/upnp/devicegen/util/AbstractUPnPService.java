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

import java.util.Iterator;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPAction;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPService;
import org.osgi.service.upnp.UPnPStateVariable;


public abstract class AbstractUPnPService implements UPnPService, BundleActivator {
	
	final private String serviceId;
	final private String serviceType;
	final private String version;
	final protected UPnPDevice upnpDevice;	

	protected Map stateVariables;
	protected Map actions;
	
	/** constructor
	*/
	public AbstractUPnPService(
		UPnPDevice upnpDevice,	
		String serviceId,
		String serviceType,
		String version
	){	
		this.upnpDevice=upnpDevice;
		this.serviceId=serviceId;
		this.serviceType=serviceType;
		this.version=version;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPService#getId()
	 */
	public String getId() {
		return serviceId;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPService#getType()
	 */
	public String getType() {
		return serviceType;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPService#getVersion()
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPService#getActions()
	 */
	public UPnPAction[] getActions() {
		if(actions==null) return null;
		return (UPnPAction[])(actions.values()).toArray(new UPnPAction[]{});
	}

	/**
	 * @see org.osgi.service.upnp.UPnPService#getAction(java.lang.String)
	 */
	public UPnPAction getAction(String name) {
		if(actions==null) return null;
		return (UPnPAction)actions.get(name);
	}

	/**
	 * @see org.osgi.service.upnp.UPnPService#getStateVariables()
	 */
	public UPnPStateVariable[] getStateVariables() {
		if(stateVariables==null) return null;
		return (UPnPStateVariable[])(stateVariables.values()).toArray(new UPnPStateVariable[]{});
	}

	/**
	 * @see org.osgi.service.upnp.UPnPService#getStateVariable(java.lang.String)
	 */
	public UPnPStateVariable getStateVariable(String name) {
		if(stateVariables==null) return null;
		return (UPnPStateVariable)stateVariables.get(name);
	}
	
	public void start(BundleContext bundleContext) throws Exception {
		if(stateVariables!=null) {
			Iterator iter=stateVariables.values().iterator();
			while(iter.hasNext()){
				((BundleActivator)iter.next()).start(bundleContext);
			}
		}
		if(actions!=null) {
			Iterator iter=actions.values().iterator();
			while(iter.hasNext()){
				((BundleActivator)iter.next()).start(bundleContext);
			}
		}
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		if(actions!=null) {
			Iterator iter=actions.values().iterator();
			while(iter.hasNext()){
				((BundleActivator)iter.next()).stop(bundleContext);
			}
		}
		if(stateVariables!=null) {
			Iterator iter=stateVariables.values().iterator();
			while(iter.hasNext()){
				((BundleActivator)iter.next()).stop(bundleContext);
			}
		}
	}
}
