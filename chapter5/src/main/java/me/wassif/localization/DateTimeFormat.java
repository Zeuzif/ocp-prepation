package me.wassif.localization;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormat {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2021, 5, 28);
		LocalTime time = LocalTime.of(15, 04);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(time.format(DateTimeFormatter.ISO_TIME));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
		//
		DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT);
		System.out.println("dateTime " + dateTime.format(shortDateTime));
		System.out.println(
				"date " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		System.out.println("time " + time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
	}
}
