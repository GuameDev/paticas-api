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

    public Optional<Pet> updatePatica(Long id, Pet petDetails) {
        return petRepository.findById(id).map(patica -> {
            patica.setProfileImage(petDetails.getProfileImage());
            patica.setImageCarousel1(petDetails.getImageCarousel1());
            patica.setImageCarousel2(petDetails.getImageCarousel2());
            patica.setImageCarousel3(petDetails.getImageCarousel3());
            patica.setName(petDetails.getName());
            patica.setLocation(petDetails.getLocation());
            patica.setGender(petDetails.getGender());
            patica.setSize(petDetails.getSize());
            patica.setBirthDate(petDetails.getBirthDate());
            patica.setSpecies(petDetails.getSpecies());
            patica.setDescription(petDetails.getDescription());
            patica.setGoodWithKids(petDetails.isGoodWithKids());
            patica.setGoodWithDogs(petDetails.isGoodWithDogs());
            patica.setGoodWithCats(petDetails.isGoodWithCats());
            patica.setShelter(petDetails.getShelter());

            return petRepository.save(patica);
        });
    }

    public boolean deletePet(Long id) {
        return petRepository.findById(id).map(pet -> {
            petRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
