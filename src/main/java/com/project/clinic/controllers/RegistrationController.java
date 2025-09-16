package com.project.clinic.controllers;

import com.project.clinic.models.dtos.RegistrationRequestDTO;
import com.project.clinic.models.registration.RegistrationModel;
import com.project.clinic.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/registration")
public class RegistrationController{

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/create")
    public ResponseEntity<RegistrationModel> createRegistration(@RequestBody RegistrationRequestDTO registrationRequestDTO){
        RegistrationModel newRegistration = registrationService.createRegistration(registrationRequestDTO);
        return ResponseEntity.ok(newRegistration);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RegistrationModel> updateRegistration(@PathVariable UUID id, @RequestBody RegistrationRequestDTO registrationRequestDTO){
        RegistrationModel updateRegistration = registrationService.updateRegistration(id, registrationRequestDTO);
        return ResponseEntity.ok(updateRegistration);
    }

    @GetMapping("/findRegistration")
    public ResponseEntity<RegistrationModel> findRegistration(@PathVariable UUID id){
        return ResponseEntity.ok(registrationService.findRegistrationById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<RegistrationModel>> listRegistration(){
        return ResponseEntity.ok(registrationService.findAllRegistration());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<RegistrationModel> deleteRegistration(@PathVariable UUID id){
        boolean deleted = registrationService.deleteRegistration(id);

        if(deleted){
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.notFound().build();
    }
}