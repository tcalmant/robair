
/*
__BANNER__
*/
// this file was generated at 1-June-2005 03:50 PM by ${author}
package fr.imag.adele.bundle.upnp.position.service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.osgi.framework.*;
import org.osgi.service.upnp.*;
import fr.imag.adele.util.upnp.*;
import fr.imag.adele.util.upnp.holder.*;

import it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor;

import fr.imag.adele.bundle.upnp.position.*;

	

public class PositionSensor extends AbstractUPnPService {
	
		
	private PositionSensorModel model;	
		
	/**
	 * constructor
	 */
	public PositionSensor(
		UPnPDevice upnpDevice,
		String serviceId,
		String serviceType,
		String version,
		PositionSensorModel model
	){
		super(	
			upnpDevice,
			serviceId,
			serviceType,
			version
		);
		this.model=model;
	
		
	stateVariables=new HashMap();
	

	
	stateVariables.put(
		"CurrentLatitude",
		new CurrentLatitudeStateVariable(this,model)
	);


	
	stateVariables.put(
		"CurrentLongitude",
		new CurrentLongitudeStateVariable(this,model)
	);


	
	stateVariables.put(
		"CurrentAltitude",
		new CurrentAltitudeStateVariable(this,model)
	);


	
	stateVariables.put(
		"CurrentSpeed",
		new CurrentSpeedStateVariable(this,model)
	);


	
	stateVariables.put(
		"CurrentTrack",
		new CurrentTrackStateVariable(this,model)
	);


	
	stateVariables.put(
		"Timestamp",
		new TimestampStateVariable(this,model)
	);


	
	stateVariables.put(
		"Name",
		new NameStateVariable(this,model)
	);

	actions=new HashMap();
	


	actions.put(
		"GetCurrentPosition",
		new GetCurrentPositionAction(this,model)
	);



	actions.put(
		"GetName",
		new GetNameAction(this,model)
	);



	actions.put(
		"SetName",
		new SetNameAction(this,model)
	);
	
	}

	// UPnPStateVariable classes
	
	

// class CurrentLatitudeStateVariable
public class CurrentLatitudeStateVariable
  extends AbstractUPnPStateVariable
			
	  implements UPnPStateVariableDescriptor{

	public final static String NAME="CurrentLatitude";
	public final static String DATATYPE="float";
	
	// HERE specific state variable members
	private PositionSensorModel model;
	
	public CurrentLatitudeStateVariable(
		UPnPService upnpService,
		PositionSensorModel model
	){	
		super(
					upnpService,
					NAME,
					DATATYPE,
					null, // TODO defaultValue changed for 
					null, // TODO step changed for 
					null, // TODO step changed for 
					null, // TODO minimum changed for 
					null, // TODO maximum changed for true, // TODO sendEvent changed for yes OR 
					true  // TODO required changed for  OR 
		);
		
		this.model=model;

		
	}
	
	// TODO
	
	public void start(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
			
	
	/**
	 * invoked for the first notification just after a subscription
	 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
	 */
	public Object getValue(){
		return model.getCurrentLatitudeStateVariableValue();
	}
		
	
};


// class CurrentLongitudeStateVariable
public class CurrentLongitudeStateVariable
  extends AbstractUPnPStateVariable
			
	  implements UPnPStateVariableDescriptor{

	public final static String NAME="CurrentLongitude";
	public final static String DATATYPE="float";
	
	// HERE specific state variable members
	private PositionSensorModel model;
	
	public CurrentLongitudeStateVariable(
		UPnPService upnpService,
		PositionSensorModel model
	){	
		super(
					upnpService,
					NAME,
					DATATYPE,
					null, // TODO defaultValue changed for 
					null, // TODO step changed for 
					null, // TODO step changed for 
					null, // TODO minimum changed for 
					null, // TODO maximum changed for true, // TODO sendEvent changed for yes OR 
					true  // TODO required changed for  OR 
		);
		
		this.model=model;

		
	}
	
	// TODO
	
	public void start(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
			
	
	/**
	 * invoked for the first notification just after a subscription
	 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
	 */
	public Object getValue(){
		return model.getCurrentLongitudeStateVariableValue();
	}
		
	
};


// class CurrentAltitudeStateVariable
public class CurrentAltitudeStateVariable
  extends AbstractUPnPStateVariable
			
	  implements UPnPStateVariableDescriptor{

	public final static String NAME="CurrentAltitude";
	public final static String DATATYPE="float";
	
	// HERE specific state variable members
	private PositionSensorModel model;
	
	public CurrentAltitudeStateVariable(
		UPnPService upnpService,
		PositionSensorModel model
	){	
		super(
					upnpService,
					NAME,
					DATATYPE,
					null, // TODO defaultValue changed for 
					null, // TODO step changed for 
					null, // TODO step changed for 
					null, // TODO minimum changed for 
					null, // TODO maximum changed for true, // TODO sendEvent changed for yes OR 
					true  // TODO required changed for  OR 
		);
		
		this.model=model;

		
	}
	
	// TODO
	
	public void start(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
			
	
	/**
	 * invoked for the first notification just after a subscription
	 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
	 */
	public Object getValue(){
		return model.getCurrentAltitudeStateVariableValue();
	}
		
	
};


// class CurrentSpeedStateVariable
public class CurrentSpeedStateVariable
  extends AbstractUPnPStateVariable
			
	  implements UPnPStateVariableDescriptor{

	public final static String NAME="CurrentSpeed";
	public final static String DATATYPE="float";
	
	// HERE specific state variable members
	private PositionSensorModel model;
	
	public CurrentSpeedStateVariable(
		UPnPService upnpService,
		PositionSensorModel model
	){	
		super(
					upnpService,
					NAME,
					DATATYPE,
					null, // TODO defaultValue changed for 
					null, // TODO step changed for 
					null, // TODO step changed for 
					null, // TODO minimum changed for 
					null, // TODO maximum changed for true, // TODO sendEvent changed for yes OR 
					true  // TODO required changed for  OR 
		);
		
		this.model=model;

		
	}
	
	// TODO
	
	public void start(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
			
	
	/**
	 * invoked for the first notification just after a subscription
	 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
	 */
	public Object getValue(){
		return model.getCurrentSpeedStateVariableValue();
	}
		
	
};


// class CurrentTrackStateVariable
public class CurrentTrackStateVariable
  extends AbstractUPnPStateVariable
			
	  implements UPnPStateVariableDescriptor{

	public final static String NAME="CurrentTrack";
	public final static String DATATYPE="float";
	
	// HERE specific state variable members
	private PositionSensorModel model;
	
	public CurrentTrackStateVariable(
		UPnPService upnpService,
		PositionSensorModel model
	){	
		super(
					upnpService,
					NAME,
					DATATYPE,
					null, // TODO defaultValue changed for 
					null, // TODO step changed for 
					null, // TODO step changed for 
					null, // TODO minimum changed for 
					null, // TODO maximum changed for true, // TODO sendEvent changed for yes OR 
					true  // TODO required changed for  OR 
		);
		
		this.model=model;

		
	}
	
	// TODO
	
	public void start(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
			
	
	/**
	 * invoked for the first notification just after a subscription
	 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
	 */
	public Object getValue(){
		return model.getCurrentTrackStateVariableValue();
	}
		
	
};


// class TimestampStateVariable
public class TimestampStateVariable
  extends AbstractUPnPStateVariable
			
	  implements UPnPStateVariableDescriptor{

	public final static String NAME="Timestamp";
	public final static String DATATYPE="dateTime";
	
	// HERE specific state variable members
	private PositionSensorModel model;
	
	public TimestampStateVariable(
		UPnPService upnpService,
		PositionSensorModel model
	){	
		super(
					upnpService,
					NAME,
					DATATYPE,
					null, // TODO defaultValue changed for 
					null, // TODO step changed for 
					null, // TODO step changed for 
					null, // TODO minimum changed for 
					null, // TODO maximum changed for true, // TODO sendEvent changed for yes OR 
					true  // TODO required changed for  OR 
		);
		
		this.model=model;

		
	}
	
	// TODO
	
	public void start(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
			
	
	/**
	 * invoked for the first notification just after a subscription
	 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
	 */
	public Object getValue(){
		return model.getTimestampStateVariableValue();
	}
		
	
};


// class NameStateVariable
public class NameStateVariable
  extends AbstractUPnPStateVariable
			
	{

	public final static String NAME="Name";
	public final static String DATATYPE="string";
	
	// HERE specific state variable members
	private PositionSensorModel model;
	
	public NameStateVariable(
		UPnPService upnpService,
		PositionSensorModel model
	){	
		super(
					upnpService,
					NAME,
					DATATYPE,
					null, // TODO defaultValue changed for 
					null, // TODO step changed for 
					null, // TODO step changed for 
					null, // TODO minimum changed for 
					null, // TODO maximum changed for false, // TODO sendEvent changed for no OR 
					true  // TODO required changed for  OR 
		);
		
		this.model=model;

		
	}
	
	// TODO
	
	public void start(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
			
	
	
};
	

	// UPnPAction classes
	
	

public class GetCurrentPositionAction extends AbstractUPnPAction {

	PositionSensorModel model;
	
	// HERE specific action members
	
	public GetCurrentPositionAction(
	    UPnPService upnpService,
		PositionSensorModel model
	){
		super(
			upnpService,
			"GetCurrentPosition",
			""
		);
		this.model=model;
		
			addOutArg(
				"CurrentLatitude",
				upnpService.getStateVariable("CurrentLatitude")
			);
		
			addOutArg(
				"CurrentLongitude",
				upnpService.getStateVariable("CurrentLongitude")
			);
		
			addOutArg(
				"CurrentAltitude",
				upnpService.getStateVariable("CurrentAltitude")
			);
		
			addOutArg(
				"CurrentSpeed",
				upnpService.getStateVariable("CurrentSpeed")
			);
		
			addOutArg(
				"CurrentTrack",
				upnpService.getStateVariable("CurrentTrack")
			);
		
			addOutArg(
				"Timestamp",
				upnpService.getStateVariable("Timestamp")
			);
		
	}

	/**
	 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
	 */
	public Dictionary invoke(Dictionary args) throws Exception {

	FloatHolder currentLatitude = new FloatHolder();
		FloatHolder currentLongitude = new FloatHolder();
		FloatHolder currentAltitude = new FloatHolder();
		FloatHolder currentSpeed = new FloatHolder();
		FloatHolder currentTrack = new FloatHolder();
		DateHolder timestamp = new DateHolder();
		

		// invoke model
		
		 model.getCurrentPosition(
			currentLatitude,

currentLongitude,

currentAltitude,

currentSpeed,

currentTrack,

timestamp,


		 );
		
		
		Hashtable result = new Hashtable();
		
			result.put("CurrentLatitude",currentLatitude.getValue());
			// java.lang.Float
			result.put("CurrentLongitude",currentLongitude.getValue());
			// java.lang.Float
			result.put("CurrentAltitude",currentAltitude.getValue());
			// java.lang.Float
			result.put("CurrentSpeed",currentSpeed.getValue());
			// java.lang.Float
			result.put("CurrentTrack",currentTrack.getValue());
			// java.lang.Float
			result.put("Timestamp",timestamp.getValue());
			// java.util.Date
		return result.isEmpty?null:result; 			// 
	}


	public void start(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO
	}
};


public class GetNameAction extends AbstractUPnPAction {

	PositionSensorModel model;
	
	// HERE specific action members
	
	public GetNameAction(
	    UPnPService upnpService,
		PositionSensorModel model
	){
		super(
			upnpService,
			"GetName",
			""
		);
		this.model=model;
		
			addOutArg(
				"CurrentName",
				upnpService.getStateVariable("Name")
			);
		
	}

	/**
	 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
	 */
	public Dictionary invoke(Dictionary args) throws Exception {

	StringHolder currentName = new StringHolder();
		

		// invoke model
		
		 model.getName(
			currentName,


		 );
		
		
		Hashtable result = new Hashtable();
		
			result.put("CurrentName",currentName.getValue());
			// java.lang.String
		return result.isEmpty?null:result; 			// 
	}


	public void start(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO
	}
};


public class SetNameAction extends AbstractUPnPAction {

	PositionSensorModel model;
	
	// HERE specific action members
	
	public SetNameAction(
	    UPnPService upnpService,
		PositionSensorModel model
	){
		super(
			upnpService,
			"SetName",
			""
		);
		this.model=model;
		
			addInArg(
				"NewName",
				upnpService.getStateVariable("Name")
			);
		
	}

	/**
	 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
	 */
	public Dictionary invoke(Dictionary args) throws Exception {

	java.lang.String newName = (java.lang.String) args.get("NewName");
		

		// invoke model
		
		 model.setName(
			java.lang.String.toValue(
			newName)
		,


		 );
		
		
		Hashtable result = new Hashtable();
		
		return result.isEmpty?null:result; 			// 
	}


	public void start(BundleContext bundleContext) throws Exception {
		// TODO
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO
	}
};
	
}
