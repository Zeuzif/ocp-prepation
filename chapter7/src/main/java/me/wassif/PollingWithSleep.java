package me.wassif;

import java.time.Duration;
import java.time.Instant;

public class PollingWithSleep {
	public static int count = 0;
	public static void main(String[] args) {
		Instant begin = Instant.now();
		new Thread(() -> PollingWithSleep.count++).start();
		while (count < 10) {
			System.out.println("Not reached yet");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("reached");
		Instant end = Instant.now();
		System.out.println("Program was executed in : " + Duration.between(begin, end).getSeconds());
	}
}
