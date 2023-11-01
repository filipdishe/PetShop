package com.filipdishe.PetShop.repository;

import com.filipdishe.PetShop.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("SELECT p FROM Pet p WHERE p.owner IS NULL")
    List<Pet> findUnownedPets();
}
