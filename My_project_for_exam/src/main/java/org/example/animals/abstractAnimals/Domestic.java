package org.example.animals.abstractAnimals;

import java.time.LocalDate;

public abstract class Domestic extends Animal {
    public Domestic(String name, LocalDate date_of_birth) {
        super(name, date_of_birth);
    }
}
