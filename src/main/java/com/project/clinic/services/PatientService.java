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
        newPatient.setName(patientRequestDTO.name()) ;
        newPatient.setDocumentation(patientRequestDTO.documentation());
        newPatient.setContact(patientRequestDTO.contact());
        newPatient.setDateBirth(patientRequestDTO.dateBirth());
        newPatient.setEmail(patientRequestDTO.email());
        newPatient.setAndressPatient(patientRequestDTO.andressPatient());
        newPatient.setUpdateBy(patientRequestDTO.updateBy());
        newPatient.setUpdateAt(LocalDateTime.now());

        return newPatient;
    }
    private List<PatientModel> findAllPatient(UUID id){
        return patientRepository.findAll();
    }

    private PatientModel findPatientById(UUID id){
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    private PatientModel updatePatient(UUID id, PatientRequestDTO patientRequestDTO){
        PatientModel newPatient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID: "+ id + " not found"));
        newPatient.setName(patientRequestDTO.name()) ;
        newPatient.setDocumentation(patientRequestDTO.documentation());
        newPatient.setContact(patientRequestDTO.contact());
        newPatient.setDateBirth(patientRequestDTO.dateBirth());
        newPatient.setEmail(patientRequestDTO.email());
        newPatient.setAndressPatient(patientRequestDTO.andressPatient());
        newPatient.setUpdateBy(patientRequestDTO.updateBy());
        newPatient.setUpdateAt(LocalDateTime.now());
        return newPatient;
    }

    private boolean deleteUserById(UUID id){
        if(patientRepository.existsById(id)){
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
