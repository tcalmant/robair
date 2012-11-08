<?xml version="1.0"?>
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
package <xsl:value-of select="$package"/>;

import fr.imag.adele.util.upnp.holder.*;

	<xsl:apply-templates select="*"/>
</xsl:template>

<xsl:template match="scpd">
public interface <xsl:value-of select="$classname"/>Model {		

	<xsl:apply-templates select="actionList/action"  mode="itfdeclaration"/>	

	// Those getters are used for the first notification just after a subscription
	<xsl:apply-templates select="serviceStateTable/stateVariable" mode="getterdeclaration"/>	
}
</xsl:template>

<xsl:template match="serviceStateTable/stateVariable" mode="getterdeclaration">
	<xsl:variable name="stateVariableName" select="java:GenerationUtility.capitalize(./name)"/>

	<!--  create only if sendEventsAttribute is not 'no' -->	
	<xsl:choose>
		<xsl:when test="self::node()[sendEventsAttribute='no']"></xsl:when>
		<xsl:otherwise>
		<xsl:value-of select="java:UPnPStateVariableTable.getClassName(./name)"/> get<xsl:value-of select="$stateVariableName"/>StateVariableValue();		
		</xsl:otherwise>
	</xsl:choose>
	
</xsl:template>

<xsl:template match="action"  mode="itfdeclaration">
	<xsl:variable name="actionName" select="java:GenerationUtility.variabilize(./name)"/>
	/**
	 * This method is "add description here"	
<xsl:apply-templates select="argumentList" mode="comment"/>
	 */
	public void <xsl:value-of select="$actionName"/>(
		<xsl:apply-templates select="argumentList" mode="param"/>
	);
	// TODO return the type of the return argument when specified

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
