package com.patpaw.service;

import com.patpaw.model.Animal;

import java.util.List;

public interface AnimalService {

    Animal saveOrUpdate(Animal newAnimal);

    List<Animal> findAll();

    Animal getById(String id);

    void delete(String id);

    void insert(Animal animal);

}
