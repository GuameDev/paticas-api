package com.paticasprototype.paticas.application.services.pets.services;

import com.paticasprototype.paticas.domain.entities.Pet;
import com.paticasprototype.paticas.domain.usecase.PetUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetUseCase petUseCase;

    public PetService(PetUseCase petUseCase) {
        this.petUseCase = petUseCase;
    }

    public List<Pet> getAllPets() {
        return petUseCase.getAllPets();
    }

    public Optional<Pet> getPetById(Long id) {
        return petUseCase.getPetById(id);
    }

    public Pet createPet(Pet pet) {
        return petUseCase.createPet(pet);
    }

    public Optional<Pet> updatePet(Long id, Pet petDetails) {
        return petUseCase.updatePet(id, petDetails);
    }

    public boolean deletePet(Long id) {
        return petUseCase.deletePet(id);
    }
}