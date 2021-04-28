package me.wassif.accessmodifiers.mouse;

import me.wassif.accessmodifiers.cat.BigCat;

public class Mouse {
	public static void main(String[] args) {
		BigCat cat = new BigCat();
		/*
		 * only public can be accessed in other package.
		 */
		System.out.printf("name = %s, hasFur = %b, hasPaws = %b, id = %d", cat.name);
	}
}
