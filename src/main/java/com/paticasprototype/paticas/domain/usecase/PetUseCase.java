package com.paticasprototype.paticas.domain.usecase;

import com.paticasprototype.paticas.domain.entities.Pet;
import com.paticasprototype.paticas.domain.repositories.PetRepository;

import java.util.List;
import java.util.Optional;

public class PetUseCase {
    private final PetRepository petRepository;

    public PetUseCase(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(Long id) {
        return petRepository.findById(id);
    }

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Optional<Pet> updatePet(Long id, Pet petDetails) {
        return petRepository.findById(id).map(pet -> {

            pet.setName(petDetails.getName());
            pet.setGendre(petDetails.getGendre());
            pet.setSpecies(petDetails.getSpecies());
            pet.setRace(petDetails.getRace());
            pet.setSize(petDetails.getSize());
            pet.setBirthDate(petDetails.getBirthDate());
            pet.setDescription(petDetails.getDescription());
            pet.setPhoneNumber(petDetails.getPhoneNumber());
            pet.setShelter(petDetails.getShelter());
            pet.setPathImagesCarousel(petDetails.getPathImagesCarousel());
            pet.setPathCardImage(petDetails.getPathCardImage());
            pet.setShelter(petDetails.getShelter());

            return petRepository.save(pet);
        });
    }

    public boolean deletePet(Long id) {
        return petRepository.findById(id).map(pet -> {
            petRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
