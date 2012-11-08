/*
 __BANNER__
 */
// this file was generated at 7-November-2012 01:24 AM by ${author}
package org.robair.wifibot.service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.felix.upnp.devicegen.holder.BooleanHolder;
import org.apache.felix.upnp.devicegen.holder.StringHolder;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPAction;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPService;
import org.apache.felix.upnp.devicegen.util.AbstractUPnPStateVariable;
import org.osgi.framework.BundleContext;
import org.osgi.service.upnp.UPnPDevice;
import org.osgi.service.upnp.UPnPService;
import org.robair.wifibot.model.IMModel;

public class IM extends AbstractUPnPService {

	private IMModel model;

	/**
	 * constructor
	 */
	public IM(UPnPDevice upnpDevice, String serviceId, String serviceType,
			String version, IMModel model) {
		super(upnpDevice, serviceId, serviceType, version);
		this.model = model;

		stateVariables = new HashMap();

		stateVariables.put("XMPP_URL", new XMPP_URLStateVariable(this, model));

		stateVariables.put("SupportJingleForAV",
				new SupportJingleForAVStateVariable(this, model));

		stateVariables.put("SIP_URL", new SIP_URLStateVariable(this, model));

		stateVariables.put("SupportSimpleForCommandData",
				new SupportSimpleForCommandDataStateVariable(this, model));

		stateVariables.put("Skype_ID", new Skype_IDStateVariable(this, model));

		stateVariables.put("SupportMessageForCommandData",
				new SupportMessageForCommandDataStateVariable(this, model));

		actions = new HashMap();

		actions.put("GetXMPPInfo", new GetXMPPInfoAction(this, model));

		actions.put("GetSIPInfo", new GetSIPInfoAction(this, model));

		actions.put("GetSkypeInfo", new GetSkypeInfoAction(this, model));

	}

	// UPnPStateVariable classes

	// class XMPP_URLStateVariable
	public class XMPP_URLStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "XMPP_URL";
		public final static String DATATYPE = "uri";

		// HERE specific state variable members
		private IMModel model;

		public XMPP_URLStateVariable(UPnPService upnpService, IMModel model) {
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

	// class SupportJingleForAVStateVariable
	public class SupportJingleForAVStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "SupportJingleForAV";
		public final static String DATATYPE = "boolean";

		// HERE specific state variable members
		private IMModel model;

		public SupportJingleForAVStateVariable(UPnPService upnpService,
				IMModel model) {
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

	// class SIP_URLStateVariable
	public class SIP_URLStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "SIP_URL";
		public final static String DATATYPE = "uri";

		// HERE specific state variable members
		private IMModel model;

		public SIP_URLStateVariable(UPnPService upnpService, IMModel model) {
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

	// class SupportSimpleForCommandDataStateVariable
	public class SupportSimpleForCommandDataStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "SupportSimpleForCommandData";
		public final static String DATATYPE = "boolean";

		// HERE specific state variable members
		private IMModel model;

		public SupportSimpleForCommandDataStateVariable(
				UPnPService upnpService, IMModel model) {
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

	// class Skype_IDStateVariable
	public class Skype_IDStateVariable extends AbstractUPnPStateVariable

	{

		public final static String NAME = "Skype_ID";
		public final static String DATATYPE = "string";

		// HERE specific state variable members
		private IMModel model;

		public Skype_IDStateVariable(UPnPService upnpService, IMModel model) {
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

	// class SupportMessageForCommandDataStateVariable
	public class SupportMessageForCommandDataStateVariable extends
			AbstractUPnPStateVariable

	{

		public final static String NAME = "SupportMessageForCommandData";
		public final static String DATATYPE = "boolean";

		// HERE specific state variable members
		private IMModel model;

		public SupportMessageForCommandDataStateVariable(
				UPnPService upnpService, IMModel model) {
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

	public class GetXMPPInfoAction extends AbstractUPnPAction {

		IMModel model;

		// HERE specific action members

		public GetXMPPInfoAction(UPnPService upnpService, IMModel model) {
			super(upnpService, "GetXMPPInfo", "");
			this.model = model;

			addOutArg("XMPP_URL", upnpService.getStateVariable("XMPP_URL"));

			addOutArg("SupportJingleForAV",
					upnpService.getStateVariable("SupportJingleForAV"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder xMPP_URL = new StringHolder();
			BooleanHolder supportJingleForAV = new BooleanHolder();

			// invoke model

			model.getXMPPInfo(xMPP_URL,

			supportJingleForAV);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("XMPP_URL", xMPP_URL.getObject());
			// java.lang.String
			_result.put("SupportJingleForAV", supportJingleForAV.getObject());
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

	public class GetSIPInfoAction extends AbstractUPnPAction {

		IMModel model;

		// HERE specific action members

		public GetSIPInfoAction(UPnPService upnpService, IMModel model) {
			super(upnpService, "GetSIPInfo", "");
			this.model = model;

			addOutArg("SIP_URL", upnpService.getStateVariable("SIP_URL"));

			addOutArg("SupportSimpleForCommandData",
					upnpService.getStateVariable("SupportSimpleForCommandData"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder sIP_URL = new StringHolder();
			BooleanHolder supportSimpleForCommandData = new BooleanHolder();

			// invoke model

			model.getSIPInfo(sIP_URL,

			supportSimpleForCommandData);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("SIP_URL", sIP_URL.getObject());
			// java.lang.String
			_result.put("SupportSimpleForCommandData",
					supportSimpleForCommandData.getObject());
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

	public class GetSkypeInfoAction extends AbstractUPnPAction {

		IMModel model;

		// HERE specific action members

		public GetSkypeInfoAction(UPnPService upnpService, IMModel model) {
			super(upnpService, "GetSkypeInfo", "");
			this.model = model;

			addOutArg("Skype_ID", upnpService.getStateVariable("Skype_ID"));

			addOutArg("SupportMessageForCommandData",
					upnpService
							.getStateVariable("SupportMessageForCommandData"));

		}

		/**
		 * @see org.osgi.service.upnp.UPnPAction#invoke(java.util.Dictionary)
		 */
		@Override
		public Dictionary invoke(Dictionary _args) throws Exception {

			StringHolder skype_ID = new StringHolder();
			BooleanHolder supportMessageForCommandData = new BooleanHolder();

			// invoke model

			model.getSkypeInfo(skype_ID,

			supportMessageForCommandData);

			// build returned Dictionary
			Dictionary _result = new Hashtable();

			_result.put("Skype_ID", skype_ID.getObject());
			// java.lang.String
			_result.put("SupportMessageForCommandData",
					supportMessageForCommandData.getObject());
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

}
