package com.ae.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.ae.qa.context.Constants;

/**
 * The Class has all TestProperties (All properties mentioned in <strong>test.properties</strong> file).
 *
 * @author Yashawantkumar
 */
public class TestProperties {
	
	/** The Constant props. */
	private static final Properties props = new Properties();

	/**
	 * Load all propertie.
	 */
	public static void loadAllPropertie() {
		try {
			FileInputStream Locator;
			Locator = new FileInputStream(Constants.property_filepath);
			System.out.println("File Path : "+Constants.property_filepath);
			props.load(Locator);
			System.out.println("Property of the browser: "+props.getProperty("browser"));
		} catch (IOException e) {
			//LoggerUtil.getLogger().fatal("Could not load properties : " + e.getMessage());
		}
	}

	/**
	 * Gets the property.
	 *
	 * @param key the key
	 * @return the property
	 */
	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	/**
	 * Put property.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public static void putProperty(String key, String value) {
		props.put(key, value);
	}
}