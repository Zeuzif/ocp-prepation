package me.wassif.concurrency;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class SheduleTask {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// usingScheduled();
		// usingScheculedAtFixedDelay();
		usingScheculedAtFixedRate();
	}


	private static void usingScheculedAtFixedDelay() {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(() -> System.out.println("Hello world"), 1, 10, TimeUnit.SECONDS);
	}

	private static void usingScheculedAtFixedRate() {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleWithFixedDelay(() -> System.out.println("hello executor"), 0, 2, TimeUnit.SECONDS);
	}

	private static void usingScheduled() throws InterruptedException, ExecutionException {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		Future<?> result = service.schedule(() -> {
			System.out.println("Salut");
			return 12;
		}, 10, TimeUnit.SECONDS);
		System.out.println(result.get());
		service.shutdown();
	}
}
