package me.wassif.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetImplementation {
	public static void main(String[] args) {
		// O(1) search // O(1) insert
		// we loose to order
		Person[] personsArray = { new Person("123HR89"), new Person("1563HR89"), new Person("123HR56"),
				new Person("123HR89") };
		// we should implement hashCode function
		Set<Person> persons = new HashSet<>(Arrays.asList(personsArray));
		System.out.println(persons);

		// O(log) for search O(log) for insert
		// ordered elements
		Set<Animal> animals = new TreeSet<>();
		animals.add(new Animal("zebra"));
		animals.add(new Animal("Monkey"));
		System.out.println(animals);

	}
}

class Person {
	private String id;

	public Person(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + "]";
	}
}

class Animal implements Comparable<Animal>{
	private String name;

	public Animal(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}

	@Override
	public int compareTo(Animal o) {
		if(this == o) return 0;
		return name.compareTo(o.name);
	}
}