package org.example.controller;

import org.example.animals.abstractAnimals.Animal;
import org.example.animals.abstractAnimals.AnimalType;
import org.example.animals.animalTypes.*;
import org.example.memory.Database;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    private Database storage;
    public Controller(Database info){
        this.storage = info;
    }

    public ArrayList<Animal> getAnimals(){
        return storage.getAllAnimals();
    }
    public boolean createAnimal(String name, LocalDate day_of_birth, AnimalType animalType){
        Animal animal = switch (animalType){
            case CATS -> new Cats(name, day_of_birth);
            case DOGS -> new Dogs(name, day_of_birth);
            case HAMSTERS -> new Hamsters(name, day_of_birth);
            case HORSES -> new Horses(name, day_of_birth);
            case DONKEYS -> new Donkeys(name, day_of_birth);
            case CAMELS -> new Camels(name, day_of_birth);
        };
        return storage.addAnimal(animal);
    }
}
