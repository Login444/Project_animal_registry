package org.example.animals;

import java.util.Objects;

public record Comand(String name, String description) {
    public Comand(String name) {
        this(name,null);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comand comand = (Comand) o;
        return name.equals(comand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
