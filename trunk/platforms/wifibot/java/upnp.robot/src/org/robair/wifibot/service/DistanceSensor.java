/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.felix.upnp.devicegen.holder.DateHolder;
import org.apache.felix.upnp.devicegen.holder.FloatHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPAction;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPService;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPStateVariable;
import org.apache.felix.upnp.devicegen.util.UPnPStateVariableDescriptor;
import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPService;
import org.robair.wifibot.model.DistanceSensorModel;

public class DistanceSensor extends AbstractUPnPService {

	private DistanceSensorModel model;

	/**
	 * constructor
	 */
	public DistanceSensor(UPnPDevice upnpDevice, String serviceId,
			String serviceType, String version, DistanceSensorModel model) {
		super(upnpDevice, serviceId, serviceType, version);
		this.model = model;

		stateVariables = new HashMap();

		stateVariables.put("Name", new NameStateVariable(this, model));

		stateVariables.put("Application", new ApplicationStateVariable(this,
				model));

		stateVariables.put("Value", new ValueStateVariable(this, model));

		stateVariables.put("Error", new ErrorStateVariable(this, model));

		stateVariables.put("Unit", new UnitStateVariable(this, model));

		stateVariables
				.put("Timestamp", new TimestampStateVariable(this, model));

		stateVariables.put("HighValueThreshold",
				new HighValueThresholdStateVariable(this, model));

		stateVariables.put("LowValueThreshold",
				new LowValueThresholdStateVariable(this, model));

		actions = new HashMap();

		actions.put("GetName", new GetNameAction(this, model));

		actions.put("GetApplication", new GetApplicationAction(this, model));

		actions.put("GetCurrentValue", new GetCurrentValueAction(this, model));

		actions.put("GetHighValueThreshold", new GetHighValueThresholdAction(
				this, model));

		actions.put("SetHighValueThreshold", new SetHighValueThresholdAction(
				this, model));

		actions.put("GetLowValueThreshold", new GetLowValueThresholdAction(
				this, model));

		actions.put("SetLowValueThreshold", new SetLowValueThresholdAction(
				this, model));

	}

	// UPnPStateVariable classes

	// class NameStateVariable
	public class NameStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "Name";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DistanceSensorModel model;

		public NameStateVariable(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for
					null, // TODO step changed for
					null, // TODO step changed for
					null, // TODO minimum changed for
					null, // TODO maximum changed for
					// sendEventsAttribute
					false, true // TODO required changed for OR
			);

			this.model = model;

		}

		// TODO

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}

		/**
		 * invoked for the first notification just after a subscription
		 * 
		 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
		 */
		public Object getValue() {
			return null;
		}
	};

	// class ApplicationStateVariable
	public class ApplicationStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "Application";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DistanceSensorModel model;

		public ApplicationStateVariable(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for
					null, // TODO step changed for
					null, // TODO step changed for
					null, // TODO minimum changed for
					null, // TODO maximum changed for
					// sendEventsAttribute
					false, true // TODO required changed for OR
			);

			this.model = model;

		}

		// TODO

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}

		/**
		 * invoked for the first notification just after a subscription
		 * 
		 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
		 */
		public Object getValue() {
			return null;
		}
	};

	// class ValueStateVariable
	public class ValueStateVariable extends AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "Value";
		public final static String DATATYPE = "float";

		// HERE specific state variable members
		private DistanceSensorModel model;

		public ValueStateVariable(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for
					null, // TODO step changed for
					null, // TODO step changed for
					null, // TODO minimum changed for
					null, // TODO maximum changed for
					// sendEventsAttribute
					true, true // TODO required changed for OR
			);

			this.model = model;

		}

		// TODO

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}

		/**
		 * invoked for the first notification just after a subscription
		 * 
		 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
		 */
		public Object getValue() {

			return model.getValueStateVariableValue();

		}
	};

	// class ErrorStateVariable
	public class ErrorStateVariable extends AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "Error";
		public final static String DATATYPE = "float";

		// HERE specific state variable members
		private DistanceSensorModel model;

		public ErrorStateVariable(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for
					null, // TODO step changed for
					null, // TODO step changed for
					null, // TODO minimum changed for
					null, // TODO maximum changed for
					// sendEventsAttribute
					true, true // TODO required changed for OR
			);

			this.model = model;

		}

		// TODO

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}

		/**
		 * invoked for the first notification just after a subscription
		 * 
		 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
		 */
		public Object getValue() {

			return model.getErrorStateVariableValue();

		}
	};

	// class UnitStateVariable
	public class UnitStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "Unit";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DistanceSensorModel model;

		public UnitStateVariable(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for
					null, // TODO step changed for
					null, // TODO step changed for
					null, // TODO minimum changed for
					null, // TODO maximum changed for
					// sendEventsAttribute
					false, true // TODO required changed for OR
			);

			this.model = model;

			/*
			 * List allowedValueList=new LinkedList();
			 * 
			 * allowedValueList.add(UPnPDataTypeUtil.instanciateObject("string","m"
			 * ));
			 * 
			 * allowedValueList.add(UPnPDataTypeUtil.instanciateObject("string","kg"
			 * ));
			 * 
			 * allowedValueList.add(UPnPDataTypeUtil.instanciateObject("string","A"
			 * ));
			 * 
			 * allowedValueList.add(UPnPDataTypeUtil.instanciateObject("string","K"
			 * ));
			 * 
			 * allowedValueList.add(UPnPDataTypeUtil.instanciateObject("string","cd"
			 * ));
			 * 
			 * allowedValueList.add(UPnPDataTypeUtil.instanciateObject("string",
			 * "mol"));
			 * 
			 * allowedValueList.add(UPnPDataTypeUtil.instanciateObject("string","s"
			 * ));
			 * 
			 * this.setallowedValueList(allowedValueList);
			 */

		}

		// TODO

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}

		/**
		 * invoked for the first notification just after a subscription
		 * 
		 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
		 */
		public Object getValue() {
			return null;
		}
	};

	// class TimestampStateVariable
	public class TimestampStateVariable extends AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "Timestamp";
		public final static String DATATYPE = "date";

		// HERE specific state variable members
		private DistanceSensorModel model;

		public TimestampStateVariable(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for
					null, // TODO step changed for
					null, // TODO step changed for
					null, // TODO minimum changed for
					null, // TODO maximum changed for
					// sendEventsAttribute
					true, true // TODO required changed for OR
			);

			this.model = model;

		}

		// TODO

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}

		/**
		 * invoked for the first notification just after a subscription
		 * 
		 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
		 */
		public Object getValue() {

			return model.getTimestampStateVariableValue();

		}
	};

	// class HighValueThresholdStateVariable
	public class HighValueThresholdStateVariable extends
			AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "HighValueThreshold";
		public final static String DATATYPE = "float";

		// HERE specific state variable members
		private DistanceSensorModel model;

		public HighValueThresholdStateVariable(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for
					null, // TODO step changed for
					null, // TODO step changed for
					null, // TODO minimum changed for
					null, // TODO maximum changed for
					// sendEventsAttribute
					true, true // TODO required changed for OR
			);

			this.model = model;

		}

		// TODO

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}

		/**
		 * invoked for the first notification just after a subscription
		 * 
		 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
		 */
		public Object getValue() {

			return model.getHighValueThresholdStateVariableValue();

		}
	};

	// class LowValueThresholdStateVariable
	public class LowValueThresholdStateVariable extends
			AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "LowValueThreshold";
		public final static String DATATYPE = "float";

		// HERE specific state variable members
		private DistanceSensorModel model;

		public LowValueThresholdStateVariable(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for
					null, // TODO step changed for
					null, // TODO step changed for
					null, // TODO minimum changed for
					null, // TODO maximum changed for
					// sendEventsAttribute
					true, true // TODO required changed for OR
			);

			this.model = model;

		}

		// TODO

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}

		/**
		 * invoked for the first notification just after a subscription
		 * 
		 * @see it.cnr.isti.niche.osgi.upnp.util.UPnPStateVariableDescriptor#getValue()
		 */
		public Object getValue() {

			return model.getLowValueThresholdStateVariableValue();

		}
	};

	// UPnPAction classes

	public class GetNameAction extends AbstractUPnPAction {

		DistanceSensorModel model;

		// HERE specific action members

		public GetNameAction(UPnPService upnpService, DistanceSensorModel model) {
			super(upnpService, "GetName", "");
			this.model = model;

			addOutArg("CurrentName", upnpService.getStateVariable("Name"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder currentName = new StringHolder();

			// invoke model

			model.getName(currentName);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("CurrentName", currentName.getObject());
			// java.lang.String
			return _result.isEmpty() ? null : _result;
		}

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}
	};

	public class GetApplicationAction extends AbstractUPnPAction {

		DistanceSensorModel model;

		// HERE specific action members

		public GetApplicationAction(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, "GetApplication", "");
			this.model = model;

			addOutArg("CurrentApplication",
					upnpService.getStateVariable("Application"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder currentApplication = new StringHolder();

			// invoke model

			model.getApplication(currentApplication);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("CurrentApplication", currentApplication.getObject());
			// java.lang.String
			return _result.isEmpty() ? null : _result;
		}

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}
	};

	public class GetCurrentValueAction extends AbstractUPnPAction {

		DistanceSensorModel model;

		// HERE specific action members

		public GetCurrentValueAction(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, "GetCurrentValue", "");
			this.model = model;

			addOutArg("CurrentValue", upnpService.getStateVariable("Value"));

			addOutArg("CurrentError", upnpService.getStateVariable("Error"));

			addOutArg("Unit", upnpService.getStateVariable("Unit"));

			addOutArg("Timestamp", upnpService.getStateVariable("Timestamp"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			FloatHolder currentValue = new FloatHolder();
			FloatHolder currentError = new FloatHolder();
			StringHolder unit = new StringHolder();
			DateHolder timestamp = new DateHolder();

			// invoke model

			model.getCurrentValue(currentValue,

			currentError,

			unit,

			timestamp);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("CurrentValue", currentValue.getObject());
			// java.lang.Float
			_result.put("CurrentError", currentError.getObject());
			// java.lang.Float
			_result.put("Unit", unit.getObject());
			// java.lang.String
			_result.put("Timestamp", timestamp.getObject());
			// java.util.Date
			return _result.isEmpty() ? null : _result;
		}

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}
	};

	public class GetHighValueThresholdAction extends AbstractUPnPAction {

		DistanceSensorModel model;

		// HERE specific action members

		public GetHighValueThresholdAction(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, "GetHighValueThreshold", "");
			this.model = model;

			addOutArg("CurrentHighValueThreshold",
					upnpService.getStateVariable("HighValueThreshold"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			FloatHolder currentHighValueThreshold = new FloatHolder();

			// invoke model

			model.getHighValueThreshold(currentHighValueThreshold);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("CurrentHighValueThreshold",
					currentHighValueThreshold.getObject());
			// java.lang.Float
			return _result.isEmpty() ? null : _result;
		}

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}
	};

	public class SetHighValueThresholdAction extends AbstractUPnPAction {

		DistanceSensorModel model;

		// HERE specific action members

		public SetHighValueThresholdAction(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, "SetHighValueThreshold", "");
			this.model = model;

			addInArg("NewHighValueThreshold",
					upnpService.getStateVariable("HighValueThreshold"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.Float newHighValueThreshold = (java.lang.Float) _args
					.get("NewHighValueThreshold");

			// invoke model

			model.setHighValueThreshold(FloatHolder
					.toValue(newHighValueThreshold)

			);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			return _result.isEmpty() ? null : _result;
		}

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}
	};

	public class GetLowValueThresholdAction extends AbstractUPnPAction {

		DistanceSensorModel model;

		// HERE specific action members

		public GetLowValueThresholdAction(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, "GetLowValueThreshold", "");
			this.model = model;

			addOutArg("CurrentLowValueThreshold",
					upnpService.getStateVariable("LowValueThreshold"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			FloatHolder currentLowValueThreshold = new FloatHolder();

			// invoke model

			model.getLowValueThreshold(currentLowValueThreshold);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("CurrentLowValueThreshold",
					currentLowValueThreshold.getObject());
			// java.lang.Float
			return _result.isEmpty() ? null : _result;
		}

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}
	};

	public class SetLowValueThresholdAction extends AbstractUPnPAction {

		DistanceSensorModel model;

		// HERE specific action members

		public SetLowValueThresholdAction(UPnPService upnpService,
				DistanceSensorModel model) {
			super(upnpService, "SetLowValueThreshold", "");
			this.model = model;

			addInArg("NewHighValueThreshold",
					upnpService.getStateVariable("LowValueThreshold"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.Float newHighValueThreshold = (java.lang.Float) _args
					.get("NewHighValueThreshold");

			// invoke model

			model.setLowValueThreshold(FloatHolder
					.toValue(newHighValueThreshold)

			);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			return _result.isEmpty() ? null : _result;
		}

		@Override
		public void start(BundleContext bundleContext) throws Exception {
			// TODO
		}

		@Override
		public void stop(BundleContext bundleContext) throws Exception {
			// TODO
		}
	};

}
