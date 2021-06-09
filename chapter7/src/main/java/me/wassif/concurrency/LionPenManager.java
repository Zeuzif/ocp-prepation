package me.wassif.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager {
	private void removeLion() {
		System.out.println("Removing animal " + Thread.currentThread().getName());
	}

	private void cleanCage() {
		System.out.println("cleaning cage " + Thread.currentThread().getName());
	}

	private void retunrAnimal() {
		System.out.println("returning animal " + Thread.currentThread().getName());
	}

	public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
		removeLion();
		try {
			c1.await();
			cleanCage();
			c2.await();
			retunrAnimal();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		LionPenManager lionPenManager = new LionPenManager();
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4);
			CyclicBarrier c1 = new CyclicBarrier(4);
			CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("Pens cleaned !"));
			for (int i = 0; i < 4; i++) {
				service.submit(() -> {
					lionPenManager.performTask(c1, c2);
				});
			}
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}
		
	}
}
