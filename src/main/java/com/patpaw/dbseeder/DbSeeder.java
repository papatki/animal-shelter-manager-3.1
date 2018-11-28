package com.patpaw.dbseeder;

import com.patpaw.dao.AnimalRepository;
import com.patpaw.model.Animal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private AnimalRepository animalRepository;

    public DbSeeder(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Animal animal1 = new Animal("Bob", "dog", "Super friendly.");
        Animal animal2 = new Animal("Rex", "dog", "Old, but nice");
        Animal animal3 = new Animal("Snowy", "cat", "Lazy, but fluffy.");

        this.animalRepository.findAll();

        List<Animal> animals = Arrays.asList(animal1, animal2, animal3);
        this.animalRepository.saveAll(animals);

    }
}
