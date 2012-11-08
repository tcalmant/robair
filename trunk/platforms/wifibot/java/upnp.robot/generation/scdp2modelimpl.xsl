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
package <xsl:value-of select="$package"/>.impl;

import org.apache.felix.upnp.devicegen.holder.*;
import org.osgi.service.upnp.UPnPException;
import <xsl:value-of select="$package"/>.model.*;

	<xsl:apply-templates select="*"/>
</xsl:template>

<xsl:template match="scpd">
public class <xsl:value-of select="$classname"/>ModelImpl implements <xsl:value-of select="$classname"/>Model {		
	<xsl:variable name="dummy" select="java:UPnPStateVariableTable.clean()"/>
	<xsl:apply-templates select="serviceStateTable/stateVariable" mode="memberdeclaration"/>

	<xsl:apply-templates select="actionList/action"  mode="itfdefinition"/>	

	// Those getters are used for the first notification just after a subscription
	<xsl:apply-templates select="serviceStateTable/stateVariable" mode="getterdefinition"/>	
}
</xsl:template>

<xsl:template match="stateVariable" mode="memberdeclaration">
	<xsl:variable name="dummy" select="java:UPnPStateVariableTable.add(./name,./dataType)"/>
</xsl:template>
	
	
<xsl:template match="serviceStateTable/stateVariable" mode="getterdefinition">
	<xsl:variable name="stateVariableName" select="java:GenerationUtility.capitalize(./name)"/>

	<!--  create only if sendEventsAttribute is not 'no' and if name does not start by A_ARG -->	
	<xsl:choose>
	<xsl:when test="self::node()[starts-with(name,'A_ARG')]"></xsl:when>
	<xsl:otherwise>	
		<xsl:choose>
		<xsl:when test="self::node()[sendEventsAttribute='no']"></xsl:when>
		<xsl:otherwise>
		public <xsl:value-of select="java:UPnPStateVariableTable.getClassName(./name)"/> get<xsl:value-of select="$stateVariableName"/>StateVariableValue(){
			// TODO
			return null;
		}		
		</xsl:otherwise>
		</xsl:choose>
	</xsl:otherwise>
	</xsl:choose>	
	
</xsl:template>

<xsl:template match="action"  mode="itfdefinition">
	<xsl:variable name="actionName" select="java:GenerationUtility.variabilize(./name)"/>
	/**
	 * This method is "add description here"	
<xsl:apply-templates select="argumentList" mode="comment"/>
	 */
	public void <xsl:value-of select="$actionName"/>(
		<xsl:apply-templates select="argumentList" mode="param"/>
	) throws UPnPException {
		// TODO
		throw new UPnPException(UPnPException.DEVICE_INTERNAL_ERROR,"Not implemented");
	}

</xsl:template>

<xsl:template match="argumentList" mode="param">
		<xsl:apply-templates select="argument" mode="param"/>
</xsl:template>

<xsl:template match="argument[last()]" mode="param">
	<xsl:variable name="paramName" select="java:GenerationUtility.variabilize(./name)"/>

	<xsl:choose>
		<xsl:when test="self::node()[direction='in']"><xsl:value-of select="java:UPnPStateVariableTable.getInputJavaType(./relatedStateVariable)"/></xsl:when>
		<xsl:when test="self::node()[direction='out']"><xsl:value-of select="java:UPnPStateVariableTable.getOutputJavaType(./relatedStateVariable)"/></xsl:when>
	</xsl:choose><xsl:text> </xsl:text><xsl:value-of select="$paramName"/>

</xsl:template>
	
<xsl:template match="argument" mode="param">
	<xsl:variable name="paramName" select="java:GenerationUtility.variabilize(./name)"/>

	<xsl:choose>
		<xsl:when test="self::node()[direction='in']"><xsl:value-of select="java:UPnPStateVariableTable.getInputJavaType(./relatedStateVariable)"/></xsl:when>
		<xsl:when test="self::node()[direction='out']"><xsl:value-of select="java:UPnPStateVariableTable.getOutputJavaType(./relatedStateVariable)"/></xsl:when>
	</xsl:choose><xsl:text> </xsl:text><xsl:value-of select="$paramName"/>,

</xsl:template>

<xsl:template match="argumentList" mode="comment">
		<xsl:apply-templates select="argument" mode="comment"/>
</xsl:template>

<xsl:template match="argument" mode="comment">
	<xsl:variable name="paramName" select="java:GenerationUtility.variabilize(./name)"/>

	<xsl:text> * </xsl:text><xsl:value-of select="$paramName"/>
	<xsl:choose>
		<xsl:when test="self::node()[direction='in']"> in </xsl:when>
		<xsl:when test="self::node()[direction='out']"> out </xsl:when>
	</xsl:choose> parameter

</xsl:template>

<xsl:template match="*"></xsl:template>

</xsl:stylesheet>
