package com.project.clinic.repositories;

import com.project.clinic.model.consultation.ConsultationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsultationRepository extends JpaRepository<ConsultationModel, UUID> {
}
