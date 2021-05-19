package me.wassif.streams.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermidiateOps {
	public static void main(String[] args) {
		flatMap();
	}

	private static void flatMap() {
		List<String> zero = Arrays.asList();
		List<String> one = Arrays.asList("element1");
		List<String> two = Arrays.asList("element2", "element3");
		Stream<String> stream = Stream.of(zero, one, two).flatMap(list -> list.stream());
		stream.forEach(System.out::println);
	}
}
