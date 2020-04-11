/*
 * Copyright (c) 2019 by ViliV. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * ViliV. ("Confidential Information").
 * You may not disclose such Confidential Information, and may only
 * use such Confidential Information in accordance with the terms of
 * the agreement you entered into with ViliV.
 */

package com.wof.ms.pets.domain.interfaces;

import com.wof.ms.pets.model.Pet;
import java.util.List;

/**
 * Interface for Pet service which allows this application to make calls to business logic from the controller layer.
 *
 * @author santiago.vasco
 */
public interface IPetsService extends IService {

    /**
     * Get All Pet.
     */
    List<Pet> getAll();

    /**
     * Get pet by id
     * */
    Pet get(String id);

    /**
     * Create a new pet
     * */
    Pet create(Pet pet);

    /**
     * Update a pet
     * */
    Pet update(Pet pet);

    /**
     * Get pets by owner Id
     * */
    List<Pet> getByOwnerId(Integer id);
}
