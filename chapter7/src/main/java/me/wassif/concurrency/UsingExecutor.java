package me.wassif.concurrency;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsingExecutor {
	public static void main(String[] args) throws InterruptedException {
		Instant begin = Instant.now();
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			service.execute(() -> {
				for (int i = 0; i < 2; i++) {
					System.out.println("Printin record" + i);
				}
			});
			service.execute(() -> System.out.println("Printing inventory"));

		} finally {
			if (service != null)
				service.shutdown();
		}
		if (service != null) {
			service.awaitTermination(1, TimeUnit.SECONDS);
			if (service.isTerminated()) {
				System.out.println("All tasks are terminated");
			} else {
				System.out.println("At least one task is still running");
			}
		}
		Instant end = Instant.now();
		System.out.println("Program was executed in : " + Duration.between(begin, end).get(ChronoUnit.NANOS));
	}
}
