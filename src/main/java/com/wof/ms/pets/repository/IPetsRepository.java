package com.wof.ms.pets.repository;

import com.wof.ms.pets.model.Pet;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPetsRepository extends MongoRepository<Pet, String> {
  List<Pet> findByOwnerId(Integer id);
}
