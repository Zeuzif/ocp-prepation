package me.wassif.functionalprogramming.impl;

import java.util.function.Predicate;

@FunctionalInterface
interface CheckTrait {
    boolean test(Animal animal);
}

class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String speciesName, boolean hopper, boolean swimmer) {
        species = speciesName;
        canHop = hopper;
        canSwim = swimmer;
    }

    public boolean canHop() {
        return canHop;
    }

    public boolean canSwim() {
        return canSwim;
    }

    public String toString() {
        return species;
    }
}

public class FindMatchingAnimals {
    // Deferred execution means function appeal will be determined at runtime
    public static void print(Animal animal, CheckTrait trait) {
        if (trait.test(animal))
            System.out.println(animal);
    }

    public static void print(Animal animal, Predicate<Animal> predicate) {
        if (predicate.test(animal)) {
            System.out.println(animal);
        }
    }

    /*
     * TODO downcast with lambda expressions Stackoverflow
     */
    // we should resolve ambiguity
    public static void main(String[] args) {
        Animal tornado = new Animal("tornado", true, true);
        // colon is not required (one statement)
        CheckTrait trait = animal -> animal.canHop() && animal.canSwim();
        print(tornado, trait);
        Animal crazyFrog = new Animal("frog", true, false);
        Predicate<Animal> predicate = (Animal animal) -> {
            if (animal.canHop() && !animal.canSwim())
                return true;
            return false;
        };
        print(crazyFrog, predicate);
    }
}