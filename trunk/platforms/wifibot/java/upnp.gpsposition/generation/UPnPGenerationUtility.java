/**
 * This class provides an XSLT extension function that
 * may be utilized by Xalan-Java extension mechanism.
 */
public class UPnPGenerationUtility {

	private final static String URN_UPNP_ORG_SERVICE="urn:schemas-upnp-org:service:";
	private final static String URN_UPNP_ORG_SERVICE_ID="urn:upnp-org:serviceId:";
	private final static String URN_UPNP_ORG_DEVICE="urn:schemas-upnp-org:device:";
	
	/**
	 */
	private static String getType(String urn, String prefix) {
		int last=urn.lastIndexOf(':');
		int first;
		if(urn.startsWith(prefix)){
			first=prefix.length();
			return urn.substring(first,last);
		} else if(last>0 && (first=urn.lastIndexOf(':',last-1))>0) {
			return urn.substring(first+1,last);
		} else {
			String st=urn.replace(':','_');
			st=st.replace('-','_');
			return st;						
		}
	}

	private static String getVersion(String urn) {
		int last=urn.lastIndexOf(":");
		String version;
		if(last<0) {
			version="0";
		} else {
			version=urn.substring(last+1);
		}
		return version;
	}

	private static String getTypeVersion(String urn, String prefix) {
		return getType(urn,prefix)+getVersion(urn);
	}

	/**
	 */
	public static String deviceType(String urn) {
		return getType(urn,URN_UPNP_ORG_DEVICE);
	}

	public static String deviceTypeVersion(String urn) {
		return getTypeVersion(urn,URN_UPNP_ORG_DEVICE);
	}
	
	/**
	 */
	public static String serviceType(String urn) {
		return getType(urn,URN_UPNP_ORG_SERVICE);
	}

	public static String serviceTypeVersion(String urn) {
		return getTypeVersion(urn,URN_UPNP_ORG_SERVICE);
	}
	
	/**
	 */
	public static String serviceId(String urn) {
		return getType(urn,URN_UPNP_ORG_SERVICE_ID);
	}

	/**
	 */
	public static String serviceIdVersion(String urn) {
		return getTypeVersion(urn,URN_UPNP_ORG_SERVICE_ID);
	}

	/**
	 */
	public static String serviceVersion(String urn) {
		return getVersion(urn);
	}

}