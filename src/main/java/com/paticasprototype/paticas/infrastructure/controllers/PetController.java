package com.paticasprototype.paticas.infrastructure.controllers;

import com.paticasprototype.paticas.application.services.pets.dtos.PetDTO;
import com.paticasprototype.paticas.application.services.pets.mapper.PetMapper;
import com.paticasprototype.paticas.application.services.pets.services.PetService;
import com.paticasprototype.paticas.domain.entities.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<PetDTO> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return pets.stream().map(PetMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> getPetById(@PathVariable Long id) {
        Optional<Pet> pet = petService.getPetById(id);
        return pet.map(p -> ResponseEntity.ok(PetMapper.toDTO(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PetDTO createPet(@RequestBody Pet pet) {
        Pet createdPet = petService.createPet(pet);
        return PetMapper.toDTO(createdPet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> updatePet(@PathVariable Long id, @RequestBody Pet petDetails) {
        Optional<Pet> updatedPet = petService.updatePet(id, petDetails);
        return updatedPet.map(p -> ResponseEntity.ok(PetMapper.toDTO(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        boolean isDeleted = petService.deletePet(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}