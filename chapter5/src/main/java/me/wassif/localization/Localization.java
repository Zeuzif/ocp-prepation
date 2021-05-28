package me.wassif.localization;

import java.util.Locale;

public class Localization {
	public static void main(String[] args) {
		Locale local = Locale.getDefault();
		// language_COUNTRY lowercase/uppercase
		System.out.println(local); // fr_FR
		// to create a locale
		Locale germain = Locale.GERMAN;
		System.out.println(germain);
		Locale morocco = new Locale.Builder().setLanguage("ar").setRegion("US").build();
		System.out.println(morocco);
	}
}
