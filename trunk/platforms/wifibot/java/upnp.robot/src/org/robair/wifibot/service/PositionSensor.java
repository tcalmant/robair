/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.felix.upnp.devicegen.holder.FloatHolder;
import org.apache.felix.upnp.devicegen.holder.IntegerHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPAction;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPService;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPStateVariable;
import org.apache.felix.upnp.devicegen.util.UPnPStateVariableDescriptor;
import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPService;
import org.robair.wifibot.model.PositionSensorModel;

public class PositionSensor extends AbstractUPnPService {

	private PositionSensorModel model;

	/**
	 * constructor
	 */
	public PositionSensor(UPnPDevice upnpDevice, String serviceId,
			String serviceType, String version, PositionSensorModel model) {
		super(upnpDevice, serviceId, serviceType, version);
		this.model = model;

		stateVariables = new HashMap();

		stateVariables.put("Name", new NameStateVariable(this, model));

		stateVariables.put("Application", new ApplicationStateVariable(this,
				model));

		stateVariables.put("Angle", new AngleStateVariable(this, model));

		stateVariables
				.put("AngleStep", new AngleStepStateVariable(this, model));

		stateVariables.put("MinDetection", new MinDetectionStateVariable(this,
				model));

		stateVariables.put("MaxDetection", new MaxDetectionStateVariable(this,
				model));

		stateVariables.put("AbsoluteDeltaDetectionThreshold",
				new AbsoluteDeltaDetectionThresholdStateVariable(this, model));

		stateVariables.put("CurrentDistanceArray",
				new CurrentDistanceArrayStateVariable(this, model));

		stateVariables.put("CurrentError", new CurrentErrorStateVariable(this,
				model));

		actions = new HashMap();

		actions.put("GetName", new GetNameAction(this, model));

		actions.put("GetCurrentDistanceArray",
				new GetCurrentDistanceArrayAction(this, model));

		actions.put("GetDistanceSensorInfo", new GetDistanceSensorInfoAction(
				this, model));

		actions.put("GetAbsoluteDeltaDetectionThreshold",
				new GetAbsoluteDeltaDetectionThresholdAction(this, model));

		actions.put("SetAbsoluteDeltaDetectionThreshold",
				new SetAbsoluteDeltaDetectionThresholdAction(this, model));

	}

	// UPnPStateVariable classes

	// class NameStateVariable
	public class NameStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "Name";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private PositionSensorModel model;

		public NameStateVariable(UPnPService upnpService,
				PositionSensorModel model) {
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
		private PositionSensorModel model;

		public ApplicationStateVariable(UPnPService upnpService,
				PositionSensorModel model) {
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

	// class AngleStateVariable
	public class AngleStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "Angle";
		public final static String DATATYPE = "float";

		// HERE specific state variable members
		private PositionSensorModel model;

		public AngleStateVariable(UPnPService upnpService,
				PositionSensorModel model) {
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

	// class AngleStepStateVariable
	public class AngleStepStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "AngleStep";
		public final static String DATATYPE = "i4";

		// HERE specific state variable members
		private PositionSensorModel model;

		public AngleStepStateVariable(UPnPService upnpService,
				PositionSensorModel model) {
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

	// class MinDetectionStateVariable
	public class MinDetectionStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "MinDetection";
		public final static String DATATYPE = "float";

		// HERE specific state variable members
		private PositionSensorModel model;

		public MinDetectionStateVariable(UPnPService upnpService,
				PositionSensorModel model) {
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

	// class MaxDetectionStateVariable
	public class MaxDetectionStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "MaxDetection";
		public final static String DATATYPE = "float";

		// HERE specific state variable members
		private PositionSensorModel model;

		public MaxDetectionStateVariable(UPnPService upnpService,
				PositionSensorModel model) {
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

	// class AbsoluteDeltaDetectionThresholdStateVariable
	public class AbsoluteDeltaDetectionThresholdStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "AbsoluteDeltaDetectionThreshold";
		public final static String DATATYPE = "float";

		// HERE specific state variable members
		private PositionSensorModel model;

		public AbsoluteDeltaDetectionThresholdStateVariable(
				UPnPService upnpService, PositionSensorModel model) {
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

	// class CurrentDistanceArrayStateVariable
	public class CurrentDistanceArrayStateVariable extends
			AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "CurrentDistanceArray";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private PositionSensorModel model;

		public CurrentDistanceArrayStateVariable(UPnPService upnpService,
				PositionSensorModel model) {
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

			return model.getCurrentDistanceArrayStateVariableValue();

		}
	};

	// class CurrentErrorStateVariable
	public class CurrentErrorStateVariable extends AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "CurrentError";
		public final static String DATATYPE = "float";

		// HERE specific state variable members
		private PositionSensorModel model;

		public CurrentErrorStateVariable(UPnPService upnpService,
				PositionSensorModel model) {
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

			return model.getCurrentErrorStateVariableValue();

		}
	};

	// UPnPAction classes

	public class GetNameAction extends AbstractUPnPAction {

		PositionSensorModel model;

		// HERE specific action members

		public GetNameAction(UPnPService upnpService, PositionSensorModel model) {
			super(upnpService, "GetName", "");
			this.model = model;

			addOutArg("Name", upnpService.getStateVariable("Name"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder name = new StringHolder();

			// invoke model

			model.getName(name);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("Name", name.getObject());
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

	public class GetCurrentDistanceArrayAction extends AbstractUPnPAction {

		PositionSensorModel model;

		// HERE specific action members

		public GetCurrentDistanceArrayAction(UPnPService upnpService,
				PositionSensorModel model) {
			super(upnpService, "GetCurrentDistanceArray", "");
			this.model = model;

			addOutArg("CurrentDistanceArray",
					upnpService.getStateVariable("CurrentDistanceArray"));

			addOutArg("CurrentError",
					upnpService.getStateVariable("CurrentError"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder currentDistanceArray = new StringHolder();
			FloatHolder currentError = new FloatHolder();

			// invoke model

			model.getCurrentDistanceArray(currentDistanceArray,

			currentError);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("CurrentDistanceArray",
					currentDistanceArray.getObject());
			// java.lang.String
			_result.put("CurrentError", currentError.getObject());
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

	public class GetDistanceSensorInfoAction extends AbstractUPnPAction {

		PositionSensorModel model;

		// HERE specific action members

		public GetDistanceSensorInfoAction(UPnPService upnpService,
				PositionSensorModel model) {
			super(upnpService, "GetDistanceSensorInfo", "");
			this.model = model;

			addOutArg("Name", upnpService.getStateVariable("Name"));

			addOutArg("Application",
					upnpService.getStateVariable("Application"));

			addOutArg("Angle", upnpService.getStateVariable("Angle"));

			addOutArg("AngleStep", upnpService.getStateVariable("AngleStep"));

			addOutArg("MinDetection",
					upnpService.getStateVariable("MinDetection"));

			addOutArg("MaxDetection",
					upnpService.getStateVariable("MaxDetection"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder name = new StringHolder();
			StringHolder application = new StringHolder();
			FloatHolder angle = new FloatHolder();
			IntegerHolder angleStep = new IntegerHolder();
			FloatHolder minDetection = new FloatHolder();
			FloatHolder maxDetection = new FloatHolder();

			// invoke model

			model.getDistanceSensorInfo(name,

			application,

			angle,

			angleStep,

			minDetection,

			maxDetection);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("Name", name.getObject());
			// java.lang.String
			_result.put("Application", application.getObject());
			// java.lang.String
			_result.put("Angle", angle.getObject());
			// java.lang.Float
			_result.put("AngleStep", angleStep.getObject());
			// java.lang.Integer
			_result.put("MinDetection", minDetection.getObject());
			// java.lang.Float
			_result.put("MaxDetection", maxDetection.getObject());
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

	public class GetAbsoluteDeltaDetectionThresholdAction extends
			AbstractUPnPAction {

		PositionSensorModel model;

		// HERE specific action members

		public GetAbsoluteDeltaDetectionThresholdAction(
				UPnPService upnpService, PositionSensorModel model) {
			super(upnpService, "GetAbsoluteDeltaDetectionThreshold", "");
			this.model = model;

			addOutArg(
					"CurrentAbsoluteDeltaDetectionThreshold",
					upnpService
							.getStateVariable("AbsoluteDeltaDetectionThreshold"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			FloatHolder currentAbsoluteDeltaDetectionThreshold = new FloatHolder();

			// invoke model

			model.getAbsoluteDeltaDetectionThreshold(currentAbsoluteDeltaDetectionThreshold);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("CurrentAbsoluteDeltaDetectionThreshold",
					currentAbsoluteDeltaDetectionThreshold.getObject());
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

	public class SetAbsoluteDeltaDetectionThresholdAction extends
			AbstractUPnPAction {

		PositionSensorModel model;

		// HERE specific action members

		public SetAbsoluteDeltaDetectionThresholdAction(
				UPnPService upnpService, PositionSensorModel model) {
			super(upnpService, "SetAbsoluteDeltaDetectionThreshold", "");
			this.model = model;

			addInArg(
					"NewAbsoluteDeltaDetectionThreshold",
					upnpService
							.getStateVariable("AbsoluteDeltaDetectionThreshold"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.Float newAbsoluteDeltaDetectionThreshold = (java.lang.Float) _args
					.get("NewAbsoluteDeltaDetectionThreshold");

			// invoke model

			model.setAbsoluteDeltaDetectionThreshold(FloatHolder
					.toValue(newAbsoluteDeltaDetectionThreshold)

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
