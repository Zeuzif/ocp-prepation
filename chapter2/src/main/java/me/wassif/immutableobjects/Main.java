package me.wassif.immutableobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Animal {
	private String species;
	private List<String> favoriteFoods;

	public Animal(String species, List<String> favoriteFoods) {
		this.species = species;
		if (favoriteFoods == null) {
			throw new RuntimeException("Favorite foods are required");
		}
		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
	}

	public String getSpecies() {
		return species;
	}

	public String getFavoriteFood(int index) {
		return favoriteFoods.get(index);
	}
}

public class Main {

	public static void main(String[] args) {
		List<String> foods = Arrays.asList("br", "fr", "tr");
		Animal animal = new Animal("tornado", foods);
		System.out.println(animal.getFavoriteFood(0));
	}

}
