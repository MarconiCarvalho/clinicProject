package com.project.clinic.controllers;

import com.project.clinic.models.dtos.PatientRequestDTO;
import com.project.clinic.models.patient.PatientModel;
import com.project.clinic.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<PatientModel> createPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        PatientModel newPatient = patientService.createPatient(patientRequestDTO);
        return ResponseEntity.ok(newPatient);
    }

    @PutMapping
    @RequestMapping("/update")
    public ResponseEntity<PatientModel> updatePatient(@PathVariable UUID id, @RequestBody PatientRequestDTO patientRequestDTO){
        PatientModel updatePatient = patientService.updatePatient(id, patientRequestDTO);
        return ResponseEntity.ok(updatePatient);
    }

    @DeleteMapping
    @RequestMapping("/delete")
    public ResponseEntity<PatientModel> deletePatient(@PathVariable UUID id){
        boolean deleted = patientService.deletePatientById(id);

        if(deleted){
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.notFound().build();


    }
}
