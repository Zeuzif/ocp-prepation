package me.wassif.dates;

import java.time.LocalDate;
import java.time.Period;

public class PeriodN {
	public static void main(String[] args) {
		LocalDate start = LocalDate.now();
		LocalDate end = start.plusMonths(2);
		Period period = Period.ofWeeks(1);
		switchElements(start, end, period);
		// printing period
		System.out.println(Period.of(1, 1, 1));
	}
	
	private static void switchElements(LocalDate start, LocalDate end, Period period) {
		while(start.isBefore(end)) {
			System.out.println("switching elements...");
			start = start.plus(period);
		}
	}
}
