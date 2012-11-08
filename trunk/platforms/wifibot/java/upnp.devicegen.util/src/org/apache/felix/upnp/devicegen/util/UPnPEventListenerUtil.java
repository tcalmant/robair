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

import java.io.PrintStream;
import java.util.Dictionary;
import java.util.Enumeration;

import org.osgi.service.upnp.UPnPStateVariable;

/**
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */
public class UPnPEventListenerUtil {

	/**
	 *  trace the event received by org.osgi.service.upnp.UPnPEventListener
	 * 
	 * @param deviceId
	 *            ID of the device sending the events
	 * @param serviceId
	 *            ID of the service sending the events
	 * @param events
	 *            Dictionary object containing the new values for the state
	 *            variables that have changed.
	 * @see org.osgi.service.upnp.UPnPEventListener#notifyUPnPEvent(java.lang.String,
	 *      java.lang.String, java.util.Dictionary)
	 */

	public static void traceEvent(PrintStream printStream, String deviceId,
			String serviceId, Dictionary events) {

		StringBuffer sb = new StringBuffer();
		sb.append("UPnPEvent:[deviceId=").append(deviceId);
		sb.append(",serviceId=").append(serviceId);
		sb.append(",[");
		Enumeration enumeration = events.keys();
		while (enumeration.hasMoreElements()) {
			Object key = enumeration.nextElement();
			Object newValue = events.get(key);
			Object name;
			if (key instanceof UPnPStateVariable) {
				/*
				 * 25.8 says: One or multiple events are passed as parameters to
				 * the notifyUPnPEvent( String ,String,Dictionary) method. The
				 * Dictionary object holds a pair of UpnPStateVariab le objects
				 * that triggered the event and an Object for the new value of
				 * the state variable.
				 */
				name = ((UPnPStateVariable) key).getName();
			} else {
				name = key;
			}
			sb.append("[\"").append(name).append(
					"\"(" + newValue.getClass().getName() + "),");
			sb.append(newValue).append("]");
			if (enumeration.hasMoreElements())
				sb.append(',');
		}
		sb.append("]]");
		String msg = sb.toString();
		printStream.println(msg);

	}
}