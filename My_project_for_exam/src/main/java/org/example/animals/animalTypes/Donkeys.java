package org.example.animals.animalTypes;

import org.example.animals.abstractAnimals.AnimalType;
import org.example.animals.abstractAnimals.Domestic;

import java.time.LocalDate;

public class Donkeys extends Domestic {
    public Donkeys(String name, LocalDate date_of_birth) {
        super(name, date_of_birth);
        setAnimalType(AnimalType.DONKEYS);
    }
}
