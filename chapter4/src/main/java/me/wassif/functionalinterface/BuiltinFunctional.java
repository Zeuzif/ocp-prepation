package me.wassif.functionalinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BuiltinFunctional {
	public static void main(String[] args) {
		Map<Integer, String> words = new HashMap<>();
		BiConsumer<Integer, String> consumer = words::put;
		System.out.println(consumer);
		consumer.accept(1, "word");
		System.out.println(words);
	}
}
