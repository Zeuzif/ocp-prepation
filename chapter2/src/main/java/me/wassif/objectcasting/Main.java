package me.wassif.objectcasting;

class Flying {
}

class Bird extends Flying {
}

public class Main {

	public static void main(String[] args) {
		Flying flying = new Flying();
		Bird bird = (Bird) flying; // class cast exception java.lang.ClassCastException
		bird.toString();
	}

}
