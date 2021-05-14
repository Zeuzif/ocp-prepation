package me.wassif.streams.generate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Generation {
	public static void main(String[] args) {
		Stream<String> emptyStm = Stream.empty();
		Stream<Integer> stmFromArray = Stream.of(1, 2, 3);
		// create from list
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		Stream<Integer> streamFromList = numbers.stream();
		Stream<Integer> parallelStreamFromList = numbers.parallelStream();
		// infinite stream
		Stream<Double> inf = Stream.generate(Math::random);
		System.out.println(inf);
		Stream<Integer> itr = Stream.iterate(1, n -> n + 1);
		System.out.println(itr);
	}
}
