package com.filipdishe.PetShop.service;

import com.filipdishe.PetShop.dto.PetDto;
import com.filipdishe.PetShop.exceptions.MaxUsersExceededException;

import java.util.List;

/**
 * This class is responsible for performing business logic for the pets.
 */
public interface PetService {

    /**
     * Create 20 pets with random fields/properties automatically the properties are completely random
     * they don't repeat, and save them in a database.
     *
     * @throws MaxUsersExceededException if clients attempt to create more than 20 pets.
     */
    List<PetDto> createPets();

    /**
     * Get all the pets stored in the database.
     */
    List<PetDto> getAllPets();
}
