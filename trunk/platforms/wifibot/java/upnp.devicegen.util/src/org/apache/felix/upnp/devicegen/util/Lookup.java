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

import java.util.ArrayList;
import java.util.Iterator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPService;

/**
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */
public class Lookup {
    
    static BundleContext context;
    private ArrayList references = new ArrayList();
    
    public UPnPService getService(String deviceId,String serviceId){
		UPnPDevice device = getDevice(deviceId);
        if (device == null) return null;
		return device.getService(serviceId);
    }
    
    public UPnPDevice getDevice(String deviceId){
		ServiceReference sr = getReference(deviceId);
        if (sr == null) return null;
		return getDevice(sr);
    }
    
    private UPnPDevice getDevice(ServiceReference sr){
        references.add(sr);
        return(UPnPDevice) context.getService(sr);        
    }
    
    public ServiceReference getReference(String deviceId){
		try {
		    String filter = "(" + UPnPDevice.ID + "="+ deviceId + ")";
		    ServiceReference[] listeners = context.getServiceReferences(UPnPDevice.class.getName(),filter);
			if (listeners != null)
				for (int i = 0;i<listeners.length;i++){
				    return listeners[i]; // the Device Id should be unique
				}
			return null;
		} catch (Exception ex) {
			System.out.println(ex);
	        return null; 
		}
    }
    
    public String getDeviceType(String deviceId){
        ServiceReference sr = getReference(deviceId);
        if (sr == null) return null;
        return (String) sr.getProperty(UPnPDevice.TYPE);
    }
    
    public Object getDeviceProperty(String deviceId,String key){
        ServiceReference sr = getReference(deviceId);
        if (sr == null) return null;
        return  sr.getProperty(key);
    }
    
    public String getServiceType(String deviceId, String serviceId){
		UPnPDevice device = getDevice(deviceId);
        if (device == null) return null;
		return device.getService(serviceId).getType();
    }
    
    public boolean isRootDevice(String deviceId){
        ServiceReference sr = getReference(deviceId);
        //if (sr == null) return null;
        String parent =  (String) sr.getProperty(UPnPDevice.PARENT_UDN);
        if((parent == null)||parent.equals("")) return true;
        return false;              
    }
    
    public UPnPDevice getRootDevice(String deviceId) {
        ServiceReference sr = getReference(deviceId);
        String parent =  (String) sr.getProperty(UPnPDevice.PARENT_UDN);
        if((parent == null)||parent.equals("")) 
            return getDevice(sr);
        else
            return getRootDevice(parent);        
    }
    
    public void ungetServices(){
        Iterator list = this.references.iterator();
        while( list.hasNext()){
            ServiceReference sr = (ServiceReference) list.next();
            context.ungetService(sr);
            list.remove();
        }
    }

}
