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
package org.apache.felix.upnp.devicegen.uuid;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.text.MessageFormat;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

/**
 * This helper generates persistent UUID for UPnP device
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */
public class UUIDHelper {

	private static SecureRandom secureRandom; // lazy instanciation
	private static Object forSync=new Object();

	/**
	 * format of the uuid
	 * {0} is the IP address
	 * {1} is the timestamp
	 * {2} is a secure (so unique) 64 bits number
	 * {3} is the bundle symbolic name
	 */
	//static MessageFormat messageFormat=new MessageFormat("uuid:{3}-{2}");
	private static MessageFormat messageFormat=new MessageFormat("uuid:{3}-{2}@{1}");
	//static MessageFormat messageFormat=new MessageFormat("uuid:{0}-{1}-{2}");
	
	public static String getUUID(BundleContext bundleContext, boolean persistent){
		
		String uuid=null;
		
		// read the bundle entry CONFIG-INF/uuid.txt
		
		if(persistent){
			// else read uuid.txt in cache
		}
		
		// else generate a uuid
		if(secureRandom==null){ // lazy instanciation
			synchronized (forSync) {
				if(secureRandom==null){
					secureRandom=new SecureRandom();
				}				
			}
		}
		
		String ipaddress="";
		try {
			InetAddress inetAddress=null;
			inetAddress=Inet4Address.getLocalHost();
			if(inetAddress!=null) ipaddress=inetAddress.toString();
		} catch (UnknownHostException e) {
		}

		Object[] params=new Object[]{
				ipaddress,
				new Long(System.currentTimeMillis()),
				new Long(secureRandom.nextLong()), // could by secureRandom.nextBytes(128 bits byte[])		
				bundleContext.getBundle().getHeaders().get(Constants.BUNDLE_SYMBOLICNAME)		
		};
		
		
		
		uuid=messageFormat.format(params);
		
		if(persistent){
			
			// save the generated uuid in CONFIG-INF/uuid.txt in the cache

		}
		
		return uuid;
	}
	
	
	public static void resetUUID(BundleContext bundleContext){
		// delete CONFIG-INF/uuid.txt in the cache
		;
	}
}
