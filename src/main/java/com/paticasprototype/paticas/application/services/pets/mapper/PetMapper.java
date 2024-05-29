package com.paticasprototype.paticas.application.services.pets.mapper;

import com.paticasprototype.paticas.application.services.pets.dtos.PetDTO;
import com.paticasprototype.paticas.application.services.shelters.dtos.ShelterDTO;
import com.paticasprototype.paticas.domain.entities.Pet;
import com.paticasprototype.paticas.domain.entities.Shelter;

public class PetMapper {
    public static PetDTO toDTO(Pet pet) {
        PetDTO dto = new PetDTO();
        dto.setId(pet.getId());
        dto.setName(pet.getName());
        dto.setGendre(pet.getGendre().name());
        dto.setSpecies(pet.getSpecies());
        dto.setRace(pet.getRace());
        dto.setSize(pet.getSize());
        dto.setBirthDate(pet.getBirthDate());
        dto.setDescription(pet.getDescription());
        dto.setPhoneNumber(pet.getPhoneNumber());
        dto.setPathImagesCarousel(pet.getPathImagesCarousel());
        dto.setPathCardImage(pet.getPathCardImage());
        dto.setShelter(toDTO(pet.getShelter()));
        return dto;
    }

    public static ShelterDTO toDTO(Shelter shelter) {
        if (shelter == null) {
            return null;
        }
        ShelterDTO dto = new ShelterDTO();
        dto.setId(shelter.getId());
        dto.setName(shelter.getName());
        dto.setAddress(shelter.getAddress());
        dto.setPathHeaderImage(shelter.getPathHeaderImage());
        dto.setPathCardImage(shelter.getPathCardImage());
        return dto;
    }
}
