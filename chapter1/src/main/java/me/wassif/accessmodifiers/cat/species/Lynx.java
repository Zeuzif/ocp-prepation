package me.wassif.accessmodifiers.cat.species;

import me.wassif.accessmodifiers.cat.BigCat;

public class Lynx extends BigCat {
	public static void main(String[] args) {
		BigCat cat = new BigCat();
		/*
		 * hasFur is protected but we cannot access it here
		 * because it is accessed by variable not inheritance.
		 */
		System.out.printf("name = %s", cat.name);
	}
}
