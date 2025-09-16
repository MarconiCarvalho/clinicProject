package com.project.clinic.repositories;

import com.project.clinic.models.patient.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<PatientModel, UUID> {
}
