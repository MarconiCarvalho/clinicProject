package com.project.clinic.repositories;

import com.project.clinic.models.patientHistory.PatientHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientHistoryRepository extends JpaRepository <PatientHistoryModel,UUID >{
}
