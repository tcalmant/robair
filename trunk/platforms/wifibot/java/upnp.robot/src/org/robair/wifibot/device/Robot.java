/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:20 AM by ${author}
package org.robair.wifibot.device;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.felix.upnp.devicegen.util.AbstractUPnPDevice;
import org.apache.felix.upnp.devicegen.util.DeviceIcon;
import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPIcon;
import org.osgi.service.upnp.UPnPService;
import org.robair.wifibot.impl.ChassisModelImpl;
import org.robair.wifibot.impl.DistanceSensorModelImpl;
import org.robair.wifibot.impl.IMModelImpl;
import org.robair.wifibot.impl.PositionSensorModelImpl;
import org.robair.wifibot.impl.SensorModelImpl;
import org.robair.wifibot.model.ChassisModel;
import org.robair.wifibot.model.DistanceSensorModel;
import org.robair.wifibot.model.IMModel;
import org.robair.wifibot.model.PositionSensorModel;
import org.robair.wifibot.model.SensorModel;
import org.robair.wifibot.service.Chassis;
import org.robair.wifibot.service.DistanceSensor;
import org.robair.wifibot.service.IM;
import org.robair.wifibot.service.PositionSensor;
import org.robair.wifibot.service.Sensor;

import fr.imag.erods.robair.IRobotController;

public class Robot extends AbstractUPnPDevice {

	public Robot(final BundleContext context, final AbstractUPnPDevice parent,
			final IRobotController aRobotController) {
		super(context, parent);

		DEVICE_ID = "uuid:robair-wifibot-1";

		// ServiceModel Declaration List
		final ChassisModel myChassisModel = new ChassisModelImpl(
				aRobotController);
		final IMModel myIMModel = new IMModelImpl();
		final SensorModel myGazSensorModel = new SensorModelImpl();
		final DistanceSensorModel myLidarSensorModel = new DistanceSensorModelImpl();
		final PositionSensorModel myGPSSensorModel = new PositionSensorModelImpl();

		// Icon Lists
		final List<UPnPIcon> iconsList = new LinkedList<UPnPIcon>();

		iconsList.add(new DeviceIcon("image/png", // MimeType
				180, // Width
				157, // Height
				0, // ??
				16, // Depth
				"/icon/wifibot.png", // URL
				Robot.class.getClassLoader()));

		icons = iconsList.toArray(new UPnPIcon[] {});

		// Service List

		final List<UPnPService> servicesList = new LinkedList<UPnPService>();

		/*
		 * SCPDURL=URL to service description controlURL=URL for control
		 * eventSubURL=URL for eventing
		 */
		servicesList
				.add(new Chassis(this, "urn:robair-org:serviceId:Chassis:1",
						"urn:schemas-robair-org:service:Chassis:1", "1",
						myChassisModel));

		/*
		 * SCPDURL=URL to service description controlURL=URL for control
		 * eventSubURL=URL for eventing
		 */
		servicesList.add(new IM(this, "urn:robair-org:serviceId:IM:1",
				"urn:schemas-robair-org:service:IM:1", "1", myIMModel));

		/*
		 * SCPDURL=URL to service description controlURL=URL for control
		 * eventSubURL=URL for eventing
		 */
		servicesList.add(new Sensor(this,
				"urn:robair-org:serviceId:GazSensor:1",
				"urn:schemas-robair-org:service:Sensor:1", "1",
				myGazSensorModel));

		/*
		 * SCPDURL=URL to service description controlURL=URL for control
		 * eventSubURL=URL for eventing
		 */
		servicesList.add(new DistanceSensor(this,
				"urn:robair-org:serviceId:LidarSensor:1",
				"urn:schemas-robair-org:service:DistanceSensor:1", "1",
				myLidarSensorModel));

		/*
		 * SCPDURL=URL to service description controlURL=URL for control
		 * eventSubURL=URL for eventing
		 */
		servicesList.add(new PositionSensor(this,
				"urn:robair-org:serviceId:GPSSensor:1",
				"urn:schemas-robair-org:service:PositionSensor:1", "1",
				myGPSSensorModel));

		services = servicesList.toArray(new UPnPService[] {});

		// Embedded Device List

		// children=new LinkedList();

	}

	@SuppressWarnings("unchecked")
	@Override
	protected void setupDeviceProperties() {
		dictionary
				.put(UPnPDevice.TYPE, "urn:schemas-robair-org:device:Robot:1");
		dictionary.put(UPnPDevice.FRIENDLY_NAME, "Robot UPnP Device");
		dictionary.put(UPnPDevice.MANUFACTURER, "Didier Donsez");
		dictionary.put(UPnPDevice.MANUFACTURER_URL,
				"http://membres-liglab.imag.fr/donsez/");
		dictionary.put(UPnPDevice.MODEL_DESCRIPTION, "Robot UPnP Device");
		dictionary.put(UPnPDevice.MODEL_NAME, "Robot");
		dictionary.put(UPnPDevice.MODEL_NUMBER, "1");
		dictionary.put(UPnPDevice.MODEL_URL,
				"http://air.imag.fr/mediawiki/index.php/RobAIR-Wifibot#UPnP");
		dictionary.put(UPnPDevice.SERIAL_NUMBER, "123456789");
		dictionary.put(UPnPDevice.UDN, getUDN());
		dictionary.put(UPnPDevice.ID, dictionary.get(UPnPDevice.UDN));
		dictionary.put(UPnPDevice.UPC, "upc:robair-wifibot-1");
		dictionary.put(UPnPDevice.PRESENTATION_URL,
				"http://air.imag.fr/mediawiki/index.php/RobAIR-Wifibot");

		if (parent != null) {
			dictionary.put(UPnPDevice.PARENT_UDN, parent.getUDN());
		}

		if (children != null && children.size() != 0) {
			final String[] childrenUDN = new String[children.size()];
			final Iterator<AbstractUPnPDevice> iter = children.iterator();
			for (int i = 0; iter.hasNext(); i++) {
				childrenUDN[i] = iter.next().getUDN();
			}
			dictionary.put(UPnPDevice.CHILDREN_UDN, childrenUDN);
		}

	}
}
