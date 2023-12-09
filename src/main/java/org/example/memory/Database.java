package org.example.memory;

import org.example.animals.abstractAnimals.Animal;

import java.util.ArrayList;

public interface Database {
    ArrayList<Animal> getAllAnimals();
    Animal getAnimalById(int animalId);
    boolean addAnimal(Animal animal);
}
