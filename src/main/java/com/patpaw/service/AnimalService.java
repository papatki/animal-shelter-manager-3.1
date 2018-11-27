package com.patpaw.service;

import com.patpaw.model.Animal;

import java.util.List;

public interface AnimalService {

    Animal save(Animal newAnimal);

    List<Animal> findAll();

    Animal findById(long id);

    void delete(Animal animalToDelete);

}
