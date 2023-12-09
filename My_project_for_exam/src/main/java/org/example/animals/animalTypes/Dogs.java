package org.example.animals.animalTypes;

import org.example.animals.abstractAnimals.AnimalType;
import org.example.animals.abstractAnimals.Pets;

import java.time.LocalDate;

public class Dogs extends Pets {
    public Dogs(String name, LocalDate date_of_birth) {
        super(name, date_of_birth);
        setAnimalType(AnimalType.DOGS);
    }
}
