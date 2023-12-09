package org.example.animals.abstractAnimals;

import java.time.LocalDate;

public abstract class Pets extends Animal {
    public Pets(String name, LocalDate date_of_birth) {
        super(name, date_of_birth);
    }
}
