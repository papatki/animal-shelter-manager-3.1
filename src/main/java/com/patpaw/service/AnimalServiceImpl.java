package com.patpaw.service;

import com.patpaw.dao.AnimalRepository;
import com.patpaw.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Override
    public Animal saveOrUpdate(Animal newAnimal) {
        animalRepository.save(newAnimal);
        return newAnimal;
    }

    @Override
    public List<Animal> findAll() {
        List<Animal> animals = new ArrayList<>();
        animalRepository.findAll().forEach(animals::add);
        return animals;
    }

    @Override
    public Animal getById(String id) {
        return animalRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        animalRepository.deleteById(id);
    }

    @Override
    public void insert(Animal animal) {
        animalRepository.insert(animal);
    }
}
