/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.felix.upnp.devicegen.holder.IntegerHolder;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPAction;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPService;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPStateVariable;
import org.apache.felix.upnp.devicegen.util.UPnPStateVariableDescriptor;
import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPService;
import org.robair.wifibot.model.ChassisModel;

public class Chassis extends AbstractUPnPService {

	private ChassisModel model;

	/**
	 * constructor
	 */
	public Chassis(UPnPDevice upnpDevice, String serviceId, String serviceType,
			String version, ChassisModel model) {
		super(upnpDevice, serviceId, serviceType, version);
		this.model = model;

		stateVariables = new HashMap();

		stateVariables.put("A_ARG_Radius", new A_ARG_RadiusStateVariable(this,
				model));

		stateVariables.put("A_ARG_RadiusSpeed",
				new A_ARG_RadiusSpeedStateVariable(this, model));

		stateVariables.put("LeftSpeedTarget", new LeftSpeedTargetStateVariable(
				this, model));

		stateVariables.put("LeftSpeedStatus", new LeftSpeedStatusStateVariable(
				this, model));

		stateVariables.put("RightSpeedTarget",
				new RightSpeedTargetStateVariable(this, model));

		stateVariables.put("RightSpeedStatus",
				new RightSpeedStatusStateVariable(this, model));

		actions = new HashMap();

		actions.put("SetSpeedTarget", new SetSpeedTargetAction(this, model));

		actions.put("Rotate", new RotateAction(this, model));

		actions.put("Stop", new StopAction(this, model));

	}

	// UPnPStateVariable classes

	// class A_ARG_RadiusStateVariable
	public class A_ARG_RadiusStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "A_ARG_Radius";
		public final static String DATATYPE = "i4";

		// HERE specific state variable members
		private ChassisModel model;

		public A_ARG_RadiusStateVariable(UPnPService upnpService,
				ChassisModel model) {
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

	// class A_ARG_RadiusSpeedStateVariable
	public class A_ARG_RadiusSpeedStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "A_ARG_RadiusSpeed";
		public final static String DATATYPE = "i4";

		// HERE specific state variable members
		private ChassisModel model;

		public A_ARG_RadiusSpeedStateVariable(UPnPService upnpService,
				ChassisModel model) {
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

	// class LeftSpeedTargetStateVariable
	public class LeftSpeedTargetStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "LeftSpeedTarget";
		public final static String DATATYPE = "i1";

		// HERE specific state variable members
		private ChassisModel model;

		public LeftSpeedTargetStateVariable(UPnPService upnpService,
				ChassisModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for 0
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

	// class LeftSpeedStatusStateVariable
	public class LeftSpeedStatusStateVariable extends AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "LeftSpeedStatus";
		public final static String DATATYPE = "i1";

		// HERE specific state variable members
		private ChassisModel model;

		public LeftSpeedStatusStateVariable(UPnPService upnpService,
				ChassisModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for 0
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

			return model.getLeftSpeedStatusStateVariableValue();

		}
	};

	// class RightSpeedTargetStateVariable
	public class RightSpeedTargetStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "RightSpeedTarget";
		public final static String DATATYPE = "i1";

		// HERE specific state variable members
		private ChassisModel model;

		public RightSpeedTargetStateVariable(UPnPService upnpService,
				ChassisModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for 0
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

	// class RightSpeedStatusStateVariable
	public class RightSpeedStatusStateVariable extends
			AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "RightSpeedStatus";
		public final static String DATATYPE = "i1";

		// HERE specific state variable members
		private ChassisModel model;

		public RightSpeedStatusStateVariable(UPnPService upnpService,
				ChassisModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for 0
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

			return model.getRightSpeedStatusStateVariableValue();

		}
	};

	// UPnPAction classes

	public class SetSpeedTargetAction extends AbstractUPnPAction {

		ChassisModel model;

		// HERE specific action members

		public SetSpeedTargetAction(UPnPService upnpService, ChassisModel model) {
			super(upnpService, "SetSpeedTarget", "");
			this.model = model;

			addInArg("NewRightSpeed",
					upnpService.getStateVariable("RightSpeedTarget"));

			addInArg("NewLeftSpeed",
					upnpService.getStateVariable("LeftSpeedTarget"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.Integer newRightSpeed = (java.lang.Integer) _args
					.get("NewRightSpeed");
			java.lang.Integer newLeftSpeed = (java.lang.Integer) _args
					.get("NewLeftSpeed");

			// invoke model

			model.setSpeedTarget(IntegerHolder.toValue(newRightSpeed),

			IntegerHolder.toValue(newLeftSpeed)

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

	public class RotateAction extends AbstractUPnPAction {

		ChassisModel model;

		// HERE specific action members

		public RotateAction(UPnPService upnpService, ChassisModel model) {
			super(upnpService, "Rotate", "");
			this.model = model;

			addInArg("Radius", upnpService.getStateVariable("A_ARG_Radius"));

			addInArg("RadiusSpeed",
					upnpService.getStateVariable("A_ARG_RadiusSpeed"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.Integer radius = (java.lang.Integer) _args.get("Radius");
			java.lang.Integer radiusSpeed = (java.lang.Integer) _args
					.get("RadiusSpeed");

			// invoke model

			model.rotate(IntegerHolder.toValue(radius),

			IntegerHolder.toValue(radiusSpeed)

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

	public class StopAction extends AbstractUPnPAction {

		ChassisModel model;

		// HERE specific action members

		public StopAction(UPnPService upnpService, ChassisModel model) {
			super(upnpService, "Stop", "");
			this.model = model;

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			// invoke model

			model.stop(

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
