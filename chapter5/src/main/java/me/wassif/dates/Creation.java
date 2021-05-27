package me.wassif.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class Creation {
	public static void main(String[] args) {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
		// local date
		System.out.println(LocalDate.of(2021, 05, 25));
		System.out.println(LocalDate.of(2021, Month.MAY, 25));
		// you can choose how specific is your time
		System.out.println(LocalTime.of(18, 54));
		System.out.println(LocalTime.of(18, 55, 01));
		System.out.println(LocalTime.of(18, 54, 55, 2));
		//
		System.out.println(LocalDateTime.of(2021, Month.MAY, 25, 18, 55, 02, 555));
		// zoned
		ZoneId zone = ZoneId.of("US/Eastern");
		System.out.println(ZonedDateTime.of(LocalDate.of(2021, 05, 25), LocalTime.of(19, 02), zone));
		// how to find a zone ?
		ZoneId.getAvailableZoneIds().stream().filter((z) -> z.contains("US")).forEach(System.out::println);
		// old way for creating a date
		Calendar calendar = Calendar.getInstance();
		calendar.set(2021, Calendar.MAY, 27);
		Date date = calendar.getTime();
		System.out.println("old way date : " + date);
	}
}
