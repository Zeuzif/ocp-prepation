package me.wassif.streams.terminal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
	public static void main(String[] args) {
		// count
		@SuppressWarnings("unused")
		Stream<Integer> infInt = Stream.iterate(1, n -> n + 1);
		// long count = infInt.count();
		// System.out.println(count); // print nothing
		// min max
		Stream<Integer> integers = Stream.of(1, 2, 3);
		Optional<Integer> max = integers.max((a, b) -> a - b);
		System.out.println(max.orElse(-1));
		// findFirst and findAny
		Stream<Double> randoms = Stream.generate(Math::random);
		Optional<Double> first = randoms.findFirst();
		System.out.println(first.get());
		Stream<Double> streamAny = Stream.generate(Math::random);
		Optional<Double> any = streamAny.findAny();
		System.out.println(any.get());
		// test reduce terminal op
		reduce1();
		// test collect
		collect1();
		// using collector
		collect2();
		// using to map
		toMap();
		toMap2();
		// using group
		group();
		// using partition
		partitioning();
	}

	// take binary operator
	// mutable reduction
	private static void reduce1() {
		Stream<String> letters = Stream.of("w", "a", "s", "s", "i", "f");
		String word = letters.peek(System.out::println).reduce("", String::concat);
		System.out.println(word);
	}

	// immutable collection
	private static void collect1() {
		Stream<String> letters = Stream.of("w", "a", "s", "s", "i", "f");
		Set<String> set = letters.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println(set);
	}

	private static void collect2() {
		Stream<String> letters = Stream.of("w", "a", "s", "s", "i", "f");
		Set<String> set = letters.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set);
	}

	private static void toMap() {
		Stream<String> animals = Stream.of("Lion","Donkey","Monkey");
		Map<String, Integer> map = animals.collect(Collectors.toMap(Function.identity(), String::length));
		map.forEach((k, v) -> System.out.println(k + " = " + v));
	}

	public static void toMap2() {
		Stream<String> animals = Stream.of("Lion","Donkey","Monkey");
		Map<Integer, String> map = animals
				.collect(Collectors.toMap(String::length, Function.identity(), (s1, s2) -> String.join(",", s1, s2),
						HashMap::new));
		map.forEach((k, v) -> System.out.println(k + " = " + v));
	}

	public static void group() {
		Stream<String> animals = Stream.of("Lion", "Donkey", "Monkey");
		Map<Integer, List<String>> map = animals.collect(Collectors.groupingBy(String::length));
		System.out.println(map);
	}

	public static void partitioning() {
		Stream<String> animals = Stream.of("Lion", "Donkey", "Monkey");
		Map<Boolean, List<String>> map = animals.collect(Collectors.partitioningBy(animal -> animal.endsWith("key")));
		System.out.println(map);
	}
}
