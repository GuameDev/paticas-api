package com.paticasprototype.paticas.domain.usecase;

import com.paticasprototype.paticas.application.services.paticas.mapper.PetMapper;
import com.paticasprototype.paticas.application.services.volunteers.dtos.VolunteerDTO;
import com.paticasprototype.paticas.application.services.volunteers.mapper.VolunteerMapper;
import com.paticasprototype.paticas.domain.entities.Shelter;
import com.paticasprototype.paticas.domain.entities.Volunteer;
import com.paticasprototype.paticas.domain.repositories.ShelterRepository;
import com.paticasprototype.paticas.domain.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VolunteerUseCase {

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Autowired
    private ShelterRepository shelterRepository;

    public List<VolunteerDTO> getAllVolunteers() {
        return volunteerRepository.findAll().stream()
                .map(VolunteerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<VolunteerDTO> getVolunteerById(Long id) {
        return volunteerRepository.findById(id).map(VolunteerMapper::toDTO);
    }

    public VolunteerDTO createVolunteer(VolunteerDTO volunteerDTO) {
        Volunteer volunteer = VolunteerMapper.toEntity(volunteerDTO);
        Shelter shelter = shelterRepository.findById(volunteerDTO.getShelterId())
                .orElseThrow(() -> new RuntimeException("Shelter not found"));
        volunteer.setShelter(shelter);
        return VolunteerMapper.toDTO(volunteerRepository.save(volunteer));
    }

    public Optional<VolunteerDTO> updateVolunteer(Long id, VolunteerDTO volunteerDTO) {
        return volunteerRepository.findById(id).map(existingVolunteer -> {
            Volunteer volunteer = VolunteerMapper.toEntity(volunteerDTO);
            volunteer.setId(existingVolunteer.getId());
            Shelter shelter = shelterRepository.findById(volunteerDTO.getShelterId())
                    .orElseThrow(() -> new RuntimeException("Shelter not found"));
            volunteer.setShelter(shelter);
            return VolunteerMapper.toDTO(volunteerRepository.save(volunteer));
        });
    }

    public boolean deleteVolunteer(Long id) {
        if (volunteerRepository.existsById(id)) {
            volunteerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<VolunteerDTO> getVolunteersByShelterId(Long shelterId, Pageable pageable) {
        return volunteerRepository.findByShelterId(shelterId, pageable).map(VolunteerMapper::toDTO);
    }
}