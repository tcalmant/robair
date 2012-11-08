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

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPService;
import org.osgi.service.upnp.UPnPStateVariable;

/**
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */
public abstract class AbstractUPnPStateVariable
	implements UPnPStateVariable, BundleActivator {

	final protected String NAME;
	final protected String DATA_TYPE;
	final protected Object DEFAULT_VALUE;
	final protected String[] ALLOWED_VALUES;
	final protected Number STEP;
	final protected Number MIN;
	final protected Number MAX;
	final protected boolean SENDEVENT;
	final protected boolean OPTIONAL;

	final protected UPnPService upnpService;

	public AbstractUPnPStateVariable(
					UPnPService upnpService,
					String NAME,
					String DATA_TYPE,
					Object DEFAULT_VALUE,
					String[] ALLOWED_VALUES,
					Number STEP,
					Number MIN,
					Number MAX,
					boolean SENDEVENT,
					boolean OPTIONAL
	) {
		this.upnpService = upnpService;
		this.NAME = NAME;
		this.DATA_TYPE = DATA_TYPE;
		this.DEFAULT_VALUE = DEFAULT_VALUE;
		this.ALLOWED_VALUES = ALLOWED_VALUES;
		this.STEP = STEP;
		this.MIN = MIN;
		this.MAX = MAX;
		this.SENDEVENT = SENDEVENT;
		this.OPTIONAL = OPTIONAL;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPStateVariable#getName()
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPStateVariable#getJavaDataType()
	 */
	public Class getJavaDataType() {
		return UPnPDataTypeUtil.getClass(DATA_TYPE);
	}

	/**
	 * @see org.osgi.service.upnp.UPnPStateVariable#getUPnPDataType()
	 */
	public String getUPnPDataType() {
		return DATA_TYPE;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPStateVariable#getDefaultValue()
	 */
	public Object getDefaultValue() {
		return DEFAULT_VALUE;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPStateVariable#getAllowedValues()
	 */
	public String[] getAllowedValues() {
		return ALLOWED_VALUES;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPStateVariable#getMinimum()
	 */
	public Number getMinimum() {
		return MIN;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPStateVariable#getMaximum()
	 */
	public Number getMaximum() {
		return MAX;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPStateVariable#getStep()
	 */
	public Number getStep() {
		return STEP;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPStateVariable#sendsEvents()
	 */
	public boolean sendsEvents() {
		return SENDEVENT;
	}

	public abstract void start(BundleContext bundleContext) throws Exception;
	public abstract void stop(BundleContext bundleContext) throws Exception;
}