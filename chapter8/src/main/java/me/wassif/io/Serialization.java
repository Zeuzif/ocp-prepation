package me.wassif.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Animal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private String name;
	private int weight;
	private transient String spacies = "UNKNOWN";
	{
		spacies = "INIT BLOCK UNKNOWN";
	}

	public Animal(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
		this.spacies = "CONSTRUCTOR UNKNOWN";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getSpacies() {
		return spacies;
	}

	public void setSpacies(String spacies) {
		this.spacies = spacies;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", weight=" + weight + ", spacies=" + spacies + "]";
	}
}

public class Serialization {
	public static void main(String[] args) throws IOException {
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Tommy Tiger", 5));
		animals.add(new Animal("Peter Penguin", 8));
		File file = new File("chapter8/src/main/resources/animals");
		if (file.exists()) {
			file.createNewFile();
		}
		writeAnimals(animals, new File("chapter8/src/main/resources/animals"));
		getAnimals(file).stream().forEach(System.out::println);
	}

	public static void writeAnimals(List<Animal> animals, File to) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(to)))) {
			for (Animal animal : animals) {
				oos.writeObject(animal);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Animal> getAnimals(File from) {
		List<Animal> animals = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(from)))) {
			while (true) {
				Object object = ois.readObject();
				if (object instanceof Animal) {
					animals.add((Animal) object);
				}
			}
		} catch (EOFException e) {
			// nothing to do :)
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return animals;
	}
}
