package com.project.clinic.repositories;
import com.project.clinic.models.registration.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegistrationRepository extends JpaRepository<RegistrationModel, UUID> {
}
