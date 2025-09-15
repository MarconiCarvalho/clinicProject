package com.project.clinic.controllers;


import com.project.clinic.models.consultation.ConsultationModel;
import com.project.clinic.models.dtos.ConsultationRequestDTO;
import com.project.clinic.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @PostMapping("/create")
    public ResponseEntity<ConsultationModel> createConsultation(@RequestBody ConsultationRequestDTO consultationRequestDTO){
        ConsultationModel newConsultation = consultationService.createConsultation(consultationRequestDTO);
        return ResponseEntity.ok(newConsultation);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ConsultationModel> updateConsultation(@PathVariable UUID id, @RequestBody ConsultationRequestDTO consultationRequestDTO){
        ConsultationModel updateConsultation = consultationService.updateConsultation(id,consultationRequestDTO);
        return ResponseEntity.ok(updateConsultation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultationModel> findConsultation(@PathVariable UUID id){
        return ResponseEntity.ok(consultationService.findConsultationById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ConsultationModel>> listConsultation(){
        return ResponseEntity.ok(consultationService.findAllConsultation());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ConsultationModel> deleteConsultation(@PathVariable UUID id){
        boolean deleted = consultationService.deleteConsultationById(id);

        if(deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
