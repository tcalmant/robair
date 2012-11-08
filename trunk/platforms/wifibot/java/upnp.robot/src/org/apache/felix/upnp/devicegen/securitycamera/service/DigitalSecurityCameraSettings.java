/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.apache.felix.upnp.devicegen.securitycamera.service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.felix.upnp.devicegen.holder.BooleanHolder;
import org.apache.felix.upnp.devicegen.holder.IntegerHolder;
import org.apache.felix.upnp.devicegen.holder.LongHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.apache.felix.upnp.devicegen.securitycamera.model.DigitalSecurityCameraSettingsModel;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPAction;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPService;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPStateVariable;
import org.apache.felix.upnp.devicegen.util.UPnPStateVariableDescriptor;
import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPService;

public class DigitalSecurityCameraSettings extends AbstractUPnPService {

	private DigitalSecurityCameraSettingsModel model;

	/**
	 * constructor
	 */
	public DigitalSecurityCameraSettings(UPnPDevice upnpDevice,
			String serviceId, String serviceType, String version,
			DigitalSecurityCameraSettingsModel model) {
		super(upnpDevice, serviceId, serviceType, version);
		this.model = model;

		stateVariables = new HashMap();

		stateVariables.put("AutomaticWhiteBalance",
				new AutomaticWhiteBalanceStateVariable(this, model));

		stateVariables.put("FixedWhiteBalance",
				new FixedWhiteBalanceStateVariable(this, model));

		stateVariables.put("AvailableRotations",
				new AvailableRotationsStateVariable(this, model));

		stateVariables.put("DefaultRotation", new DefaultRotationStateVariable(
				this, model));

		stateVariables.put("Brightness", new BrightnessStateVariable(this,
				model));

		stateVariables.put("ColorSaturation", new ColorSaturationStateVariable(
				this, model));

		actions = new HashMap();

		actions.put("SetAutomaticWhiteBalance",
				new SetAutomaticWhiteBalanceAction(this, model));

		actions.put("GetAutomaticWhiteBalance",
				new GetAutomaticWhiteBalanceAction(this, model));

		actions.put("SetFixedWhiteBalance", new SetFixedWhiteBalanceAction(
				this, model));

		actions.put("GetFixedWhiteBalance", new GetFixedWhiteBalanceAction(
				this, model));

		actions.put("GetAvailableRotations", new GetAvailableRotationsAction(
				this, model));

		actions.put("SetDefaultRotation", new SetDefaultRotationAction(this,
				model));

		actions.put("GetDefaultRotation", new GetDefaultRotationAction(this,
				model));

		actions.put("SetBrightness", new SetBrightnessAction(this, model));

		actions.put("GetBrightness", new GetBrightnessAction(this, model));

		actions.put("IncreaseBrightness", new IncreaseBrightnessAction(this,
				model));

		actions.put("DecreaseBrightness", new DecreaseBrightnessAction(this,
				model));

		actions.put("SetColorSaturation", new SetColorSaturationAction(this,
				model));

		actions.put("GetColorSaturation", new GetColorSaturationAction(this,
				model));

		actions.put("IncreaseColorSaturation",
				new IncreaseColorSaturationAction(this, model));

		actions.put("DecreaseColorSaturation",
				new DecreaseColorSaturationAction(this, model));

	}

	// UPnPStateVariable classes

	// class AutomaticWhiteBalanceStateVariable
	public class AutomaticWhiteBalanceStateVariable extends
			AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "AutomaticWhiteBalance";
		public final static String DATATYPE = "boolean";

		// HERE specific state variable members
		private DigitalSecurityCameraSettingsModel model;

		public AutomaticWhiteBalanceStateVariable(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for 1
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

			return model.getAutomaticWhiteBalanceStateVariableValue();

		}
	};

	// class FixedWhiteBalanceStateVariable
	public class FixedWhiteBalanceStateVariable extends
			AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "FixedWhiteBalance";
		public final static String DATATYPE = "ui4";

		// HERE specific state variable members
		private DigitalSecurityCameraSettingsModel model;

		public FixedWhiteBalanceStateVariable(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for 3000
					null, // TODO step changed for
					null, // TODO step changed for
					null, // TODO minimum changed for 0
					null, // TODO maximum changed for 10000
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

			return model.getFixedWhiteBalanceStateVariableValue();

		}
	};

	// class AvailableRotationsStateVariable
	public class AvailableRotationsStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "AvailableRotations";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraSettingsModel model;

		public AvailableRotationsStateVariable(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
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

	// class DefaultRotationStateVariable
	public class DefaultRotationStateVariable extends AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "DefaultRotation";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraSettingsModel model;

		public DefaultRotationStateVariable(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
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

			return model.getDefaultRotationStateVariableValue();

		}
	};

	// class BrightnessStateVariable
	public class BrightnessStateVariable extends AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "Brightness";
		public final static String DATATYPE = "ui1";

		// HERE specific state variable members
		private DigitalSecurityCameraSettingsModel model;

		public BrightnessStateVariable(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for 50
					null, // TODO step changed for
					null, // TODO step changed for
					null, // TODO minimum changed for 0
					null, // TODO maximum changed for 100
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

			return model.getBrightnessStateVariableValue();

		}
	};

	// class ColorSaturationStateVariable
	public class ColorSaturationStateVariable extends AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "ColorSaturation";
		public final static String DATATYPE = "ui1";

		// HERE specific state variable members
		private DigitalSecurityCameraSettingsModel model;

		public ColorSaturationStateVariable(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for 50
					null, // TODO step changed for
					null, // TODO step changed for
					null, // TODO minimum changed for 0
					null, // TODO maximum changed for 100
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

			return model.getColorSaturationStateVariableValue();

		}
	};

	// UPnPAction classes

	public class SetAutomaticWhiteBalanceAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public SetAutomaticWhiteBalanceAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "SetAutomaticWhiteBalance", "");
			this.model = model;

			addInArg("NewAutomaticWhiteBalance",
					upnpService.getStateVariable("AutomaticWhiteBalance"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.Boolean newAutomaticWhiteBalance = (java.lang.Boolean) _args
					.get("NewAutomaticWhiteBalance");

			// invoke model

			model.setAutomaticWhiteBalance(BooleanHolder
					.toValue(newAutomaticWhiteBalance)

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

	public class GetAutomaticWhiteBalanceAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public GetAutomaticWhiteBalanceAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "GetAutomaticWhiteBalance", "");
			this.model = model;

			addOutArg("RetAutomaticWhiteBalance",
					upnpService.getStateVariable("AutomaticWhiteBalance"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			BooleanHolder retAutomaticWhiteBalance = new BooleanHolder();

			// invoke model

			model.getAutomaticWhiteBalance(retAutomaticWhiteBalance);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetAutomaticWhiteBalance",
					retAutomaticWhiteBalance.getObject());
			// java.lang.Boolean
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

	public class SetFixedWhiteBalanceAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public SetFixedWhiteBalanceAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "SetFixedWhiteBalance", "");
			this.model = model;

			addInArg("NewFixedWhiteBalance",
					upnpService.getStateVariable("FixedWhiteBalance"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.Long newFixedWhiteBalance = (java.lang.Long) _args
					.get("NewFixedWhiteBalance");

			// invoke model

			model.setFixedWhiteBalance(LongHolder.toValue(newFixedWhiteBalance)

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

	public class GetFixedWhiteBalanceAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public GetFixedWhiteBalanceAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "GetFixedWhiteBalance", "");
			this.model = model;

			addOutArg("RetFixedWhiteBalance",
					upnpService.getStateVariable("FixedWhiteBalance"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			LongHolder retFixedWhiteBalance = new LongHolder();

			// invoke model

			model.getFixedWhiteBalance(retFixedWhiteBalance);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetFixedWhiteBalance",
					retFixedWhiteBalance.getObject());
			// java.lang.Long
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

	public class GetAvailableRotationsAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public GetAvailableRotationsAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "GetAvailableRotations", "");
			this.model = model;

			addOutArg("RetAvailableRotations",
					upnpService.getStateVariable("AvailableRotations"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder retAvailableRotations = new StringHolder();

			// invoke model

			model.getAvailableRotations(retAvailableRotations);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetAvailableRotations",
					retAvailableRotations.getObject());
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

	public class SetDefaultRotationAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public SetDefaultRotationAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "SetDefaultRotation", "");
			this.model = model;

			addInArg("NewRotation",
					upnpService.getStateVariable("DefaultRotation"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.String newRotation = (java.lang.String) _args
					.get("NewRotation");

			// invoke model

			model.setDefaultRotation(StringHolder.toValue(newRotation)

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

	public class GetDefaultRotationAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public GetDefaultRotationAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "GetDefaultRotation", "");
			this.model = model;

			addOutArg("RetRotation",
					upnpService.getStateVariable("DefaultRotation"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder retRotation = new StringHolder();

			// invoke model

			model.getDefaultRotation(retRotation);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetRotation", retRotation.getObject());
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

	public class SetBrightnessAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public SetBrightnessAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "SetBrightness", "");
			this.model = model;

			addInArg("NewBrightness",
					upnpService.getStateVariable("Brightness"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.Integer newBrightness = (java.lang.Integer) _args
					.get("NewBrightness");

			// invoke model

			model.setBrightness(IntegerHolder.toValue(newBrightness)

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

	public class GetBrightnessAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public GetBrightnessAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "GetBrightness", "");
			this.model = model;

			addOutArg("RetBrightness",
					upnpService.getStateVariable("Brightness"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			IntegerHolder retBrightness = new IntegerHolder();

			// invoke model

			model.getBrightness(retBrightness);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetBrightness", retBrightness.getObject());
			// java.lang.Integer
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

	public class IncreaseBrightnessAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public IncreaseBrightnessAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "IncreaseBrightness", "");
			this.model = model;

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			// invoke model

			model.increaseBrightness(

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

	public class DecreaseBrightnessAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public DecreaseBrightnessAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "DecreaseBrightness", "");
			this.model = model;

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			// invoke model

			model.decreaseBrightness(

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

	public class SetColorSaturationAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public SetColorSaturationAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "SetColorSaturation", "");
			this.model = model;

			addInArg("NewColorSaturation",
					upnpService.getStateVariable("ColorSaturation"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.Integer newColorSaturation = (java.lang.Integer) _args
					.get("NewColorSaturation");

			// invoke model

			model.setColorSaturation(IntegerHolder.toValue(newColorSaturation)

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

	public class GetColorSaturationAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public GetColorSaturationAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "GetColorSaturation", "");
			this.model = model;

			addOutArg("RetColorSaturation",
					upnpService.getStateVariable("ColorSaturation"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			IntegerHolder retColorSaturation = new IntegerHolder();

			// invoke model

			model.getColorSaturation(retColorSaturation);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetColorSaturation", retColorSaturation.getObject());
			// java.lang.Integer
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

	public class IncreaseColorSaturationAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public IncreaseColorSaturationAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "IncreaseColorSaturation", "");
			this.model = model;

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			// invoke model

			model.increaseColorSaturation(

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

	public class DecreaseColorSaturationAction extends AbstractUPnPAction {

		DigitalSecurityCameraSettingsModel model;

		// HERE specific action members

		public DecreaseColorSaturationAction(UPnPService upnpService,
				DigitalSecurityCameraSettingsModel model) {
			super(upnpService, "DecreaseColorSaturation", "");
			this.model = model;

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			// invoke model

			model.decreaseColorSaturation(

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
