package me.wassif.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ItemProcessor {
	int process(int x) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ++x;
	}
}

public class ParallelStreams {
	static ItemProcessor itemProcessor = new ItemProcessor();

	public static void main(String[] args) {
		creatingParallelStreams();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10000000; i++) {
			list.add(i);
		}
		processAllData(list);
		processAllDataInParallel(list);
		System.out.println(usingParallelReductions(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}

	private static Integer usingParallelReductions(List<Integer> list) {
		return list.parallelStream().reduce(0, (a, b) -> a - b);
	}

	private static void processAllData(List<Integer> items) {
		long start = System.currentTimeMillis();
		items.stream().map(itemProcessor::process).count();
		double time = (System.currentTimeMillis() - start) / 1000.0;
		System.out.println("Tasks completed in: " + time + " seconds");
	}

	private static void processAllDataInParallel(List<Integer> items) {
		long start = System.currentTimeMillis();
		items.parallelStream().map(itemProcessor::process).count();
		double time = (System.currentTimeMillis() - start) / 1000.0;
		System.out.println("Parallel tasks completed in: " + time + " seconds");
	}

	private static void creatingParallelStreams() {
		// to create parallel stream
		Stream.of(1, 2, 3).parallel();
		// from a collection
		Arrays.asList(1, 2, 3).parallelStream();
	}
}
