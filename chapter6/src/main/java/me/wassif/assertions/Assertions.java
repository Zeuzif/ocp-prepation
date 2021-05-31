package me.wassif.assertions;

public class Assertions {
	public static void main(String[] args) {
		int solde = -123;
		int transaction = 100;
		assert solde - transaction > 0 : "invalid transaction";
		System.out.println(solde - transaction);
	}
}
