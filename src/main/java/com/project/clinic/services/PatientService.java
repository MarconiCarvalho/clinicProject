package com.project.clinic.services;

import com.project.clinic.models.dtos.PatientRequestDTO;
import com.project.clinic.models.patient.PatientModel;
import com.project.clinic.repositories.PatientRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public void savePatient(PatientModel patientModel){
        this.patientRepository.save(patientModel);
    }

    public PatientModel createPatient(PatientRequestDTO patientRequestDTO){
        PatientModel newPatient = new PatientModel(patientRequestDTO);
        this.savePatient(newPatient);

        return newPatient;
    }
    public List<PatientModel> findAllPatient(UUID id){
        return patientRepository.findAll();
    }

    public PatientModel findPatientById(UUID id){
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public PatientModel updatePatient(UUID id, PatientRequestDTO patientRequestDTO){
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

    public boolean deletePatientById(UUID id){
        if(patientRepository.existsById(id)){
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
