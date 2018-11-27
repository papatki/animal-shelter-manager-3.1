package com.patpaw.service;

import com.patpaw.dao.AnimalRepository;
import com.patpaw.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalRepository;


    @Override
    public Animal save(Animal newAnimal) {
        return animalRepository.save(newAnimal);
    }

    @Override
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }


    @Override
    public Animal findById(long id) {
        return animalRepository.findById(id);
    }

    @Override
    public void delete(Animal animalToDelete) {
        animalRepository.delete(animalToDelete);
    }
}
