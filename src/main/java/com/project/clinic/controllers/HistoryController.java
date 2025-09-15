package com.project.clinic.controllers;

import com.project.clinic.models.dtos.HistoryRequestDTO;
import com.project.clinic.models.patient.PatientModel;
import com.project.clinic.models.patientHistory.PatientHistoryModel;
import com.project.clinic.services.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/history")
public class HistoryController{

    @Autowired
    private PatientHistoryService historyService;

    @GetMapping("/create")
    public ResponseEntity<PatientHistoryModel> createHistory(@RequestBody HistoryRequestDTO historyRequestDTO){
        PatientHistoryModel newHistory = historyService.createPatient(historyRequestDTO);
        return ResponseEntity.ok(newHistory);
    }

    @PutMapping("/update")
    public ResponseEntity<PatientHistoryModel> updateHistory(@PathVariable UUID id, @RequestBody HistoryRequestDTO historyRequestDTO){
        PatientHistoryModel updateHistory = historyService.updatePatient(id,historyRequestDTO);
        return ResponseEntity.ok(updateHistory);
    }

    @GetMapping("/findHistory/{id}")
    public ResponseEntity<PatientHistoryModel> findHistory(@PathVariable UUID id){
        return ResponseEntity.ok(historyService.findHistoryById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<PatientHistoryModel>> findAllHistory(){
        return ResponseEntity.ok(historyService.findAllHistory());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<PatientHistoryModel> deleteHistory(@PathVariable UUID id){
        boolean deleted = historyService.deleteHistory(id);

        if(deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
