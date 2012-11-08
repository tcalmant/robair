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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.upnp.UPnPStateVariable;

/**
 * utility class to obtains java class for UPnP data type
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */
public class UPnPDataTypeUtil {

	private static Map dataTypeMap;
	static {
		dataTypeMap = new HashMap();
		dataTypeMap.put(UPnPStateVariable.TYPE_UI1, Integer.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_UI2, Integer.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_UI4, Long.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_I1, Integer.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_I2, Integer.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_I4, Integer.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_INT, Integer.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_R4, Float.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_R8, Double.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_NUMBER, Double.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_FIXED_14_4, Double.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_FLOAT, Float.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_CHAR, Character.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_STRING, String.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_DATE, Date.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_DATETIME, Date.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_DATETIME_TZ, Date.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_TIME, Long.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_TIME_TZ, Long.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_BOOLEAN, Boolean.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_BIN_BASE64, byte[].class);
		dataTypeMap.put(UPnPStateVariable.TYPE_BIN_HEX, byte[].class);
		dataTypeMap.put(UPnPStateVariable.TYPE_URI, String.class);
		dataTypeMap.put(UPnPStateVariable.TYPE_UUID, String.class);
	}
	
	public static Class getClass(String upnpDataType){
		return (Class)dataTypeMap.get(upnpDataType);
	}

	public static String getClassName(String upnpDataType)throws IllegalArgumentException {
		Class clazz=(Class)dataTypeMap.get(upnpDataType);
		if(clazz==null) throw new IllegalArgumentException("No class for "+upnpDataType); 
		return clazz.getName();
	}

	public static Object instanciateObject(String upnpDataType, String value){
		Class clazz=(Class)dataTypeMap.get(upnpDataType);
		if(clazz.equals(Integer.class)) return new Integer(value);
		if(clazz.equals(Long.class)) return new Long(value);
		if(clazz.equals(Float.class)) return new Float(value);
		if(clazz.equals(Double.class)) return new Double(value);
		if(clazz.equals(Boolean.class)) return new Boolean(value);
		if(clazz.equals(String.class)) return new String(value);
		if(clazz.equals(Character.class)) return new Character(value.charAt(0));

		// TODO TYPE_DATE,TYPE_BIN_BASE64, TYPE_BIN_HEX
		if(clazz==null) throw new IllegalArgumentException("Can not instanciate object for "+upnpDataType); 		
		return null;
	}

}