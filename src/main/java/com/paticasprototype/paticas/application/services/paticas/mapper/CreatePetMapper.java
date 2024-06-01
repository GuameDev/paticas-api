package com.paticasprototype.paticas.application.services.paticas.mapper;

import com.paticasprototype.paticas.application.services.paticas.dtos.CreatePetRequest;
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
}