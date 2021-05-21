package me.wassif.streams;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStream {
	public static void main(String[] args) {
		DoubleStream fractions = DoubleStream.iterate(.5, (x) -> x / 2);
		fractions.limit(6).forEach(System.out::println);
		// map between types of streams
		Stream<String> words = Stream.of("a", "ab", "abc");
		IntStream lenghts = words.mapToInt((str) -> str.length());
		lenghts.mapToObj(intos -> intos + "").collect(Collectors.joining(" "));
		// average
		IntStream marks = IntStream.range(2, 15);
		OptionalDouble result = marks.average();
		double res = result.orElseGet(() -> Double.NaN);
		System.out.println(res);
		// chaining optionals
		Optional<String> strOpt = Optional.empty();
		Optional<Integer> intOpt = strOpt.flatMap(PrimitiveStream::calculate);
		intOpt.ifPresent(x -> System.out.println(x));
	}

	private static Optional<Integer> calculate(String str) {
		return str == null ? Optional.empty() : Optional.of(str.length());
	}
}
