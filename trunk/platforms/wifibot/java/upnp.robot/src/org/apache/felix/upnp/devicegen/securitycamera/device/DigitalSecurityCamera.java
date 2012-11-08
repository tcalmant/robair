/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.apache.felix.upnp.devicegen.securitycamera.device;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.felix.upnp.devicegen.securitycamera.model.DigitalSecurityCameraMotionImageModel;
import org.apache.felix.upnp.devicegen.securitycamera.model.DigitalSecurityCameraSettingsModel;
import org.apache.felix.upnp.devicegen.securitycamera.model.DigitalSecurityCameraStillImageModel;
import org.apache.felix.upnp.devicegen.securitycamera.service.DigitalSecurityCameraMotionImage;
import org.apache.felix.upnp.devicegen.securitycamera.service.DigitalSecurityCameraSettings;
import org.apache.felix.upnp.devicegen.securitycamera.service.DigitalSecurityCameraStillImage;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPDevice;
import org.apache.felix.upnp.devicegen.util.DeviceIcon;
import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPIcon;
import org.osgi.service.upnp.UPnPService;

public class DigitalSecurityCamera extends AbstractUPnPDevice {

	public DigitalSecurityCamera(BundleContext context,
			AbstractUPnPDevice parent) {
		super(context, parent);

		DEVICE_ID = "uuid:adele-securitycamera";

		// ServiceModel Declaration List
		DigitalSecurityCameraSettingsModel myDigitalSecurityCameraSettingsModel = null; // TODO
																						// initialise
																						// it
		DigitalSecurityCameraStillImageModel myDigitalSecurityCameraStillImageModel = null; // TODO
																							// initialise
																							// it
		DigitalSecurityCameraMotionImageModel myDigitalSecurityCameraMotionImageModel = null; // TODO
																								// initialise
																								// it

		// Icon Lists

		List iconsList = new LinkedList();

		iconsList.add(new DeviceIcon("image/png", // MimeType
				48, // Width
				48, // Height
				0, // ??
				16, // Depth
				"/icon/Webcam.png", // URL
				DigitalSecurityCamera.class.getClassLoader()));

		icons = (UPnPIcon[]) iconsList.toArray(new UPnPIcon[] {});

		// Service List

		List servicesList = new LinkedList();

		/*
		 * SCPDURL=URL to service description controlURL=URL for control
		 * eventSubURL=URL for eventing
		 */
		servicesList.add(new DigitalSecurityCameraSettings(this,
				"urn:upnp-org:serviceId:DigitalSecurityCameraSettings:1",
				"urn:schemas-upnp-org:service:DigitalSecurityCameraSettings:1",
				"1", myDigitalSecurityCameraSettingsModel));

		/*
		 * SCPDURL=URL to service description controlURL=URL for control
		 * eventSubURL=URL for eventing
		 */
		servicesList
				.add(new DigitalSecurityCameraStillImage(
						this,
						"urn:upnp-org:serviceId:DigitalSecurityCameraStillImage:1",
						"urn:schemas-upnp-org:service:DigitalSecurityCameraStillImage:1",
						"1", myDigitalSecurityCameraStillImageModel));

		/*
		 * SCPDURL=URL to service description controlURL=URL for control
		 * eventSubURL=URL for eventing
		 */
		servicesList
				.add(new DigitalSecurityCameraMotionImage(
						this,
						"urn:upnp-org:serviceId:DigitalSecurityCameraMotionImage:1",
						"urn:schemas-upnp-org:service:DigitalSecurityCameraMotionImage:1",
						"1", myDigitalSecurityCameraMotionImageModel));

		services = (UPnPService[]) servicesList.toArray(new UPnPService[] {});

		// Embedded Device List

		// children=new LinkedList();

	}

	@Override
	protected void setupDeviceProperties() {
		dictionary.put(UPnPDevice.TYPE,
				"urn:schemas-upnp-org:device:DigitalSecurityCamera:1");
		dictionary.put(UPnPDevice.FRIENDLY_NAME,
				"Generated Digital Security Camera UPnP Device");
		dictionary.put(UPnPDevice.MANUFACTURER, "Didier Donsez (Felix team)");
		dictionary.put(UPnPDevice.MANUFACTURER_URL,
				"http://www.apache.org/~donsez");
		dictionary.put(UPnPDevice.MODEL_DESCRIPTION,
				"Generated Digital Security Camera UPnP Device");
		dictionary.put(UPnPDevice.MODEL_NAME, "Digital Security Camera");
		dictionary.put(UPnPDevice.MODEL_NUMBER, "123");
		dictionary
				.put(UPnPDevice.MODEL_URL,
						"http://www.apache.org/~donsez/dev/osgi/upnp.devicegen/readme.html");
		dictionary.put(UPnPDevice.SERIAL_NUMBER, "123456789");
		dictionary.put(UPnPDevice.UDN, getUDN());
		dictionary.put(UPnPDevice.ID, dictionary.get(UPnPDevice.UDN));
		dictionary.put(UPnPDevice.UPC, "upc:adele-securitycamera");
		dictionary
				.put(UPnPDevice.PRESENTATION_URL,
						"http://www.apache.org/~donsez/dev/osgi/upnp.devicegen/readme.html");

		if (parent != null) {
			dictionary.put(UPnPDevice.PARENT_UDN, parent.getUDN());
		}

		if (children != null && children.size() != 0) {
			String[] childrenUDN = new String[children.size()];
			Iterator iter = children.iterator();
			for (int i = 0; iter.hasNext(); i++) {
				childrenUDN[i] = ((AbstractUPnPDevice) iter.next()).getUDN();
			}
			dictionary.put(UPnPDevice.CHILDREN_UDN, childrenUDN);
		}

	}
}
