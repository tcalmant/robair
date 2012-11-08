/*
 *  Configuration utility
 *
 *  Copyright (C) 2003  Didier Donsez
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Library General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Library General Public License for more details.
 *
 *  You should have received a copy of the GNU Library General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 *  Contact: Didier Donsez (Didier.Donsez@ieee.org)
 *  Contributor(s):
 *
 */
package fr.imag.adele.bundle.configuration;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import org.osgi.framework.BundleContext;

/**
 *  configuration utility
 *
 *@author     donsez
 *@created    3 avril 2003
 */
public class Configuration {
	static String DEFAULT_PROPERTIES_FILE = "initialstate.properties";


	/**
	 *  loads properties from a file
	 *
	 *@param  filename  the properties file name
	 *@return           the properties
	 */
	public static Properties loadProperties(String filename) {
		if (filename == null) {
			filename = System.getProperty("fr.imag.adele.bundle.util.configuration.file", DEFAULT_PROPERTIES_FILE);
		}
		try {
			return loadProperties(new FileInputStream(filename));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	/**
	 *  loads properties from a input stream
	 *
	 *@param  in	  the imput stream
	 *@return           the properties
	 */
	public static Properties loadProperties(InputStream in) {
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return prop;
	}

	public static InputStream getPropertiesInputStream(BundleContext bundleContext) {
		String configLocation=null;
		Properties props=null;
		Dictionary dict=bundleContext.getBundle().getHeaders();
		Enumeration enum=dict.keys();
		while(enum.hasMoreElements()){
			Object nextKey=enum.nextElement();
			Object nextElem=dict.get(nextKey);
			if (nextKey.equals("Config-Location")){
				configLocation=nextElem.toString();
				break;
			}
		}
		if(configLocation==null) {
			configLocation=DEFAULT_PROPERTIES_FILE;
		}

		// Load properties from configLocation file
		// and create and register a service
		InputStream sourcestream = Configuration.class.getResourceAsStream(configLocation);
		return sourcestream;
	}
	
	
	/**
	 *  builds a map from properties. the key list is in the property keyListPropertyName
	 * <br>Example getMap(props,"keylist") returns a hashtable with 3 key-value entry
	 * <pre>
	 * keylist=bar;bubba;foo
	 * bar=BAR
	 * foo=1.5;float
	 * bubba=100;int
	 * </pre>
	 *
	 *@param  props                the properties
	 *@param  keyListPropertyName  the property name of the key list (separed by ;)
	 *@return                      The map
	 */
	public static Map getMap(Properties props, String keyListPropertyName) {
		return getHashtable(props, keyListPropertyName);
	}	
	
	/**
	 *  builds a hashtable from properties. the key list is in the property keyListPropertyName
	 * <br>Example getHashtable(props,"keylist") returns a hashtable with 3 key-value entry
	 * <pre>
	 * keylist=bar;bubba;foo
	 * bar=BAR
	 * foo=1.5;float
	 * bubba=100;int
	 * </pre>
	 *
	 *@param  props                the properties
	 *@param  keyListPropertyName  the property name of the key list (separed by ;)
	 *@return                      The hashtable
	 */
	public static Hashtable getHashtable(Properties props, String keyListPropertyName) {

		StringTokenizer st = new StringTokenizer(props.getProperty(keyListPropertyName), ";");
		Hashtable map = new Hashtable();

		while (st.hasMoreTokens()) {
			String key = st.nextToken();
			StringTokenizer stvaluetype = new StringTokenizer(props.getProperty(key), ";");
			Object obj = null;
			if (stvaluetype.hasMoreTokens()) {
				String value = stvaluetype.nextToken();
				if (stvaluetype.hasMoreTokens()) {
					String type = stvaluetype.nextToken();
					if (type.equals("int")) {
						obj = new Integer(value);
					} else if (type.equals("long")) {
						obj = new Long(value);
					} else if (type.equals("float")) {
						obj = new Float(value);
					} else if (type.equals("double")) {
						obj = new Double(value);
					} else if (type.equals("string")) {
						obj = value;
					} else {
						// default : string
						obj = value;
					}
				} else {
					// no type means String
					obj = value;
				}

			}
			map.put(key, obj);
		}
		return map;
	}
	
	/**
	 *  builds a (ordered) vector from properties. the index list is in the property keyListPropertyName
	 * <br>Example getVector(props,"tab") returns a 4 elements vector (tab.5 is ignored since tab.4 does not exist)
	 * <pre>
	 * tab.0=bar
	 * tab.1=foo
	 * tab.2=1.5;float
	 * tab.3=100;int
	 * tab.5=10000;long
	 * </pre>
	 *@param  props                the properties
	 *@param  vectorPropertyName  the property name of the key list (separed by ;)
	 *@return                      The vector
	 */
	public static Vector getVector(Properties props, String vectorPropertyName) {

		Vector vect = new Vector();

		for(int i=0;true;i++) {
			String valuetype = props.getProperty(vectorPropertyName)+"."+i;
			if(valuetype==null) break;
			StringTokenizer stvaluetype = new StringTokenizer(valuetype, ";");
			Object obj = null;
			if (stvaluetype.hasMoreTokens()) {
				String value = stvaluetype.nextToken();
				if (stvaluetype.hasMoreTokens()) {
					String type = stvaluetype.nextToken();
					if (type.equals("int")) {
						obj = new Integer(value);
					} else if (type.equals("long")) {
						obj = new Long(value);
					} else if (type.equals("float")) {
						obj = new Float(value);
					} else if (type.equals("double")) {
						obj = new Double(value);
					} else if (type.equals("string")) {
						obj = value;
					} else {
						// default : string
						obj = value;
					}
				} else {
					// no type means String
					obj = value;
				}

			}
			vect.addElement(obj);
		}
		return vect;
	}
}


