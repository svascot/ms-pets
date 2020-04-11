package com.wof.ms.pets.domain;

import com.wof.ms.pets.model.Pet;
import com.wof.ms.pets.repository.IPetsRepository;
import com.wof.ms.pets.domain.interfaces.IPetsService;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetsService implements IPetsService {

  @Autowired
  private IPetsRepository repository;

  @Override
  public List<Pet> getAll(){
    return repository.findAll();
  }

  @Override
  public Pet get(String id){
    return repository.findById(id).get();
  }

  @Override
  public Pet create(Pet pet){
    pet.setId(pet.getOwnerId()+"-"+pet.getName());
    return repository.insert(pet);
  }

  @Override
  public Pet update(Pet pet){
    pet.setId(pet.getOwnerId()+"-"+pet.getName());
    return repository.save(pet);
  }

  @Override
  public List<Pet> getByOwnerId(Integer id){
    return repository.findAll().stream().filter(pet -> pet.getOwnerId().equals(id)).collect(Collectors.toList());
  }
}
