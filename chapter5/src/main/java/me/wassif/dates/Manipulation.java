package me.wassif.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Manipulation {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		date = date.plusDays(2);
		System.out.println(date);
		date = date.plusWeeks(2);
		System.out.println(date);
		// manipulating localdatetime
		LocalDateTime dateTime = LocalDateTime.now();
		dateTime = dateTime.plusDays(1).minusHours(1).plusSeconds(30);
		System.out.println(dateTime);
	}
}
