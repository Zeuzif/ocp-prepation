package me.wassif.io;

import java.io.Console;

public class InteractWithUser {
	public static void main(String[] args) {
		Console console = System.console();
		if (console != null) {
			String emailAdress = console.readLine("enter your email adress : ");
			System.out.println(emailAdress);
		} else {
			System.out.println("are you ok ?");
		}
	}
}
