/*
 * __BANNER__
 */
// this file was generated at 1-June-2005 03:50 PM by ${author}
package fr.imag.adele.bundle.upnp.position.impl;

import org.osgi.framework.BundleContext;

public class EmulatedPositionSensorModelImpl extends CommonPositionSensorModelImpl implements Runnable {


	private boolean end=false;
	/**
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while(!end){
			update();
			notifyChanges();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// nothing
			}
		}
	}

	/**
	 * 
	 */
	private void update() {

		oldLatitude=latitude;
		oldLongitude=longitude;
		oldAltitude=altitude;
		oldSpeed=speed;
		oldTimestamp=timestamp;

		latitude += 0.00001;
		longitude += 0.00001;
		altitude += 0.1;
		speed = (float) 0.001;
		timestamp = System.currentTimeMillis();
		
	}

	/**
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		setName("emulation");
		setName("sattelite");
		(new Thread(this)).start();
	}

	/**
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		end=true;
	}

}