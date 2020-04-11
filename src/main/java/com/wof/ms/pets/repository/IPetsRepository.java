package com.wof.ms.pets.repository;

import com.wof.ms.pets.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPetsRepository extends MongoRepository<Pet, String> {

}
