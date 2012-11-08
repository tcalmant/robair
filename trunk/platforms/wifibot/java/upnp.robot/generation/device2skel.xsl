<?xml version="1.0"?>
<!--
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
-->

<!--
 * @author Felix Project Team mailto:dev@felix.apache.org
-->
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    version="1.0"   
    xmlns:java="http://xml.apache.org/xslt/java"
    exclude-result-prefixes="java">
<xsl:output method = "text"/>

<!-- parameter declaration -->
<xsl:param name="author"/>
<xsl:param name="date"/>
<xsl:param name="package"/>
<xsl:param name="classname"/>


<xsl:template match="/">
/*
__BANNER__
*/
// this file was generated at <xsl:value-of select="$date"/> by <xsl:value-of select="$author"/>
package <xsl:value-of select="$package"/>.device;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPIcon;
import org.osgi.service.upnp.UPnPService;

import org.apache.felix.upnp.devicegen.util.AbstractUPnPDevice;
import org.apache.felix.upnp.devicegen.util.DeviceIcon;

import <xsl:value-of select="$package"/>.model.*;
import <xsl:value-of select="$package"/>.service.*;
import <xsl:value-of select="$package"/>.impl.*;


	<xsl:apply-templates select="*"/>
</xsl:template>

<xsl:template match="root">
	<xsl:variable name="URLBase" select="./URLBase"/>
	<xsl:apply-templates select="device" mode="classdeclaration"/>	
</xsl:template>

<xsl:template match="device" mode="initialize">
		<xsl:variable name="deviceType" select="java:UPnPGenerationUtility.deviceType(./deviceType)"/>
		<xsl:variable name="classname" select="$deviceType"/>
		addChild(new <xsl:value-of select="$classname"/>(bundleContext,this));
</xsl:template>

<xsl:template match="device" mode="classdeclaration">

public class <xsl:value-of select="$classname"/> extends AbstractUPnPDevice {

	public <xsl:value-of select="$classname"/>(BundleContext context, AbstractUPnPDevice parent) {
		super(context,parent);

		DEVICE_ID="<xsl:value-of select="./UDN"/>";

		// ServiceModel Declaration List
		<xsl:apply-templates select="serviceList" mode="declmodel"/>
		
		// Icon Lists
		<xsl:apply-templates select="iconList"/>

		// Service List
		<xsl:apply-templates select="serviceList" mode="add"/>

		// Embedded Device List
		<xsl:apply-templates select="deviceList" mode="initialize"/>
	
	}
	
	protected void setupDeviceProperties(){	
		dictionary.put(UPnPDevice.TYPE,"<xsl:value-of select="./deviceType"/>");
		dictionary.put(UPnPDevice.FRIENDLY_NAME,"<xsl:value-of select="./friendlyName"/>");
		dictionary.put(UPnPDevice.MANUFACTURER,"<xsl:value-of select="./manufacturer"/>");
		dictionary.put(UPnPDevice.MANUFACTURER_URL,"<xsl:value-of select="./manufacturerURL"/>");
		dictionary.put(UPnPDevice.MODEL_DESCRIPTION,"<xsl:value-of select="./modelDescription"/>");
		dictionary.put(UPnPDevice.MODEL_NAME,"<xsl:value-of select="./modelName"/>");
		dictionary.put(UPnPDevice.MODEL_NUMBER,"<xsl:value-of select="./modelNumber"/>");
		dictionary.put(UPnPDevice.MODEL_URL,"<xsl:value-of select="./modelURL"/>");
		dictionary.put(UPnPDevice.SERIAL_NUMBER,"<xsl:value-of select="./serialNumber"/>");
		dictionary.put(UPnPDevice.UDN,getUDN());
		dictionary.put(UPnPDevice.ID,dictionary.get(UPnPDevice.UDN));
		dictionary.put(UPnPDevice.UPC,"<xsl:value-of select="./UPC"/>");
		dictionary.put(UPnPDevice.PRESENTATION_URL,"<xsl:value-of select="./presentationURL"/>");		

		if(parent!=null) {
			dictionary.put(UPnPDevice.PARENT_UDN,parent.getUDN());
		}
		<![CDATA[
		if(children!=null && children.size()!=0){
			String[] childrenUDN=new String[children.size()];
			Iterator iter=children.iterator();
			for(int i=0;iter.hasNext();i++){
				childrenUDN[i]=((AbstractUPnPDevice)iter.next()).getUDN();
			}
			dictionary.put(UPnPDevice.CHILDREN_UDN,childrenUDN);
		}
		]]>
	}
}
</xsl:template>

<xsl:template match="iconList">
		List iconsList=new LinkedList();
	<xsl:apply-templates select="icon"/>
		icons=(UPnPIcon[])iconsList.toArray(new UPnPIcon[]{});
</xsl:template>


<xsl:template match="icon">
		iconsList.add(
				new DeviceIcon(
					"<xsl:value-of select="./mimetype"/>", // MimeType
					<xsl:value-of select="./width"/>, //Width
					<xsl:value-of select="./height"/>, // Height
					0, // ??
					<xsl:value-of select="./depth"/>, // Depth
					"<xsl:value-of select="./url"/>", // URL
					<xsl:value-of select="$classname"/>.class.getClassLoader()
				)
		);
</xsl:template>


<xsl:template match="serviceList" mode="declmodel">
	<xsl:apply-templates select="service" mode="declmodel"/>
</xsl:template>

<xsl:template match="service" mode="declmodel">
	
	<xsl:variable name="serviceType" select="java:UPnPGenerationUtility.serviceType(./serviceType)"/>
	<xsl:variable name="serviceId" select="java:UPnPGenerationUtility.serviceId(./serviceId)"/>
	<xsl:variable name="serviceVersion" select="java:UPnPGenerationUtility.serviceVersion(./serviceType)"/>
	
	<xsl:value-of select="$serviceType"/>Model my<xsl:value-of select="$serviceId"/>Model=null; // TODO initialise it
</xsl:template>

<xsl:template match="serviceList" mode="add">
		List servicesList=new LinkedList();
	<xsl:apply-templates select="service" mode="add"/>
		services=(UPnPService[])servicesList.toArray(new UPnPService[]{});
</xsl:template>

<xsl:template match="service" mode="add">
	
	<xsl:variable name="serviceType" select="java:UPnPGenerationUtility.serviceType(./serviceType)"/>
	<xsl:variable name="serviceId" select="java:UPnPGenerationUtility.serviceId(./serviceId)"/>
	<xsl:variable name="serviceVersion" select="java:UPnPGenerationUtility.serviceVersion(./serviceType)"/>
	
		/*
				SCPDURL=<xsl:value-of select="./SCPDURL"/>
				controlURL=<xsl:value-of select="./controlURL"/>
				eventSubURL=<xsl:value-of select="./eventSubURL"/>
		*/
		servicesList.add(
				new <xsl:value-of select="$serviceType"/>(
						this,
						"<xsl:value-of select="./serviceId"/>",
						"<xsl:value-of select="./serviceType"/>",
						"<xsl:value-of select="$serviceVersion"/>",
						my<xsl:value-of select="$serviceId"/>Model									
				)
			);				
</xsl:template>

<xsl:template match="deviceList" mode="initialize">	
		//children=new LinkedList();
		<xsl:apply-templates select="device" mode="initialize"/>
</xsl:template>

<!--
declaration is done in a root class !
<xsl:template match="deviceList" mode="classdeclaration">	
		<xsl:apply-templates select="device" mode="classdeclaration"/>
</xsl:template>
-->

<xsl:template match="*"></xsl:template>

</xsl:stylesheet>
