package me.wassif.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

class WeighAnimalAction extends RecursiveAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7464935001777839057L;
	int start, end;
	Double[] wieghts;

	public WeighAnimalAction(int start, int end, Double[] wieghts) {
		super();
		this.start = start;
		this.end = end;
		this.wieghts = wieghts;
	}

	@Override
	protected void compute() {
		if (end - start <= 3) {
			for (int i = start; i < end; i++) {
				wieghts[i] = (new Random().nextDouble()) * 100;
			}
		} else {
			int middle = start + (end - start) / 2;
			System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
			invokeAll(new WeighAnimalAction(start, middle, wieghts), new WeighAnimalAction(middle, end, wieghts));
		}
	}
}

class WeighAnimalAndReturnTheSum extends RecursiveTask<Double> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1974352306380807548L;
	int start, end;
	Double[] weights;

	public WeighAnimalAndReturnTheSum(int start, int end, Double[] weights) {
		super();
		this.start = start;
		this.end = end;
		this.weights = weights;
	}

	@Override
	protected Double compute() {
		if (end - start <= 3) {
			double sum = 0;
			for (int i = start; i < end; i++) {
				weights[i] = (new Random().nextDouble()) * 100;
				sum += weights[i];
			}
			return sum;
		} else {
			int middle = start + (end - start) / 2;
			RecursiveTask<Double> otherTask = new WeighAnimalAndReturnTheSum(start, middle, weights);
			otherTask.fork();
			return new WeighAnimalAndReturnTheSum(middle, end, weights).compute() + otherTask.join();
		}
	}
}

public class ForkJoinAction {
	public static void main(String[] args) {
		// Using RecursiveAction
		Double[] weights = new Double[10];
		ForkJoinTask<?> action = new WeighAnimalAction(0, weights.length, weights);
		ForkJoinPool pool1 = new ForkJoinPool();
		pool1.invoke(action);
		System.out.print("Weights: ");
		Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue() + " "));
		// Using Recursive Task
		ForkJoinTask<Double> task = new WeighAnimalAndReturnTheSum(0, weights.length, weights);
		ForkJoinPool pool2 = new ForkJoinPool();
		Double sum = pool2.invoke(task);
		System.out.print("\nWeights: ");
		Arrays.asList(weights).stream().forEach(d -> System.out.printf("%.2f ", d));
		System.out.printf("\nWeights sum : %.2f", sum);
	}
}
