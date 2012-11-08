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
package <xsl:value-of select="$package"/>.service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.osgi.framework.*;
import org.osgi.service.upnp.*;
import org.apache.felix.upnp.devicegen.util.*;
import org.apache.felix.upnp.devicegen.holder.*;

import <xsl:value-of select="$package"/>.model.*;
import <xsl:value-of select="$package"/>.impl.*;

	<xsl:apply-templates select="*"/>
</xsl:template>

<xsl:template match="scpd">

public class <xsl:value-of select="$classname"/> extends AbstractUPnPService {
	<xsl:variable name="dummy" select="java:UPnPStateVariableTable.clean()"/>
	<xsl:apply-templates select="serviceStateTable/stateVariable" mode="memberdeclaration"/>
	<xsl:apply-templates select="actionList/action" mode="memberdeclaration"/>
		
	private <xsl:value-of select="$classname"/>Model model;	
		
	/**
	 * constructor
	 */
	public <xsl:value-of select="$classname"/>(
		UPnPDevice upnpDevice,
		String serviceId,
		String serviceType,
		String version,
		<xsl:value-of select="$classname"/>Model model
	){
		super(	
			upnpDevice,
			serviceId,
			serviceType,
			version
		);
		this.model=model;
	
		<xsl:apply-templates select="serviceStateTable" mode="initialize"/>	
		<xsl:apply-templates select="actionList" mode="initialize"/>	
	}

	// UPnPStateVariable classes
	
	<xsl:apply-templates select="serviceStateTable/stateVariable" mode="classdeclaration"/>	

	// UPnPAction classes
	
	<xsl:apply-templates select="actionList/action"  mode="classdeclaration"/>	
}
</xsl:template>


<xsl:template match="stateVariable" mode="memberdeclaration">
	<xsl:variable name="className" select="java:GenerationUtility.capitalize(./name)"/>
	<xsl:variable name="variableName" select="java:GenerationUtility.variabilize(./name)"/>
	<xsl:variable name="dummy" select="java:UPnPStateVariableTable.add(./name,./dataType)"/>
<!--
		private <xsl:value-of select="$className"/>StateVariable <xsl:value-of select="$variableName"/>;
-->
</xsl:template>

<xsl:template match="serviceStateTable" mode="initialize">
	stateVariables=new HashMap();
	<xsl:apply-templates select="stateVariable" mode="initialize"/>	
</xsl:template>


<xsl:template match="stateVariable" mode="initialize">
	<xsl:variable name="className" select="java:GenerationUtility.capitalize(./name)"/>
	<xsl:variable name="variableName" select="java:GenerationUtility.variabilize(./name)"/>

<!--
	this.<xsl:value-of select="$variableName"/> = new <xsl:value-of select="$className"/>StateVariable(this);
	stateVariables.put(
		"<xsl:value-of select="./name"/>",
		<xsl:value-of select="$variableName"/>
	);
-->	
	stateVariables.put(
		"<xsl:value-of select="./name"/>",
		new <xsl:value-of select="$className"/>StateVariable(this,model)
	);
</xsl:template>

<xsl:template match="allowedValueList">
	/*
		List allowedValueList=new LinkedList();
		<xsl:apply-templates select="allowedValue"/>
		this.setallowedValueList(allowedValueList);
	*/
</xsl:template>

<xsl:template match="allowedValue">
		allowedValueList.add(UPnPDataTypeUtil.instanciateObject("<xsl:value-of select="../../dataType"/>","<xsl:value-of select="."/>"));
</xsl:template>

<xsl:template match="stateVariable" mode="classdeclaration">
	<xsl:variable name="className" select="java:GenerationUtility.capitalize(./name)"/>
	<xsl:variable name="stateVariableClassName"><xsl:value-of select="$className"/>StateVariable</xsl:variable>

// class <xsl:value-of select="$className"/>StateVariable
public class <xsl:value-of select="$stateVariableClassName"/>
  extends AbstractUPnPStateVariable
		<!--  create only if sendEventsAttribute is not 'no' -->	
	<xsl:choose>
		<xsl:when test="self::node()[sendEventsAttribute='no']">{</xsl:when>
		<xsl:otherwise>  implements UPnPStateVariableDescriptor{</xsl:otherwise>
	</xsl:choose>

	public final static String NAME="<xsl:value-of select="./name"/>";
	public final static String DATATYPE="<xsl:value-of select="./dataType"/>";
	
	// HERE specific state variable members
	private <xsl:value-of select="$classname"/>Model model;
	
	public <xsl:value-of select="$stateVariableClassName"/>(
		UPnPService upnpService,
		<xsl:value-of select="$classname"/>Model model
	){	
		super(
					upnpService,
					NAME,
					DATATYPE,
					null, // TODO defaultValue changed for <xsl:value-of select="./defaultValue"/>
					null, // TODO step changed for <xsl:value-of select="./step"/>
					null, // TODO step changed for <xsl:value-of select="./step"/>
					null, // TODO minimum changed for <xsl:value-of select="./allowedValueRange/minimum"/>
					null, // TODO maximum changed for <xsl:value-of select="./allowedValueRange/maximum"/>
					// sendEventsAttribute
	<xsl:choose>
	<xsl:when test="self::node()[starts-with(name,'A_ARG')]">false</xsl:when>
	<xsl:otherwise>	
		<xsl:choose>
		<xsl:when test="self::node()[sendEventsAttribute='no']">false</xsl:when>
		<xsl:otherwise>true</xsl:otherwise>
		</xsl:choose>
	</xsl:otherwise>
	</xsl:choose>,
					true  // TODO required changed for <xsl:value-of select="./Optional"/> OR <xsl:value-of select="./Required"/>
		);
		
		this.model=model;

		<xsl:apply-templates select="./allowedValueList"/>
	}
	
	// TODO
	
	public void start(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
		<!--  create only if sendEventsAttribute is not 'no' -->	
	/**
	 * invoked for the first notification just after a subscription
	 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
	 */
	public Object getValue(){
	<xsl:choose>
	<xsl:when test="self::node()[starts-with(name,'A_ARG')]">return null;</xsl:when>
	<xsl:otherwise>	
	<xsl:choose>
		<xsl:when test="self::node()[sendEventsAttribute='no']">return null;</xsl:when>
		<xsl:otherwise>
		return model.get<xsl:value-of select="$stateVariableClassName"/>Value();
		</xsl:otherwise>
	</xsl:choose>
	</xsl:otherwise>
	</xsl:choose>
	}
};
</xsl:template>

<xsl:template match="action" mode="memberdeclaration">
	<xsl:variable name="className" select="java:GenerationUtility.capitalize(./name)"/>
	<xsl:variable name="actionName" select="java:GenerationUtility.variabilize(./name)"/>

<!--
	private <xsl:value-of select="$className"/>Action <xsl:value-of select="$actionName"/>;
-->
</xsl:template>

<xsl:template match="actionList" mode="initialize">
	actions=new HashMap();
	<xsl:apply-templates select="action" mode="initialize"/>	
</xsl:template>

<xsl:template match="action" mode="initialize">
	<xsl:variable name="className" select="java:GenerationUtility.capitalize(./name)"/>
	<xsl:variable name="actionName" select="java:GenerationUtility.variabilize(./name)"/>

<!--
	this.<xsl:value-of select="$actionName"/> = new <xsl:value-of select="$className"/>Action(this);
	actions.put(
		"<xsl:value-of select="./name"/>",
		<xsl:value-of select="$actionName"/>
	);
-->
	actions.put(
		"<xsl:value-of select="./name"/>",
		new <xsl:value-of select="$className"/>Action(this,model)
	);
</xsl:template>

<xsl:template match="action"  mode="classdeclaration">
	<xsl:variable name="className" select="java:GenerationUtility.capitalize(./name)"/>
	<xsl:variable name="actionName" select="java:GenerationUtility.variabilize(./name)"/>

public class <xsl:value-of select="$className"/>Action extends AbstractUPnPAction {

	<xsl:value-of select="$classname"/>Model model;
	
	// HERE specific action members
	
	public <xsl:value-of select="$className"/>Action(
	    UPnPService upnpService,
		<xsl:value-of select="$classname"/>Model model
	){
		super(
			upnpService,
			"<xsl:value-of select="./name"/>",
			"<xsl:value-of select="./result"/>"
		);
		this.model=model;
		<xsl:apply-templates select="argumentList" mode="in.init"/>
		<xsl:apply-templates select="argumentList" mode="out.init"/>
	}

	/**
	 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
	 */
	public Dictionary invoke(Dictionary _args) throws Exception {

	<xsl:apply-templates select="action"  mode="classdeclaration"/>

		<xsl:apply-templates select="argumentList/argument" mode="pre.invoke"/>

		// invoke model
		
		 model.<xsl:value-of select="$actionName"/>(
			<xsl:apply-templates select="argumentList" mode="invoke.model"/>
		 );
		
		// build returned Dictionary		
		Dictionary _result = new Hashtable();
		<xsl:apply-templates select="argumentList/argument" mode="post.invoke"/>
		return _result.isEmpty()?null:_result;
	}


	public void start(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO
	}
};
</xsl:template>

<xsl:template match="argumentList" mode="in.init">
		<xsl:apply-templates select="argument" mode="in.init"/>
</xsl:template>

<xsl:template match="argument" mode="in.init">
	<xsl:choose>
		<xsl:when test="self::node()[direction='in']">
			addInArg(
				"<xsl:value-of select="./name"/>",
				upnpService.getStateVariable("<xsl:value-of select="./relatedStateVariable"/>")
			);
		</xsl:when>
	</xsl:choose>
</xsl:template>

<xsl:template match="argumentList" mode="out.init">
		<xsl:apply-templates select="argument" mode="out.init"/>
</xsl:template>

<xsl:template match="argument" mode="out.init">
	<xsl:choose>
		<xsl:when test="self::node()[direction='out']">
			addOutArg(
				"<xsl:value-of select="./name"/>",
				upnpService.getStateVariable("<xsl:value-of select="./relatedStateVariable"/>")
			);
		</xsl:when>
	</xsl:choose>
</xsl:template>

<xsl:template match="argumentList/argument" mode="pre.invoke">
	<xsl:choose>
		<xsl:when test="self::node()[direction='in']">
				<xsl:value-of select="java:UPnPStateVariableTable.getClassName(./relatedStateVariable)"/><xsl:text> </xsl:text>
				<xsl:value-of select="java:GenerationUtility.variabilize(./name)"/> = (<xsl:value-of select="java:UPnPStateVariableTable.getClassName(./relatedStateVariable)"/>) _args.get("<xsl:value-of select="./name"/>");
		</xsl:when>
		<xsl:when test="self::node()[direction='out']">
				<xsl:value-of select="java:UPnPStateVariableTable.getOutputJavaType(./relatedStateVariable)"/><xsl:text> </xsl:text>
				<xsl:value-of select="java:GenerationUtility.variabilize(./name)"/> = new <xsl:value-of select="java:UPnPStateVariableTable.getOutputJavaType(./relatedStateVariable)"/>();
		</xsl:when>
	</xsl:choose>
</xsl:template>
	
<xsl:template match="argumentList/argument" mode="post.invoke">
	<xsl:choose>
		<xsl:when test="self::node()[direction='out']">
			_result.put("<xsl:value-of select="./name"/>",<xsl:value-of select="java:GenerationUtility.variabilize(./name)"/>.getObject());
			// <xsl:value-of select="java:UPnPStateVariableTable.getClassName(./relatedStateVariable)"/>	
		</xsl:when>
	</xsl:choose>
</xsl:template>


<xsl:template match="argumentList" mode="invoke.model">
			<xsl:apply-templates select="argument" mode="invoke.model"/>
</xsl:template>

<xsl:template match="argument[last()]" mode="invoke.model">
	<xsl:variable name="paramName" select="java:GenerationUtility.variabilize(./name)"/>


	<xsl:choose>
		<xsl:when test="self::node()[direction='in']">
			<xsl:value-of select="java:UPnPStateVariableTable.getOutputJavaType(./relatedStateVariable)"/>.toValue(
			<xsl:value-of select="java:GenerationUtility.variabilize(./name)"/>)
		</xsl:when>
		<xsl:when test="self::node()[direction='out']">
			<xsl:value-of select="java:GenerationUtility.variabilize(./name)"/>
		</xsl:when>
	</xsl:choose>

</xsl:template>


<xsl:template match="argument" mode="invoke.model">
	<xsl:variable name="paramName" select="java:GenerationUtility.variabilize(./name)"/>

	<xsl:choose>
		<xsl:when test="self::node()[direction='in']">
			<xsl:value-of select="java:UPnPStateVariableTable.getOutputJavaType(./relatedStateVariable)"/>.toValue(
			<xsl:value-of select="java:GenerationUtility.variabilize(./name)"/>)
		</xsl:when>
		<xsl:when test="self::node()[direction='out']">
			<xsl:value-of select="java:GenerationUtility.variabilize(./name)"/>
		</xsl:when>
	</xsl:choose>,

</xsl:template>


<xsl:template match="*"></xsl:template>

</xsl:stylesheet>
