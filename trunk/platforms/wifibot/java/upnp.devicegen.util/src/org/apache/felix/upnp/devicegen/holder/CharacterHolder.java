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
package org.apache.felix.upnp.devicegen.holder;

/**
 * holder for out parameters 
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */
public class CharacterHolder {
	
	private char value;
	
	public CharacterHolder(){}
	
	public CharacterHolder(char initial){
		value=initial;
	}

	public void setValue(char value){
		this.value=value;
	}

	public char getValue(){
		return value;
	}

	public Character getObject(){
		return new Character(value);
	}

	
	public static char toValue(Character value){
		return value.charValue();
	}

}
