package me.wassif.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class SheepManager {
	private int sheepCount;
	private AtomicInteger sheepCountTS = new AtomicInteger();

	public void incrementAndReportNTS() {
		// not thread safe
		System.out.printf("%d ", ++sheepCount);
	}

	public void incrementAndReportTS() {
		synchronized (this) {
			System.out.printf("%d ", sheepCountTS.incrementAndGet());
		}
	}
}

public class DataAccess {
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(50);
			SheepManager manager = new SheepManager();
			System.out.println("Not thread safe");
			for (int i = 0; i < 10; i++) {
				service.submit(() -> manager.incrementAndReportNTS());
			}
			System.out.println("\nThread safe");
			for (int i = 0; i < 10; i++) {
				service.submit(() -> manager.incrementAndReportTS());
			}
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
