package org.example.memory;

import org.example.animals.abstractAnimals.Animal;
import org.example.memory.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DbAnimals implements Database {
    Map<Integer, Animal> dbAnimals = new HashMap<>();
    @Override
    public ArrayList<Animal> getAllAnimals() {
        ArrayList<Animal> res = new ArrayList<>();
        for (Animal animal: dbAnimals.values()){
            res.add(animal);
        }
        return res;
    }

    @Override
    public Animal getAnimalById(int animalId) {
        return dbAnimals.getOrDefault(animalId, null);
    }

    @Override
    public boolean addAnimal(Animal animal) {
        if (dbAnimals.containsKey(animal.getId())){
            return false;
        }
        dbAnimals.put(animal.getId(), animal);
        return true;
    }
}
