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
import java.io.IOException;
import java.io.InputStream;

import org.osgi.service.upnp.UPnPIcon;

public class DeviceIcon implements UPnPIcon {

	private String mimetype;
	private int width;
	private int height;
	private int size;
	private int depth;
	private String urlStr;
	private ClassLoader classLoader;
	
	public DeviceIcon(
			 String mimetype,
			 int width,
			 int height,
			 int size,
			 int depth,
			 String urlStr,
			 ClassLoader classLoader
	){
		 this.mimetype=mimetype;
		 this.width=width;
		 this.height=height;
		 this.size=size;
		 this.depth=depth;
		 this.urlStr=urlStr;
		 this.classLoader=classLoader;
	}
	
	/**
	 * @see org.osgi.service.upnp.UPnPIcon#getMimeType()
	 */
	public String getMimeType() {
		return "image/png";
	}

	/**
	 * @see org.osgi.service.upnp.UPnPIcon#getWidth()
	 */
	public int getWidth() {
		return 32;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPIcon#getHeight()
	 */
	public int getHeight() {
		return 32;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPIcon#getSize()
	 */
	public int getSize() {
		return 0;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPIcon#getDepth()
	 */
	public int getDepth() {
		return 16;
	}

	/**
	 * @see org.osgi.service.upnp.UPnPIcon#getInputStream()
	 */
	public InputStream getInputStream() throws IOException {
		return classLoader.getResourceAsStream(urlStr);
		//return Thread.currentThread().getContextClassLoader().getResourceAsStream(urlStr);
		//return DeviceIcon.class.getResourceAsStream(urlStr);
	}
}

