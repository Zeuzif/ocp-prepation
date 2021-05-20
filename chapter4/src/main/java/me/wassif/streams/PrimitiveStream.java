package me.wassif.streams;

import java.util.stream.DoubleStream;

public class PrimitiveStream {
	public static void main(String[] args) {
		DoubleStream fractions = DoubleStream.iterate(.5, (x) -> x / 2);
		fractions.limit(6).forEach(System.out::println);
	}
}
