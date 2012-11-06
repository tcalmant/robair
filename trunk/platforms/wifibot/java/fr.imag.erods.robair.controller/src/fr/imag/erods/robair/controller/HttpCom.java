/**
 * 
 */
package fr.imag.erods.robair.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Property;
import org.apache.felix.ipojo.annotations.Provides;

import fr.imag.erods.robair.IRobotCommunication;

/**
 * @author Thomas Calmant
 */
@Component(name = "robair-http-factory")
@Provides(specifications = IRobotCommunication.class)
@Instantiate(name = "robair-http")
public class HttpCom implements IRobotCommunication {

	/** HTTP URL to the Python order handler */
	@Property(name = "robair.httpcmd.url")
	private final String pHttpUrl = "http://192.168.1.3:8000/robair";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.imag.erods.robair.IRobotCommunication#sendMessage(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void sendMessage(final String aTo, final String aMessage) {

		try {
			final URL url = new URL(pHttpUrl);
			final HttpURLConnection httpUrl = (HttpURLConnection) url
					.openConnection();

			httpUrl.setRequestMethod("POST");
			httpUrl.setDoOutput(true);

			// Write the POST data
			final byte[] bodyContent = aMessage.getBytes();
			httpUrl.setRequestProperty("content-length",
					Integer.toString(bodyContent.length));
			httpUrl.getOutputStream().write(bodyContent);

			// Send the request
			final int code = httpUrl.getResponseCode();

			// Get the result
			final Scanner scanner = new Scanner(httpUrl.getInputStream());
			final String response = scanner.useDelimiter("\\A").next();
			scanner.close();

			// Print it in case of error
			if (code != HttpURLConnection.HTTP_OK) {
				System.out.println("HTTP Result Code: " + code);
				System.out.println(response);
			}

		} catch (final MalformedURLException e) {
			e.printStackTrace();

		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
