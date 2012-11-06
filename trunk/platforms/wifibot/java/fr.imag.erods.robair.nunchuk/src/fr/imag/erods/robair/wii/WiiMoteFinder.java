/**
 * 
 */
package fr.imag.erods.robair.wii;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.Validate;
import org.ow2.jonas.wiimote.IWiimoteFinder;

/**
 * @author Thomas Calmant
 * 
 */
@Component(name = "wiimote-finder-factory")
@Instantiate(name = "wiimote-finder")
public class WiiMoteFinder {

	/** The wiimote finder */
	@Requires
	private IWiimoteFinder pFinder;

	/**
	 * Component invalidated
	 */
	@Invalidate
	public void invalidate() {

		pFinder.stopDiscovery();
		System.out.println("Wiimote finder invalidated");
	}

	/** Component validated */
	@Validate
	public void validate() {

		pFinder.searchWiimotes();
		System.out.println("Wiimote finder validated");
	}
}
