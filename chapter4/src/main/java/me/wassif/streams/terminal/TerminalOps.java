package me.wassif.streams.terminal;

import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOps {
	public static void main(String[] args) {
		// count
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
	}
}
