package me.wassif.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExcutorExamples {
	public static int count = 0;

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		usingThread();
		usingExecutor();
		usingExecutorWithCallable();
	}

	private static void usingThread() {
		new Thread(() -> {
			while (count < 10) {
				ExcutorExamples.count++;
				System.out.println("count from thread : " + count);
			}
		}).start();
		while (count < 10) {
			System.out.println("count from main thread : " + count);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Reached with thread");
	}

	private static void usingExecutor() {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> result = service.submit(() -> {
				while (count < 10) {
					ExcutorExamples.count++;
				}
			});
			result.get(10, TimeUnit.SECONDS);
			System.out.println("Reached");
			if (service != null)
				service.shutdown();
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Not reached");
		} finally {
			if(service != null) {
				service.shutdown();
			}
		}
	}

	private static void usingExecutorWithCallable() {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> result = service.submit(() -> {
				while (count < 10) {
					ExcutorExamples.count++;
				}
				return count;
			});
			Integer count = result.get(10, TimeUnit.SECONDS);
			System.out.println("Reached with count = " + count);
			if (service != null)
				service.shutdown();
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Not reached");
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}
	}
}
