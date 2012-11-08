/*
 * __BANNER__
 **/
package fr.imag.adele.bundle.upnp.position.impl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import org.dinopolis.gpstool.gpsinput.GPSDataProcessor;
import org.dinopolis.gpstool.gpsinput.GPSDevice;
import org.dinopolis.gpstool.gpsinput.GPSPosition;
import org.dinopolis.gpstool.gpsinput.SatelliteInfo;
import org.osgi.framework.BundleContext;

import fr.imag.adele.bundle.configuration.Configuration;

public class SerialGPSPositionSensorModelImpl extends CommonPositionSensorModelImpl implements PropertyChangeListener {

	private GPSDataProcessor gps_data_processor;
	private GPSDevice gps_device;
	private Properties props;

	public SerialGPSPositionSensorModelImpl() {
	}

	public SerialGPSPositionSensorModelImpl(Properties props) {
		this.props=props;
	}

	private void startProcessor() throws Exception {
			Class clazz;

			clazz= Class.forName(props.getProperty("gpstool.gpsdataprocessor"));
			gps_data_processor = (GPSDataProcessor)clazz.newInstance();

			clazz= Class.forName(props.getProperty("gpstool.gpsdevice"));
			gps_device = (GPSDevice)clazz.newInstance();

			Hashtable environment = fr.imag.adele.bundle.configuration.Configuration.getHashtable(props,"gpstool.initproperties");

			gps_device.init(environment);
			gps_data_processor.setGPSDevice(gps_device);

			gps_data_processor.open();

			gps_data_processor.addGPSDataChangeListener(GPSDataProcessor.LOCATION,this);
			gps_data_processor.addGPSDataChangeListener(GPSDataProcessor.HEADING,this);
			gps_data_processor.addGPSDataChangeListener(GPSDataProcessor.ALTITUDE,this);
			gps_data_processor.addGPSDataChangeListener(GPSDataProcessor.SPEED,this);
			gps_data_processor.addGPSDataChangeListener(GPSDataProcessor.NUMBER_SATELLITES,this);
			gps_data_processor.addGPSDataChangeListener(GPSDataProcessor.SATELLITE_INFO,this);

	}

	private void stopProcessor() throws Exception {
		if(gps_data_processor != null) {
			gps_data_processor.close();
			gps_data_processor = null;
		}

		if(gps_device != null){
			gps_device.close();
			gps_device = null;
		}
	}
		
	// -------------------------------------------------------------------------

	public void propertyChange(PropertyChangeEvent event)
	{
		Object value = event.getNewValue();
		String name = event.getPropertyName();
		long currentTimestamp=System.currentTimeMillis();

		if(name.equals(GPSDataProcessor.SATELLITE_INFO)) {
			SatelliteInfo[] infos = (SatelliteInfo[])value;
			SatelliteInfo info;
			for(int count=0; count < infos.length; count++)
			{
				info = infos[count];
				trace("sat "+info.getPRN()+": elev="+info.getElevation()
				      + " azim="+info.getAzimuth()+" dB="+info.getSNR());
			}
		} else 	if(name.equals(GPSDataProcessor.LOCATION)) {
			// set current GPS Position
			//if(gpsposition==null) gpsposition=(GPSPosition)event.getNewValue();
			GPSPosition gpsposition=(GPSPosition)value;

			double _latitude=gpsposition.getLatitude();
			if(latitude!=Double.NaN) {
				oldLatitude=latitude;
				latitude=(float)((_latitude*Math.PI)/180);
			}

			double _longitude=gpsposition.getLongitude();
			if(longitude!=Double.NaN) {
				oldLongitude=longitude;
				longitude=(float) ((_longitude*Math.PI)/180);
			}

			double _altitude=gpsposition.getAltitude();
			if(altitude!=Double.NaN) {
				oldAltitude=altitude;
				altitude=(float) _altitude;
			}

			timestamp=currentTimestamp;

		} else if(name.equals(GPSDataProcessor.ALTITUDE)) {
			float _altitude=((Float)value).floatValue();
			if(_altitude!=Float.NaN){
				oldAltitude=altitude;
				altitude=_altitude;
				timestamp=currentTimestamp;
			}
		} else if(name.equals(GPSDataProcessor.HEADING)) {
			// set current Course
			float _track=((Float)value).floatValue();
			oldTrack=track;
			if(_track==-1.0){
				track=Float.NaN;
			} else {
				track=(float)((_track*Math.PI)/180);
				timestamp=currentTimestamp;
			}
			
		} else if(name.equals(GPSDataProcessor.SPEED)) {
			// set current Speed
			float _speed=((Float)value).floatValue();
			if(speed!=Float.NaN){
				oldSpeed=speed;
				speed=_speed;
				timestamp=currentTimestamp;
			}
		}
		
		notifyChanges();

		// add extra info
		// location.addExtraInfo("application/X-java-location-nmea", ???);

		trace(event.getPropertyName()+": "+event.getNewValue());
		
	}

	/**
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		if(props==null) {
			InputStream inputStream=Configuration.getPropertiesInputStream(bundleContext);
			props=Configuration.loadProperties(inputStream);
			inputStream.close();
		}
		setName("GPS");
		setName("sattelite");
		startProcessor();
	}

	/**
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		stopProcessor();		
	}	
}



