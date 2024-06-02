package com.paticasprototype.paticas.application.services.paticas.mapper;

import com.paticasprototype.paticas.application.services.paticas.dtos.CreatePetRequest;
import com.paticasprototype.paticas.application.services.paticas.dtos.UpdatePetRequest;
import com.paticasprototype.paticas.domain.entities.Pet;
import com.paticasprototype.paticas.domain.entities.Shelter;
import com.paticasprototype.paticas.infrastructure.config.ConfigConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class CreatePetMapper {


private ConfigConstants config = new ConfigConstants();

    private String saveFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }

        File uploadDirFile = new File(config.getUploadDir());
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdirs();
        }

        String fileName =UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String filePath = config.getUploadDir() + fileName;
        file.transferTo(new File(filePath));
        return fileName;
    }

    public Pet toEntity(CreatePetRequest dto) throws IOException {
        Pet patica = new Pet();
        patica.setProfileImage(saveFile(dto.getProfileImage()));
        patica.setImageCarousel1(saveFile(dto.getImageCarousel1()));
        patica.setImageCarousel2(saveFile(dto.getImageCarousel2()));
        patica.setImageCarousel3(saveFile(dto.getImageCarousel3()));
        patica.setName(dto.getName());
        patica.setLocation(dto.getLocation());
        patica.setGender(dto.getGender());
        patica.setSize(dto.getSize());
        patica.setBirthDate(dto.getBirthDate());
        patica.setSpecies(dto.getSpecies());
        patica.setDescription(dto.getDescription());
        patica.setGoodWithKids(dto.isGoodWithKids());
        patica.setGoodWithDogs(dto.isGoodWithDogs());
        patica.setGoodWithCats(dto.isGoodWithCats());

        Shelter shelter = new Shelter();
        shelter.setId(dto.getShelterId());
        patica.setShelter(shelter);
        return patica;
    }
    public Pet updateEntity(Pet pet, UpdatePetRequest dto) throws IOException {

        if (dto.getProfileImage() != null && !dto.getProfileImage().isEmpty()) {
            pet.setProfileImage(saveFile(dto.getProfileImage()));
        }
        if (dto.getImageCarousel1() != null && !dto.getImageCarousel1().isEmpty()) {
            pet.setImageCarousel1(saveFile(dto.getImageCarousel1()));
        }
        if (dto.getImageCarousel2() != null && !dto.getImageCarousel2().isEmpty()) {
            pet.setImageCarousel2(saveFile(dto.getImageCarousel2()));
        }
        if (dto.getImageCarousel3() != null && !dto.getImageCarousel3().isEmpty()) {
            pet.setImageCarousel3(saveFile(dto.getImageCarousel3()));
        }

        pet.setName(dto.getName());
        pet.setLocation(dto.getLocation());
        pet.setGender(dto.getGender());
        pet.setSize(dto.getSize());
        pet.setBirthDate(dto.getBirthDate());
        pet.setSpecies(dto.getSpecies());
        pet.setDescription(dto.getDescription());
        pet.setGoodWithKids(dto.isGoodWithKids());
        pet.setGoodWithDogs(dto.isGoodWithDogs());
        pet.setGoodWithCats(dto.isGoodWithCats());

        Shelter shelter = new Shelter();
        shelter.setId(dto.getShelterId());
        pet.setShelter(shelter);

        return pet;
    }
}