/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.apache.felix.upnp.devicegen.securitycamera.service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.felix.upnp.devicegen.holder.LongHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.apache.felix.upnp.devicegen.securitycamera.model.DigitalSecurityCameraMotionImageModel;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPAction;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPService;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPStateVariable;
import org.apache.felix.upnp.devicegen.util.UPnPStateVariableDescriptor;
import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPService;

public class DigitalSecurityCameraMotionImage extends AbstractUPnPService {

	private DigitalSecurityCameraMotionImageModel model;

	/**
	 * constructor
	 */
	public DigitalSecurityCameraMotionImage(UPnPDevice upnpDevice,
			String serviceId, String serviceType, String version,
			DigitalSecurityCameraMotionImageModel model) {
		super(upnpDevice, serviceId, serviceType, version);
		this.model = model;

		stateVariables = new HashMap();

		stateVariables.put("AvailableEncodings",
				new AvailableEncodingsStateVariable(this, model));

		stateVariables.put("DefaultEncoding", new DefaultEncodingStateVariable(
				this, model));

		stateVariables.put("AvailableCompressionLevels",
				new AvailableCompressionLevelsStateVariable(this, model));

		stateVariables.put("DefaultCompressionLevel",
				new DefaultCompressionLevelStateVariable(this, model));

		stateVariables.put("AvailableResolutions",
				new AvailableResolutionsStateVariable(this, model));

		stateVariables.put("DefaultResolution",
				new DefaultResolutionStateVariable(this, model));

		stateVariables.put("VideoURL", new VideoURLStateVariable(this, model));

		stateVariables.put("VideoPresentationURL",
				new VideoPresentationURLStateVariable(this, model));

		stateVariables.put("MaxBandwidth", new MaxBandwidthStateVariable(this,
				model));

		stateVariables.put("TargetFrameRate", new TargetFrameRateStateVariable(
				this, model));

		actions = new HashMap();

		actions.put("GetAvailableEncodings", new GetAvailableEncodingsAction(
				this, model));

		actions.put("GetDefaultEncoding", new GetDefaultEncodingAction(this,
				model));

		actions.put("SetDefaultEncoding", new SetDefaultEncodingAction(this,
				model));

		actions.put("GetAvailableCompressionLevels",
				new GetAvailableCompressionLevelsAction(this, model));

		actions.put("GetDefaultCompressionLevel",
				new GetDefaultCompressionLevelAction(this, model));

		actions.put("SetDefaultCompressionLevel",
				new SetDefaultCompressionLevelAction(this, model));

		actions.put("GetAvailableResolutions",
				new GetAvailableResolutionsAction(this, model));

		actions.put("GetDefaultResolution", new GetDefaultResolutionAction(
				this, model));

		actions.put("SetDefaultResolution", new SetDefaultResolutionAction(
				this, model));

		actions.put("GetVideoURL", new GetVideoURLAction(this, model));

		actions.put("GetDefaultVideoURL", new GetDefaultVideoURLAction(this,
				model));

		actions.put("GetVideoPresentationURL",
				new GetVideoPresentationURLAction(this, model));

		actions.put("GetDefaultVideoPresentationURL",
				new GetDefaultVideoPresentationURLAction(this, model));

		actions.put("SetMaxBandwidth", new SetMaxBandwidthAction(this, model));

		actions.put("GetMaxBandwidth", new GetMaxBandwidthAction(this, model));

		actions.put("SetTargetFrameRate", new SetTargetFrameRateAction(this,
				model));

		actions.put("GetTargetFrameRate", new GetTargetFrameRateAction(this,
				model));

	}

	// UPnPStateVariable classes

	// class AvailableEncodingsStateVariable
	public class AvailableEncodingsStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "AvailableEncodings";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraMotionImageModel model;

		public AvailableEncodingsStateVariable(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
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

	// class DefaultEncodingStateVariable
	public class DefaultEncodingStateVariable extends AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "DefaultEncoding";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraMotionImageModel model;

		public DefaultEncodingStateVariable(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
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

			return model.getDefaultEncodingStateVariableValue();

		}
	};

	// class AvailableCompressionLevelsStateVariable
	public class AvailableCompressionLevelsStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "AvailableCompressionLevels";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraMotionImageModel model;

		public AvailableCompressionLevelsStateVariable(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
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

	// class DefaultCompressionLevelStateVariable
	public class DefaultCompressionLevelStateVariable extends
			AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "DefaultCompressionLevel";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraMotionImageModel model;

		public DefaultCompressionLevelStateVariable(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
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

			return model.getDefaultCompressionLevelStateVariableValue();

		}
	};

	// class AvailableResolutionsStateVariable
	public class AvailableResolutionsStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "AvailableResolutions";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraMotionImageModel model;

		public AvailableResolutionsStateVariable(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
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

	// class DefaultResolutionStateVariable
	public class DefaultResolutionStateVariable extends
			AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "DefaultResolution";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraMotionImageModel model;

		public DefaultResolutionStateVariable(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
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

			return model.getDefaultResolutionStateVariableValue();

		}
	};

	// class VideoURLStateVariable
	public class VideoURLStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "VideoURL";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraMotionImageModel model;

		public VideoURLStateVariable(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
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

	// class VideoPresentationURLStateVariable
	public class VideoPresentationURLStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "VideoPresentationURL";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraMotionImageModel model;

		public VideoPresentationURLStateVariable(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
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

	// class MaxBandwidthStateVariable
	public class MaxBandwidthStateVariable extends AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "MaxBandwidth";
		public final static String DATATYPE = "ui4";

		// HERE specific state variable members
		private DigitalSecurityCameraMotionImageModel model;

		public MaxBandwidthStateVariable(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for 100
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

			return model.getMaxBandwidthStateVariableValue();

		}
	};

	// class TargetFrameRateStateVariable
	public class TargetFrameRateStateVariable extends AbstractUPnPStateVariable

	implements UPnPStateVariableDescriptor {

		public final static String NAME = "TargetFrameRate";
		public final static String DATATYPE = "ui4";

		// HERE specific state variable members
		private DigitalSecurityCameraMotionImageModel model;

		public TargetFrameRateStateVariable(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, NAME, DATATYPE, null, // TODO defaultValue
														// changed for 1500
					null, // TODO step changed for
					null, // TODO step changed for
					null, // TODO minimum changed for 0
					null, // TODO maximum changed for 1500
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

			return model.getTargetFrameRateStateVariableValue();

		}
	};

	// UPnPAction classes

	public class GetAvailableEncodingsAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public GetAvailableEncodingsAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "GetAvailableEncodings", "");
			this.model = model;

			addOutArg("RetAvailableEncodings",
					upnpService.getStateVariable("AvailableEncodings"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder retAvailableEncodings = new StringHolder();

			// invoke model

			model.getAvailableEncodings(retAvailableEncodings);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetAvailableEncodings",
					retAvailableEncodings.getObject());
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

	public class GetDefaultEncodingAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public GetDefaultEncodingAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "GetDefaultEncoding", "");
			this.model = model;

			addOutArg("RetEncoding",
					upnpService.getStateVariable("DefaultEncoding"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder retEncoding = new StringHolder();

			// invoke model

			model.getDefaultEncoding(retEncoding);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetEncoding", retEncoding.getObject());
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

	public class SetDefaultEncodingAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public SetDefaultEncodingAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "SetDefaultEncoding", "");
			this.model = model;

			addInArg("ReqEncoding",
					upnpService.getStateVariable("DefaultEncoding"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.String reqEncoding = (java.lang.String) _args
					.get("ReqEncoding");

			// invoke model

			model.setDefaultEncoding(StringHolder.toValue(reqEncoding)

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

	public class GetAvailableCompressionLevelsAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public GetAvailableCompressionLevelsAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "GetAvailableCompressionLevels", "");
			this.model = model;

			addOutArg("RetAvailableCompressionLevels",
					upnpService.getStateVariable("AvailableCompressionLevels"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder retAvailableCompressionLevels = new StringHolder();

			// invoke model

			model.getAvailableCompressionLevels(retAvailableCompressionLevels);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetAvailableCompressionLevels",
					retAvailableCompressionLevels.getObject());
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

	public class GetDefaultCompressionLevelAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public GetDefaultCompressionLevelAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "GetDefaultCompressionLevel", "");
			this.model = model;

			addOutArg("RetCompressionLevel",
					upnpService.getStateVariable("DefaultCompressionLevel"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder retCompressionLevel = new StringHolder();

			// invoke model

			model.getDefaultCompressionLevel(retCompressionLevel);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetCompressionLevel", retCompressionLevel.getObject());
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

	public class SetDefaultCompressionLevelAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public SetDefaultCompressionLevelAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "SetDefaultCompressionLevel", "");
			this.model = model;

			addInArg("ReqCompressionLevel",
					upnpService.getStateVariable("DefaultCompressionLevel"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.String reqCompressionLevel = (java.lang.String) _args
					.get("ReqCompressionLevel");

			// invoke model

			model.setDefaultCompressionLevel(StringHolder
					.toValue(reqCompressionLevel)

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

	public class GetAvailableResolutionsAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public GetAvailableResolutionsAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "GetAvailableResolutions", "");
			this.model = model;

			addOutArg("RetAvailableResolutions",
					upnpService.getStateVariable("AvailableResolutions"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder retAvailableResolutions = new StringHolder();

			// invoke model

			model.getAvailableResolutions(retAvailableResolutions);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetAvailableResolutions",
					retAvailableResolutions.getObject());
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

	public class GetDefaultResolutionAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public GetDefaultResolutionAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "GetDefaultResolution", "");
			this.model = model;

			addOutArg("RetResolution",
					upnpService.getStateVariable("DefaultResolution"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder retResolution = new StringHolder();

			// invoke model

			model.getDefaultResolution(retResolution);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetResolution", retResolution.getObject());
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

	public class SetDefaultResolutionAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public SetDefaultResolutionAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "SetDefaultResolution", "");
			this.model = model;

			addInArg("ReqResolution",
					upnpService.getStateVariable("DefaultResolution"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.String reqResolution = (java.lang.String) _args
					.get("ReqResolution");

			// invoke model

			model.setDefaultResolution(StringHolder.toValue(reqResolution)

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

	public class GetVideoURLAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public GetVideoURLAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "GetVideoURL", "");
			this.model = model;

			addInArg("ReqEncoding",
					upnpService.getStateVariable("DefaultEncoding"));

			addInArg("ReqCompression",
					upnpService.getStateVariable("DefaultCompressionLevel"));

			addInArg("ReqResolution",
					upnpService.getStateVariable("DefaultResolution"));

			addOutArg("RetVideoURL", upnpService.getStateVariable("VideoURL"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.String reqEncoding = (java.lang.String) _args
					.get("ReqEncoding");
			java.lang.String reqCompression = (java.lang.String) _args
					.get("ReqCompression");
			java.lang.String reqResolution = (java.lang.String) _args
					.get("ReqResolution");
			StringHolder retVideoURL = new StringHolder();

			// invoke model

			model.getVideoURL(StringHolder.toValue(reqEncoding),

			StringHolder.toValue(reqCompression),

			StringHolder.toValue(reqResolution),

			retVideoURL);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetVideoURL", retVideoURL.getObject());
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

	public class GetDefaultVideoURLAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public GetDefaultVideoURLAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "GetDefaultVideoURL", "");
			this.model = model;

			addOutArg("RetVideoURL", upnpService.getStateVariable("VideoURL"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder retVideoURL = new StringHolder();

			// invoke model

			model.getDefaultVideoURL(retVideoURL);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetVideoURL", retVideoURL.getObject());
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

	public class GetVideoPresentationURLAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public GetVideoPresentationURLAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "GetVideoPresentationURL", "");
			this.model = model;

			addInArg("ReqEncoding",
					upnpService.getStateVariable("DefaultEncoding"));

			addInArg("ReqCompression",
					upnpService.getStateVariable("DefaultCompressionLevel"));

			addInArg("ReqResolution",
					upnpService.getStateVariable("DefaultResolution"));

			addOutArg("RetVideoPresentationURL",
					upnpService.getStateVariable("VideoPresentationURL"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.String reqEncoding = (java.lang.String) _args
					.get("ReqEncoding");
			java.lang.String reqCompression = (java.lang.String) _args
					.get("ReqCompression");
			java.lang.String reqResolution = (java.lang.String) _args
					.get("ReqResolution");
			StringHolder retVideoPresentationURL = new StringHolder();

			// invoke model

			model.getVideoPresentationURL(StringHolder.toValue(reqEncoding),

			StringHolder.toValue(reqCompression),

			StringHolder.toValue(reqResolution),

			retVideoPresentationURL);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetVideoPresentationURL",
					retVideoPresentationURL.getObject());
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

	public class GetDefaultVideoPresentationURLAction extends
			AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public GetDefaultVideoPresentationURLAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "GetDefaultVideoPresentationURL", "");
			this.model = model;

			addOutArg("RetVideoPresentationURL",
					upnpService.getStateVariable("VideoPresentationURL"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder retVideoPresentationURL = new StringHolder();

			// invoke model

			model.getDefaultVideoPresentationURL(retVideoPresentationURL);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetVideoPresentationURL",
					retVideoPresentationURL.getObject());
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

	public class SetMaxBandwidthAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public SetMaxBandwidthAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "SetMaxBandwidth", "");
			this.model = model;

			addInArg("ReqMaxBandwidth",
					upnpService.getStateVariable("MaxBandwidth"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.Long reqMaxBandwidth = (java.lang.Long) _args
					.get("ReqMaxBandwidth");

			// invoke model

			model.setMaxBandwidth(LongHolder.toValue(reqMaxBandwidth)

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

	public class GetMaxBandwidthAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public GetMaxBandwidthAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "GetMaxBandwidth", "");
			this.model = model;

			addOutArg("RetMaxBandwidth",
					upnpService.getStateVariable("MaxBandwidth"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			LongHolder retMaxBandwidth = new LongHolder();

			// invoke model

			model.getMaxBandwidth(retMaxBandwidth);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetMaxBandwidth", retMaxBandwidth.getObject());
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

	public class SetTargetFrameRateAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public SetTargetFrameRateAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "SetTargetFrameRate", "");
			this.model = model;

			addInArg("ReqTargetFrameRate",
					upnpService.getStateVariable("TargetFrameRate"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			java.lang.Long reqTargetFrameRate = (java.lang.Long) _args
					.get("ReqTargetFrameRate");

			// invoke model

			model.setTargetFrameRate(LongHolder.toValue(reqTargetFrameRate)

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

	public class GetTargetFrameRateAction extends AbstractUPnPAction {

		DigitalSecurityCameraMotionImageModel model;

		// HERE specific action members

		public GetTargetFrameRateAction(UPnPService upnpService,
				DigitalSecurityCameraMotionImageModel model) {
			super(upnpService, "GetTargetFrameRate", "");
			this.model = model;

			addOutArg("RetTargetFrameRate",
					upnpService.getStateVariable("TargetFrameRate"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			LongHolder retTargetFrameRate = new LongHolder();

			// invoke model

			model.getTargetFrameRate(retTargetFrameRate);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetTargetFrameRate", retTargetFrameRate.getObject());
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

}
