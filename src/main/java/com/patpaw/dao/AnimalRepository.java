package com.patpaw.dao;

import com.patpaw.model.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AnimalRepository extends MongoRepository<Animal,String> {

}
