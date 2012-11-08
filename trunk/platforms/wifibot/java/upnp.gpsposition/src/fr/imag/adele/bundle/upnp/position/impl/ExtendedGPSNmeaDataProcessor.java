package fr.imag.adele.bundle.upnp.position.impl;

import java.util.Vector;

import org.dinopolis.gpstool.gpsinput.GPSNmeaDataProcessor;
import org.dinopolis.gpstool.gpsinput.NMEA0183Sentence;
import org.dinopolis.util.Debug;

//----------------------------------------------------------------------
/**
 * This class extends org.dinopolis.gpstool.gpsinput.GPSNmeaDataProcessor
 * to add intepretations of VTG and HDT NMEA sentences
 *
 * @author Didier Donsez (didier.donsez@imag.fr)
 * @version $Revision: 1.0 $
 */

public class ExtendedGPSNmeaDataProcessor extends GPSNmeaDataProcessor
{

	//----------------------------------------------------------------------
	/**
	 * Default constructor.
	 */
	public ExtendedGPSNmeaDataProcessor()
	{
		super();
	}

	//----------------------------------------------------------------------
	/**
	 * Default constructor.
	 *
	 * @param delay_time the time between two NMEA messages are read (may
	 * be used for reading NMEA files slower) in milliseconds.
	 */
	public ExtendedGPSNmeaDataProcessor(int delay_time)
	{
		super(delay_time);
	}


	//----------------------------------------------------------------------
	/**
	 * Processes the different nmea sentences.
	 *
	 * @param sentence a NMEA sentence.
	 */
	protected void processNmeaSentence(NMEA0183Sentence sentence)
	{
		String id = sentence.getSentenceId().toUpperCase();

		if(id.equals("VTG"))
		{
			processVTG(sentence);
			return;
		}

		if(id.equals("HDT"))
		{
			processHDT(sentence);
			return;
		}

		
		super.processNmeaSentence(sentence);
	}




	//----------------------------------------------------------------------
	/**
	 * Processes a VTG nmea sentences and fires the specific events about
	 * the information contained in this sentence (property name
	 * GPSDataProcessor.SPEED).
	 *
	 * @param sentence a NMEA sentence.
	 *
	 * @link http://home.mira.net/~gnb/gps/nmea.html#gpvtg
	 */

	protected void processVTG(NMEA0183Sentence sentence)
	{
		if(Debug.DEBUG)
			Debug.println("gpstool_nmea","VTG detected: "+sentence);
		Vector data_fields = sentence.getDataFields();
		String trueCourse = (String)data_fields.elementAt(0); // True course made good over ground, degrees
		//String magneticCourse = (String)data_fields.elementAt(2); // Magnetic course made good over ground, degrees
		//String groundSpeedKnots = (String)data_fields.elementAt(4); // Ground speed, N=Knots
		String groundSpeedKms = (String)data_fields.elementAt(6); // Ground speed, K=Kilometers per hour

		Float heading = null;
		try
		{
			heading = new Float(trueCourse);
			changeGPSData(HEADING,heading);
		}
		catch(NumberFormatException nfe)
		{
			//nfe.printStackTrace();
		}

		try
		{
			float speed = Float.parseFloat(groundSpeedKms);
			// speed = speed / KM2NAUTIC;
			changeGPSData(SPEED,new Float(speed));
		}
		catch(NumberFormatException nfe)
		{
			//nfe.printStackTrace();
		}
	}

	//----------------------------------------------------------------------
	/**
	 * Processes a HDT nmea sentences and fires the specific events about
	 * the information contained in this sentence (property name
	 * GPSDataProcessor.HEADING). 
	 *
	 * @param sentence a NMEA sentence.
	 *
	 * @link http://home.mira.net/~gnb/gps/nmea.html#gphdt
	 */
	protected void processHDT(NMEA0183Sentence sentence)
	{
		if(Debug.DEBUG)
			Debug.println("gpstool_nmea","HDT detected: "+sentence);
		String heading_str = (String)sentence.getDataFields().elementAt(0);
		Float heading = null;
		try
		{
			heading = new Float(heading_str);
			changeGPSData(HEADING,heading);
		}
		catch(NumberFormatException nfe)
		{
			//nfe.printStackTrace();
		}
	}

}
