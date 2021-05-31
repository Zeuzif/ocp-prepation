package me.wassif.assertions;

enum Season {
	SUMMER {
		@Override
		void print() {
			System.out.println("Long hours");
		}
	},
	SPRING, FALL;
	
	void print() {
		System.out.println("Short hours");
	}
}

class TestSeason {
	public static void test(Season season) {
		switch (season) {
		case SPRING:
		case FALL:
		case SUMMER:
			season.print();
			break;
		default:
			// unreachable code
			assert false : "invalid season";
		}
	}
}

public class ControlFlowInvariants {
	public static void main(String[] args) {
		TestSeason.test(Season.SUMMER);
	}
}
