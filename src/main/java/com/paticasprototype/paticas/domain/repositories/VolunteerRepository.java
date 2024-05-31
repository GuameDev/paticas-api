package com.paticasprototype.paticas.domain.repositories;

import com.paticasprototype.paticas.domain.entities.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}