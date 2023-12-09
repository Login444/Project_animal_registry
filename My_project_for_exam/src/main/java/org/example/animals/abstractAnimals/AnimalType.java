package org.example.animals.abstractAnimals;

public enum AnimalType {
    DOGS ("dogs"),
    CATS ("cats"),
    HAMSTERS ("hamsters"),
    HORSES ("horses"),
    DONKEYS ("donkeys"),
    CAMELS ("camels");

    private String title;
    AnimalType(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
