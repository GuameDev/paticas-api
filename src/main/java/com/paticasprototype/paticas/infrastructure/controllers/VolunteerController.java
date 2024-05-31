package com.paticasprototype.paticas.infrastructure.controllers;

import com.paticasprototype.paticas.application.services.volunteers.dtos.VolunteerDTO;
import com.paticasprototype.paticas.application.services.volunteers.services.VolunteerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    private final VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @GetMapping
    public List<VolunteerDTO> getAllVolunteers() {
        return volunteerService.getAllVolunteers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VolunteerDTO> getVolunteerById(@PathVariable Long id) {
        Optional<VolunteerDTO> volunteer = volunteerService.getVolunteerById(id);
        return volunteer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public VolunteerDTO createVolunteer(@RequestBody VolunteerDTO volunteerDTO) {
        return volunteerService.createVolunteer(volunteerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VolunteerDTO> updateVolunteer(@PathVariable Long id, @RequestBody VolunteerDTO volunteerDTO) {
        Optional<VolunteerDTO> updatedVolunteer = volunteerService.updateVolunteer(id, volunteerDTO);
        return updatedVolunteer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVolunteer(@PathVariable Long id) {
        boolean isDeleted = volunteerService.deleteVolunteer(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}