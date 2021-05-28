package me.wassif.dates;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationN {
	public static void main(String[] args) {
		LocalTime time = LocalTime.of(1, 15);
		System.out.println(time);
		Duration duration = Duration.ofMinutes(90);
		LocalTime time2 = time.plus(duration);
		System.out.println(time2);
		System.out.println(ChronoUnit.HOURS.between(time, time2));
	}
}
