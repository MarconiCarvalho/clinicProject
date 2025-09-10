package com.project.clinic.services;

import com.project.clinic.model.dtos.RegistrationRequestDTO;
import com.project.clinic.model.registration.RegistrationModel;
import com.project.clinic.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegistrationService {


    @Autowired
    private RegistrationRepository registrationRepository;


    private void saveRegistration(RegistrationModel registrationModel){
        this.registrationRepository.save(registrationModel);
    }

    private RegistrationModel createRegistration(RegistrationRequestDTO registrationRequestDTO){
        RegistrationModel newRegistration = new RegistrationModel(registrationRequestDTO);
        this.saveRegistration(newRegistration);
        return newRegistration;
    }

    private RegistrationModel updateRegistration(UUID id, RegistrationRequestDTO registrationRequestDTO){
        RegistrationModel updateRegistration = registrationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Registration with id " + id + " not found"));

        updateRegistration.setTimeStamp(registrationRequestDTO.timeStamp());
        updateRegistration.setStatus(registrationRequestDTO.status());
        return updateRegistration;
    }

    private List<RegistrationModel> findAllRegistration(){
        return registrationRepository.findAll();
    }

    private RegistrationModel findRegistrationById(UUID id){
        return registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration with id " + id + " not found"));
    }

    private boolean deleteRegistration (UUID id){

        if(registrationRepository.existsById(id)){
            registrationRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
