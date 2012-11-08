
/*
__BANNER__
*/
// this file was generated at 1-June-2005 03:50 PM by ${author}
package fr.imag.adele.bundle.upnp.position.device;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPIcon;
import org.osgi.service.upnp.UPnPService;

import fr.imag.adele.bundle.upnp.position.impl.CommonPositionSensorModelImpl;
import fr.imag.adele.bundle.upnp.position.impl.SerialGPSPositionSensorModelImpl;
import fr.imag.adele.bundle.upnp.position.service.PositionSensor;
import fr.imag.adele.util.upnp.AbstractUPnPDevice;
import fr.imag.adele.util.upnp.DeviceIcon;


public class PositionDevice extends AbstractUPnPDevice {

	private CommonPositionSensorModelImpl myPositionSensorModel;
	
	public PositionDevice(BundleContext context, AbstractUPnPDevice parent) {
		super(context,parent);

		DEVICE_ID="uuid:adele-position";

		myPositionSensorModel=new SerialGPSPositionSensorModelImpl();
		
		// Icon Lists
		
		List iconsList=new LinkedList();
	
		iconsList.add(
				new DeviceIcon(
					"image/png", // MimeType
					49, //Width
					50, // Height
					0, // ??
					16, // Depth
					"/icon/compass.png", // URL
					PositionDevice.class.getClassLoader()
				)
		);

		icons=(UPnPIcon[])iconsList.toArray(new UPnPIcon[]{});


		// Service List
		
		List servicesList=new LinkedList();
	
	
		/*
				SCPDURL=URL to service description
				controlURL=URL for control
				eventSubURL=URL for eventing
		*/
		servicesList.add(
				new PositionSensor(
						this,
						"urn:adele-imag-fr:serviceId:PositionSensor:1",
						"urn:adele-imag-fr:service:PositionSensor:1",
						"1",
						myPositionSensorModel
				)
			);				

		services=(UPnPService[])servicesList.toArray(new UPnPService[]{});


		// Embedded Device List
			
		//children=new LinkedList();
		
	
	}
	
	/**
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		myPositionSensorModel.setNotifier(notifiers[0]);
		myPositionSensorModel.start(bundleContext);
		
	}

	/**
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		myPositionSensorModel.stop(bundleContext);
		super.stop(bundleContext);
	}

	
	
	protected void setupDeviceProperties(){	
		dictionary.put(UPnPDevice.TYPE,"urn:schemas-adele-imag-fr:device:PositionDevice:1");
		dictionary.put(UPnPDevice.FRIENDLY_NAME,"Generated Position UPnP Device");
		dictionary.put(UPnPDevice.MANUFACTURER,"Didier Donsez");
		dictionary.put(UPnPDevice.MANUFACTURER_URL,"http://www-adele.imag.fr/users/Didier.Donsez");
		dictionary.put(UPnPDevice.MODEL_DESCRIPTION,"Generated Position UPnP Device");
		dictionary.put(UPnPDevice.MODEL_NAME,"Position Device");
		dictionary.put(UPnPDevice.MODEL_NUMBER,"123");
		dictionary.put(UPnPDevice.MODEL_URL,"http://www-adele.imag.fr/users/Didier.Donsez/dev/osgi/upnpposition/readme.html");
		dictionary.put(UPnPDevice.SERIAL_NUMBER,"123456789");
		dictionary.put(UPnPDevice.UDN,getUDN());
		dictionary.put(UPnPDevice.ID,dictionary.get(UPnPDevice.UDN));
		dictionary.put(UPnPDevice.UPC,"upc:adele-position");
		dictionary.put(UPnPDevice.PRESENTATION_URL,"http://www-adele.imag.fr/users/Didier.Donsez/dev/osgi/upnpposition/readme.html");		

		if(parent!=null) {
			dictionary.put(UPnPDevice.PARENT_UDN,parent.getUDN());
		}
		
		if(children!=null && children.size()!=0){
			String[] childrenUDN=new String[children.size()];
			Iterator iter=children.iterator();
			for(int i=0;iter.hasNext();i++){
				childrenUDN[i]=((AbstractUPnPDevice)iter.next()).getUDN();
			}
			dictionary.put(UPnPDevice.CHILDREN_UDN,childrenUDN);
		}
		
	}
}
