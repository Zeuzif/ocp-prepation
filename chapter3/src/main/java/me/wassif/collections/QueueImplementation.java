package me.wassif.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueImplementation {
	public static void main(String[] args) {
		Queue<Integer> deQueue = new ArrayDeque<>();
		deQueue.add(4);
		deQueue.add(5);
		deQueue.offer(10);
		((ArrayDeque<Integer>) deQueue).push(0);
		System.out.println(deQueue);
		System.out.println(deQueue.peek());
		System.out.println(deQueue.poll());
		((ArrayDeque<Integer>) deQueue).pop();
		System.out.println(deQueue);
	}
}
