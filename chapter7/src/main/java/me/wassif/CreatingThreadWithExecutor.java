package me.wassif;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreatingThreadWithExecutor {
	public static void main(String[] args) {
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
			Instant end = Instant.now();
			System.out.println("Program was executed in : " + Duration.between(begin, end).get(ChronoUnit.NANOS));
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
