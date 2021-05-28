package me.wassif.localization;

import java.util.Locale;
import java.util.Properties;

public class ResourceBundle {
	public static void main(String[] args) {
		Locale us = new Locale("en", "US");
		Locale france = new Locale("fr", "FR");
		// english
		printPropeties(us);
		// french
		printPropeties(france);
		//convert from ressource bundle to properties
		java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("Zoo");
		Properties properties = new Properties();
		rb.keySet().stream().forEach(key -> properties.put(key, rb.getString(key)));
		System.out.println(properties.getProperty("server", "propertie server not found"));
	}

	private static void printPropeties(Locale local) {
		java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Zoo", local);
		System.out.println(bundle.getString("hello"));
		System.out.println(bundle.getString("open"));
	}
}
