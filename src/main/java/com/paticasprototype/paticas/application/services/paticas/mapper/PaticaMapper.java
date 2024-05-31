package com.paticasprototype.paticas.application.services.paticas.mapper;

import com.paticasprototype.paticas.application.services.paticas.dtos.PetDTO;
import com.paticasprototype.paticas.application.services.shelters.dtos.ShelterDTO;
import com.paticasprototype.paticas.domain.entities.Pet;
import com.paticasprototype.paticas.domain.entities.Shelter;

public class PaticaMapper {

    public static PetDTO toDTO(Pet pet) {
        PetDTO dto = new PetDTO();
        dto.setId(pet.getId());
        dto.setProfileImage(pet.getProfileImage());
        dto.setImageCarousel1(pet.getImageCarousel1());
        dto.setImageCarousel2(pet.getImageCarousel2());
        dto.setImageCarousel3(pet.getImageCarousel3());
        dto.setName(pet.getName());
        dto.setLocation(pet.getLocation());
        dto.setGender(pet.getGender());
        dto.setSize(pet.getSize());
        dto.setBirthDate(pet.getBirthDate());
        dto.setSpecies(pet.getSpecies());
        dto.setDescription(pet.getDescription());
        dto.setGoodWithKids(pet.isGoodWithKids());
        dto.setGoodWithDogs(pet.isGoodWithDogs());
        dto.setGoodWithCats(pet.isGoodWithCats());
        dto.setShelter(toDTO(pet.getShelter()));
        return dto;
    }

    public static ShelterDTO toDTO(Shelter shelter) {
        if (shelter == null) {
            return null;
        }
        ShelterDTO dto = new ShelterDTO();
        dto.setId(shelter.getId());
        dto.setProfileImage(shelter.getProfileImage());
        dto.setName(shelter.getName());
        dto.setLocation(shelter.getLocation());
        dto.setDescription(shelter.getDescription());
        return dto;
    }
}