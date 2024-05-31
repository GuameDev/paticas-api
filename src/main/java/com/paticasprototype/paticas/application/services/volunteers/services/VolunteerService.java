package com.paticasprototype.paticas.application.services.volunteers.services;

import com.paticasprototype.paticas.application.services.volunteers.dtos.VolunteerDTO;
import com.paticasprototype.paticas.domain.usecase.VolunteerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerUseCase volunteerUseCase;

    public List<VolunteerDTO> getAllVolunteers() {
        return volunteerUseCase.getAllVolunteers();
    }

    public Optional<VolunteerDTO> getVolunteerById(Long id) {
        return volunteerUseCase.getVolunteerById(id);
    }

    public VolunteerDTO createVolunteer(VolunteerDTO volunteerDTO) {
        return volunteerUseCase.createVolunteer(volunteerDTO);
    }

    public Optional<VolunteerDTO> updateVolunteer(Long id, VolunteerDTO volunteerDTO) {
        return volunteerUseCase.updateVolunteer(id, volunteerDTO);
    }

    public boolean deleteVolunteer(Long id) {
        return volunteerUseCase.deleteVolunteer(id);
    }
}