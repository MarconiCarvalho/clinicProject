package com.project.clinic.services;

import com.project.clinic.models.dtos.RegistrationRequestDTO;
import com.project.clinic.models.registration.RegistrationModel;
import com.project.clinic.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class RegistrationService {


    @Autowired
    private RegistrationRepository registrationRepository;


    public void saveRegistration(RegistrationModel registrationModel){
        this.registrationRepository.save(registrationModel);
    }

    public RegistrationModel createRegistration(RegistrationRequestDTO registrationRequestDTO){
        RegistrationModel newRegistration = new RegistrationModel(registrationRequestDTO);
        this.saveRegistration(newRegistration);
        return newRegistration;
    }

    public RegistrationModel updateRegistration(UUID id, RegistrationRequestDTO registrationRequestDTO){
        RegistrationModel updateRegistration = registrationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Registration with id " + id + " not found"));

        updateRegistration.setTimeStamp(registrationRequestDTO.timeStamp());
        updateRegistration.setStatus(registrationRequestDTO.status());
        return updateRegistration;
    }

    public List<RegistrationModel> findAllRegistration(){
        return registrationRepository.findAll();
    }

    public RegistrationModel findRegistrationById(UUID id){
        return registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration with id " + id + " not found"));
    }

    public boolean deleteRegistration (UUID id){

        if(registrationRepository.existsById(id)){
            registrationRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
