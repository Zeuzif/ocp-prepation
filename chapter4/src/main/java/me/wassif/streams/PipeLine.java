package me.wassif.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PipeLine {
	public static void main(String[] args) {
		List<String> filtred = Stream.of("Toby", "Anna", "Leroy", "Alex").filter(str -> str.length() == 4).limit(2)
				.sorted()
				.collect(Collectors.toList());
		System.out.println(filtred);
	}
}
