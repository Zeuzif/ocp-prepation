package me.wassif.designpatterns;

/*
 * double‐checked locking singleton.
 */
class DonkeysFactory {
	private static volatile DonkeysFactory instance;

	private DonkeysFactory() {
	}

	public static DonkeysFactory getInstance() {
		if (instance == null) {
			synchronized (DonkeysFactory.class) {
				instance = new DonkeysFactory();
			}
		}
		return instance;
	}
}

public class Main {
	public static void main(String[] args) {
		DonkeysFactory factory = DonkeysFactory.getInstance();
		factory.toString();
	}
}
