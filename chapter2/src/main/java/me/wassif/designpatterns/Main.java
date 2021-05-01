package me.wassif.designpatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

/*
 * builder
 */
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

class AnimalBuilder {
    private String species;
    private List<String> favoriteFoods;

    public AnimalBuilder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public AnimalBuilder setFavoriteFoods(List<String> foods) {
        this.favoriteFoods = foods;
        return this;
    }

    public Animal build() {
        return new Animal(species, favoriteFoods);
    }
}

public class Main {
    public static void main(String[] args) {
        DonkeysFactory factory = DonkeysFactory.getInstance();
        factory.toString();
        Animal animal = new AnimalBuilder()
                .setFavoriteFoods(Arrays.asList("br", "tr"))
                .setSpecies("tornado").build();
        animal.toString();
    }
}
