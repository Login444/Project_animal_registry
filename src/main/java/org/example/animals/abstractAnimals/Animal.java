package org.example.animals.abstractAnimals;

import org.example.animals.Comand;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private static int counter;
    private final int id = ++counter;
    private String name;
    private LocalDate date_of_birth;
    private final List<Comand> comands;
    private AnimalType animalType;


    public Animal(String name, LocalDate date_of_birth) {
        this.name = name;
        this.date_of_birth = date_of_birth;
        comands = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getComands() {
        return comands.toString();
    }

    public void setComands(Comand comand) {
        this.comands.add(comand);
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public String getBirthDateAsString() {
        return String.format("%02d-%02d-%4d", date_of_birth.getDayOfMonth(), date_of_birth.getMonthValue(),
                date_of_birth.getYear());
    }
    public int getAge() {
        int years = Period.between(date_of_birth, LocalDate.now()).getYears();
        int months = Period.between(date_of_birth, LocalDate.now()).getMonths();
        return years * 12 + months;
    }

    public boolean learnComand(Comand newComand) {
        if (comands.contains(newComand)){
            return false;
        }
        comands.add(newComand);
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
