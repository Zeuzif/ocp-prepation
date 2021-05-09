package me.wassif.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Squirrel {
	int weight;
	String species;

	public Squirrel(int weight, String species) {
		super();
		this.weight = weight;
		this.species = species;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public String toString() {
		return "Squirrel [weight=" + weight + ", species=" + species + "]";
	}
}

public class MultipleFieldsComparing {
	public static void main(String[] args) {
		Comparator<Squirrel> comparator = (Squirrel s1, Squirrel s2) -> {
			Comparator<Squirrel> comp = Comparator.comparing(s -> s.species);
			comp.thenComparing(s -> s.weight);
			return comp.compare(s1, s2);
		};

		Squirrel s1 = new Squirrel(10, "Pile");
		Squirrel s2 = new Squirrel(5, "Poil");
		List<Squirrel> squirrels = new ArrayList<>();
		squirrels.add(s1);
		squirrels.add(s2);

		squirrels.sort(comparator);
		System.out.println(squirrels);
	}
}
