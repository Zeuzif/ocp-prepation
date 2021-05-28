package me.wassif.localization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormatNumber {
	public static void main(String[] args) throws ParseException {
		NumberFormat usFormat = NumberFormat.getInstance(Locale.ENGLISH);
		NumberFormat canadaFormat = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		NumberFormat germanyFormat = NumberFormat.getInstance(Locale.GERMANY);
		// formats
		double number = 3_333_333.33;
		System.out.println(usFormat.format(number));
		System.out.println(canadaFormat.format(number));
		System.out.println(germanyFormat.format(number));
		//currency
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println(currency.format(33.5)); // 33,50 €
		// parsing
		NumberFormat en = NumberFormat.getInstance(Locale.US);
		NumberFormat fr = NumberFormat.getInstance(Locale.FRANCE);
		String price = "40.5";
		System.out.println(en.parse(price));
		System.out.println(fr.parse(price));
	}
}
