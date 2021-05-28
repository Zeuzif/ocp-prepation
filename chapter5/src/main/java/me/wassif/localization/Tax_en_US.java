package me.wassif.localization;

import java.text.MessageFormat;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Tax_en_US extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] { { "hello", "hello {0}" }, { "tax", new Tax() } };
	}

	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("me.wassif.localization.Tax", Locale.US);
		String hello = bundle.getString("hello");
		String formattedHello = MessageFormat.format(hello, "Java");
		System.out.println(formattedHello);
		Object tax = bundle.getObject("tax");
		System.out.println(tax);
	}
}

class Tax {
	@Override
	public String toString() {
		return "tax object...";
	}
}