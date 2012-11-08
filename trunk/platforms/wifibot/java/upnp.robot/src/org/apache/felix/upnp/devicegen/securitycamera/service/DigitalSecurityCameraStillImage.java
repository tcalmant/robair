/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.apache.felix.upnp.devicegen.securitycamera.service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.apache.felix.upnp.devicegen.securitycamera.model.DigitalSecurityCameraStillImageModel;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPAction;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPService;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPStateVariable;
import org.apache.felix.upnp.devicegen.util.UPnPStateVariableDescriptor;
import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPService;

public class DigitalSecurityCameraStillImage extends AbstractUPnPService {

	private DigitalSecurityCameraStillImageModel model;

	/**
	 * constructor
	 */
	public DigitalSecurityCameraStillImage(UPnPDevice upnpDevice,
			String serviceId, String serviceType, String version,
			DigitalSecurityCameraStillImageModel model) {
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

		stateVariables.put("ImageURL", new ImageURLStateVariable(this, model));

		stateVariables.put("ImagePresentationURL",
				new ImagePresentationURLStateVariable(this, model));

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

		actions.put("GetImageURL", new GetImageURLAction(this, model));

		actions.put("GetDefaultImageURL", new GetDefaultImageURLAction(this,
				model));

		actions.put("GetImagePresentationURL",
				new GetImagePresentationURLAction(this, model));

		actions.put("GetDefaultImagePresentationURL",
				new GetDefaultImagePresentationURLAction(this, model));

	}

	// UPnPStateVariable classes

	// class AvailableEncodingsStateVariable
	public class AvailableEncodingsStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "AvailableEncodings";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraStillImageModel model;

		public AvailableEncodingsStateVariable(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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
		private DigitalSecurityCameraStillImageModel model;

		public DefaultEncodingStateVariable(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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
		private DigitalSecurityCameraStillImageModel model;

		public AvailableCompressionLevelsStateVariable(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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
		private DigitalSecurityCameraStillImageModel model;

		public DefaultCompressionLevelStateVariable(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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
		private DigitalSecurityCameraStillImageModel model;

		public AvailableResolutionsStateVariable(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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
		private DigitalSecurityCameraStillImageModel model;

		public DefaultResolutionStateVariable(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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

	// class ImageURLStateVariable
	public class ImageURLStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "ImageURL";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraStillImageModel model;

		public ImageURLStateVariable(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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

	// class ImagePresentationURLStateVariable
	public class ImagePresentationURLStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "ImagePresentationURL";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private DigitalSecurityCameraStillImageModel model;

		public ImagePresentationURLStateVariable(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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

	// UPnPAction classes

	public class GetAvailableEncodingsAction extends AbstractUPnPAction {

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public GetAvailableEncodingsAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public GetDefaultEncodingAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public SetDefaultEncodingAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public GetAvailableCompressionLevelsAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public GetDefaultCompressionLevelAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public SetDefaultCompressionLevelAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public GetAvailableResolutionsAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public GetDefaultResolutionAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public SetDefaultResolutionAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
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

	public class GetImageURLAction extends AbstractUPnPAction {

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public GetImageURLAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
			super(upnpService, "GetImageURL", "");
			this.model = model;

			addInArg("ReqEncoding",
					upnpService.getStateVariable("DefaultEncoding"));

			addInArg("ReqCompression",
					upnpService.getStateVariable("DefaultCompressionLevel"));

			addInArg("ReqResolution",
					upnpService.getStateVariable("DefaultResolution"));

			addOutArg("RetImageURL", upnpService.getStateVariable("ImageURL"));

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
			StringHolder retImageURL = new StringHolder();

			// invoke model

			model.getImageURL(StringHolder.toValue(reqEncoding),

			StringHolder.toValue(reqCompression),

			StringHolder.toValue(reqResolution),

			retImageURL);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetImageURL", retImageURL.getObject());
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

	public class GetDefaultImageURLAction extends AbstractUPnPAction {

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public GetDefaultImageURLAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
			super(upnpService, "GetDefaultImageURL", "");
			this.model = model;

			addOutArg("RetImageURL", upnpService.getStateVariable("ImageURL"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder retImageURL = new StringHolder();

			// invoke model

			model.getDefaultImageURL(retImageURL);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetImageURL", retImageURL.getObject());
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

	public class GetImagePresentationURLAction extends AbstractUPnPAction {

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public GetImagePresentationURLAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
			super(upnpService, "GetImagePresentationURL", "");
			this.model = model;

			addInArg("ReqEncoding",
					upnpService.getStateVariable("DefaultEncoding"));

			addInArg("ReqCompression",
					upnpService.getStateVariable("DefaultCompressionLevel"));

			addInArg("ReqResolution",
					upnpService.getStateVariable("DefaultResolution"));

			addOutArg("RetImagePresentationURL",
					upnpService.getStateVariable("ImagePresentationURL"));

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
			StringHolder retImagePresentationURL = new StringHolder();

			// invoke model

			model.getImagePresentationURL(StringHolder.toValue(reqEncoding),

			StringHolder.toValue(reqCompression),

			StringHolder.toValue(reqResolution),

			retImagePresentationURL);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetImagePresentationURL",
					retImagePresentationURL.getObject());
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

	public class GetDefaultImagePresentationURLAction extends
			AbstractUPnPAction {

		DigitalSecurityCameraStillImageModel model;

		// HERE specific action members

		public GetDefaultImagePresentationURLAction(UPnPService upnpService,
				DigitalSecurityCameraStillImageModel model) {
			super(upnpService, "GetDefaultImagePresentationURL", "");
			this.model = model;

			addOutArg("RetImagePresentationURL",
					upnpService.getStateVariable("ImagePresentationURL"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder retImagePresentationURL = new StringHolder();

			// invoke model

			model.getDefaultImagePresentationURL(retImagePresentationURL);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("RetImagePresentationURL",
					retImagePresentationURL.getObject());
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

}
