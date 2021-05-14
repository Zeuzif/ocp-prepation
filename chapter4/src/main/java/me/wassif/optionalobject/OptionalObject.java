package me.wassif.optionalobject;

import java.util.Optional;

public class OptionalObject {
	public static void main(String[] args) {
		// how to get optional ?
		Optional<Float> avrOpt = average(30, 40, 50);
		// bad idea
		avrOpt.get(); // can raise exception
		// good
		if (avrOpt.isPresent())
			System.out.println(avrOpt.get());

		// or to get optional
		float average1 = average(80, 90).orElse(0f);
		System.out.println(average1);
		float average2 = average().orElse(0f);
		System.out.println(average2);
	}

	static Optional<Float> average(int... scores) {
		int count = 0;
		for (int i : scores) {
			count += i;
		}
		return scores.length == 0 ? Optional.empty() : Optional.of((float) count / (scores.length));
	}
}
