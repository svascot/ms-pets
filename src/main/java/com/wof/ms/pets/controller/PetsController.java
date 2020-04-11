package com.wof.ms.pets.controller;

import com.wof.ms.pets.domain.interfaces.IPetsService;
import com.wof.ms.pets.model.Pet;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handle the methods that call the Pet domain.
 *
 * @author santiago.vasco
 */
@RestController
@RequestMapping(PetsController.API_PATH)
public class PetsController extends AbstractController<IPetsService>{

  public static final String API_PATH = "/pets";

  /**
   * Call the method that return a list of Pet objects.
   * @return an List of Pet.
   */
  @GetMapping
  public ResponseEntity getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  /**
   * Call the method that return a Pet object by the ID provided.
   * @param id Is the id of the pet.
   * @return a pet.
   */
  @GetMapping("/{id}")
  public ResponseEntity get(@PathVariable String id) {
    try{
      return ResponseEntity.ok(service.get(id));
    }catch (Exception e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  /**
   * Call the method that create a new Pet.
   * @param pet is the pet object that will be created.
   * @return an Uri to find the pet.
   */
  @PostMapping
  public ResponseEntity create(@RequestBody Pet pet){
    final URI uri = URI.create(API_PATH + "/" +service.create(pet).getId());
    return ResponseEntity.ok().body(uri);
  }

  /**
   * Call the method that update aa Pet.
   * @param pet is the pet object that contains the new information.
   * @return an Uri to find the pet.
   */
  @PutMapping
  public ResponseEntity update(@RequestBody Pet pet){
    System.out.println("ENTRO AL CREAR EL PUTO PERRO!");
    final URI uri = URI.create(API_PATH + "/" +service.update(pet).getId());
    return ResponseEntity.ok().body(uri);
  }

  /**
   * Call the method that return a List of Pet objects with the Id of their owner.
   * @param id Is the id of the user owner.
   * @return an List of Pet.
   */
  @GetMapping("/owner/{id}")
  public ResponseEntity getByOwner(@PathVariable int id) {
    try{
      return ResponseEntity.ok(service.getByOwnerId(id));
    }catch (Exception e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
