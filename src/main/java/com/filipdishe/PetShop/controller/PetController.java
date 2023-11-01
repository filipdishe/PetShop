package com.filipdishe.PetShop.controller;

import com.filipdishe.PetShop.dto.PetDto;
import com.filipdishe.PetShop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/create-pets")
    public ResponseEntity<List<PetDto>> createRandomPets() {
        List<PetDto> generatedPets = petService.createPets();

        return new ResponseEntity<>(generatedPets, HttpStatus.OK);
    }

    @GetMapping("/list-pets")
    public ResponseEntity<List<PetDto>> listAllPets() {
        List<PetDto> allPets = petService.getAllPets();

        if(allPets.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allPets);
        }
    }
}
