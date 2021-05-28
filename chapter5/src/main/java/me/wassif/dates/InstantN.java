package me.wassif.dates;

import java.time.Duration;
import java.time.Instant;

public class InstantN {
	public static void main(String[] args) throws InterruptedException {
		Instant start = Instant.now();
		System.out.println(Instant.now());
		System.out.println("processing...");
		Thread.sleep(200);
		System.out.println(Instant.ofEpochSecond(100000000));
		// Epoch : 1970-01-01T00:00:00Z
		System.out.println(Instant.EPOCH);
		Instant end = Instant.now();
		System.out.println("processing time : " + Duration.between(start, end).toMillis());
	}
}
