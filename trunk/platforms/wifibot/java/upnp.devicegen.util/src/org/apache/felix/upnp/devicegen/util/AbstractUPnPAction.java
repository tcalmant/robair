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

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPAction;
import org.osgi.service.upnp.UPnPService;
import org.osgi.service.upnp.UPnPStateVariable;

/*
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */

public abstract class AbstractUPnPAction
  implements UPnPAction, BundleActivator {
		final private UPnPService upnpService;
		final private String NAME;
		final private String RESULT_STATUS;
		private String[] IN_ARG_NAMES;
		private String[] OUT_ARG_NAMES;
		private Map inArgNames=new HashMap();				
		private Map outArgNames=new HashMap();				

		// HERE specific action members
		
		public AbstractUPnPAction(
				UPnPService upnpService,
				String NAME,
				String RESULT_STATUS
		){
			this.upnpService=upnpService;
			this.NAME=NAME;
			this.RESULT_STATUS=RESULT_STATUS;
		}

		protected void addInArg(String argName,UPnPStateVariable upnpStateVariable){
			inArgNames.put(argName,upnpStateVariable);
		}

		protected void addOutArg(String argName,UPnPStateVariable upnpStateVariable){
			outArgNames.put(argName,upnpStateVariable);
		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#getName()
		 */
		public String getName() {
			return NAME;
		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#getReturnArgumentName()
		 */
		public String getReturnArgumentName() {
			return RESULT_STATUS;
		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#getInputArgumentNames()
		 */
		public String[] getInputArgumentNames() {
			if(IN_ARG_NAMES==null)
				IN_ARG_NAMES=(String[]) inArgNames.keySet().toArray(new String[]{});
			return 	IN_ARG_NAMES;
		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#getOutputArgumentNames()
		 */
		public String[] getOutputArgumentNames() {
			if(OUT_ARG_NAMES==null)
				OUT_ARG_NAMES=(String[]) outArgNames.keySet().toArray(new String[]{});
			return OUT_ARG_NAMES;
		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#getStateVariable(java.lang.String)
		 */
		public UPnPStateVariable getStateVariable(String argumentName) {
			UPnPStateVariable sv=(UPnPStateVariable)inArgNames.get(argumentName);
			if(sv!=null) return sv;
			return (UPnPStateVariable)outArgNames.get(argumentName);
		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
	public abstract Dictionary invoke(Dictionary args) throws Exception;
	public abstract void start(BundleContext bundleContext) throws Exception;
	public abstract void stop(BundleContext bundleContext) throws Exception;
}