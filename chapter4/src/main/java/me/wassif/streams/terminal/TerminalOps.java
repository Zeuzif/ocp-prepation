package me.wassif.streams.terminal;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
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
}
