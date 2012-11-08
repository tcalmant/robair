/**
 * 
 */
package fr.imag.erods.robair.jitsi;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.java.sip.communicator.service.protocol.Contact;
import net.java.sip.communicator.service.protocol.OperationSetBasicInstantMessaging;
import net.java.sip.communicator.service.protocol.OperationSetPresence;
import net.java.sip.communicator.service.protocol.ProtocolProviderService;

import org.apache.felix.ipojo.annotations.Bind;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.ServiceController;
import org.apache.felix.ipojo.annotations.Unbind;

import fr.imag.erods.robair.IRobotCommunication;

/**
 * COM using Jitsi services
 * 
 * @author Thomas Calmant
 */
@Component(name = "jitsi-com-factory")
@Provides(specifications = IRobotCommunication.class)
@Instantiate(name = "jitsi-com")
public class JitsiCom implements IRobotCommunication {

	/** Provider service iPOJO dependency ID */
	private static final String DEP_ID_PROVIDER = "protocol-provider";

	/** The protocol providers */
	private final List<ProtocolProviderService> pProtocolServices = new LinkedList<ProtocolProviderService>();

	/** iPOJO service controller */
	@ServiceController
	private boolean pServiceControl = false;

	/**
	 * Tests if the given provider can be accepted to communicate with the robot
	 * 
	 * @param aProvider
	 *            A Jitsi protocol provider
	 * @return True if the provider is usable
	 */
	private boolean acceptProtocolProvider(
			final ProtocolProviderService aProvider) {

		// Test basic IM operations presence
		return getBasicIM(aProvider) != null;
	}

	/** Called by iPOPO when a provider is found */
	@Bind(id = DEP_ID_PROVIDER, aggregate = true)
	protected synchronized void bindProviderService(
			final ProtocolProviderService aProvider) {

		if (!pProtocolServices.contains(aProvider)
				&& acceptProtocolProvider(aProvider)) {
			pProtocolServices.add(aProvider);
		}

		updateServiceState();
	}

	/**
	 * Creates a Contact object using the given provider
	 * 
	 * @param aProvider
	 *            Jitsi protocol provider
	 * @param aAddress
	 *            Contact address
	 * @return An unresolved contact
	 */
	private Contact createUnresolvedContact(
			final ProtocolProviderService aProvider, final String aAddress) {

		final OperationSetPresence presence = aProvider
				.getOperationSet(OperationSetPresence.class);
		if (presence == null) {
			// No presence operation set
			return null;
		}

		return presence.createUnresolvedContact(aAddress, null);
	}

	/**
	 * Retrieves the basic IM operations set of the given provider
	 * 
	 * @param aProvider
	 *            A Jitsi protocol provider
	 * @return the basic IM operations set
	 */
	private OperationSetBasicInstantMessaging getBasicIM(
			final ProtocolProviderService aProvider) {

		return aProvider
				.getOperationSet(OperationSetBasicInstantMessaging.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.imag.erods.robair.controller.impl.ICommunication#sendMessage(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	public Map<String, ?> sendMessage(final String aTo, final String aMessage) {

		for (final ProtocolProviderService provider : pProtocolServices) {

			// Get the IM operation set
			final OperationSetBasicInstantMessaging basicIm = getBasicIM(provider);

			// Send the message
			try {
				basicIm.sendInstantMessage(
						createUnresolvedContact(provider, aTo),
						basicIm.createMessage(aMessage));

			} catch (final IllegalArgumentException ex) {
				ex.printStackTrace();
			}
		}

		// TODO: compute the result
		return null;
	}

	/** Called by iPOPO when a provider is gone */
	@Unbind(id = DEP_ID_PROVIDER, aggregate = true)
	protected synchronized void unbindProviderService(
			final ProtocolProviderService aProvider) {

		if (pProtocolServices.contains(aProvider)) {
			pProtocolServices.remove(aProvider);
		}

		updateServiceState();
	}

	/**
	 * Updates the value of the service controller
	 */
	private void updateServiceState() {

		pServiceControl = !pProtocolServices.isEmpty();
	}
}
