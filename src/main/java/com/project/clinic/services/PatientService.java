package com.project.clinic.services;

import com.project.clinic.model.dtos.PatientRequestDTO;
import com.project.clinic.model.patient.PatientModel;
import com.project.clinic.repositories.PatientRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    private void savePatient(PatientModel patientModel){
        this.patientRepository.save(patientModel);
    }

    private PatientModel createPatient(PatientRequestDTO patientRequestDTO){
        PatientModel newPatient = new PatientModel(patientRequestDTO);
        this.savePatient(newPatient);

        return newPatient;
    }
    private List<PatientModel> findAllPatient(UUID id){
        return patientRepository.findAll();
    }

    private PatientModel findPatientById(UUID id){
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    private PatientModel updatePatient(UUID id, PatientRequestDTO patientRequestDTO){
        PatientModel updatePatient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID: "+ id + " not found"));
        updatePatient.setName(patientRequestDTO.name()) ;
        updatePatient.setDocumentation(patientRequestDTO.documentation());
        updatePatient.setContact(patientRequestDTO.contact());
        updatePatient.setDateBirth(patientRequestDTO.dateBirth());
        updatePatient.setEmail(patientRequestDTO.email());
        updatePatient.setAndressPatient(patientRequestDTO.andressPatient());
        updatePatient.setUpdateBy(patientRequestDTO.updateBy());
        updatePatient.setUpdateAt(LocalDateTime.now());
        return updatePatient;
    }

    private boolean deleteUserById(UUID id){
        if(patientRepository.existsById(id)){
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
