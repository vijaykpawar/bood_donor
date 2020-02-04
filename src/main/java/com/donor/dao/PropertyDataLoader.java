package com.donor.dao;

import java.util.Locale;
import java.util.ResourceBundle;


public final class PropertyDataLoader {

	/** The bundle. */
	private ResourceBundle bundle;

	/** The instance. */
	private static PropertyDataLoader inst = null;

	/**
	 * Instantiates a new property data loader.
	 */
	private PropertyDataLoader() {
		try {
			bundle = ResourceBundle.getBundle("donor", new Locale("en_US"));
			System.out.println("PropertyDataLoader.PropertyDataLoader() : "
					+ bundle.getKeys());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * Gets the single instance of PropertyDataLoader.
	 * 
	 * @return single instance of PropertyDataLoader
	 */
	public static PropertyDataLoader getInstance() {
		if (inst == null) {
			inst = new PropertyDataLoader();
		}
		return inst;
	}

	/**
	 * Gets the message from key.
	 * 
	 * @param key
	 *            the key
	 * @return the message
	 */
	public String getMessage(final String key) {
		String str = "";
		try {
			str = bundle.getString(key);
			System.out.println("Config Entry Key = " + key + " Val = " + str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

}
