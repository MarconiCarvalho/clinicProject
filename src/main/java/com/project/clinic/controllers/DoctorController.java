package com.project.clinic.controllers;

import com.project.clinic.models.doctor.DoctorModel;
import com.project.clinic.models.dtos.DoctorRequestDTO;
import com.project.clinic.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctors")
public class DoctorController{

    @Autowired
    private DoctorService doctorService;

    @PostMapping(("/create"))
    public ResponseEntity<DoctorModel> createDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO){
        DoctorModel newDoctor = doctorService.createDoctor(doctorRequestDTO);
        return ResponseEntity.ok(newDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorModel> updateDoctor(@PathVariable UUID id, @RequestBody DoctorRequestDTO doctorRequestDTO){
        DoctorModel updateDoctor = doctorService.updateDoctor(id, doctorRequestDTO);
        return ResponseEntity.ok(updateDoctor);
    }


    @GetMapping("/list")
    public ResponseEntity<List<DoctorModel>> getAllDoctor(){
        return ResponseEntity.ok(doctorService.findAllDoctor());
    }

    @GetMapping("/findDoctor/{id}")
    public ResponseEntity<DoctorModel> getDoctorById(@PathVariable UUID id){
        return ResponseEntity.ok(doctorService.findDoctorById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable UUID id){
        boolean deleted = doctorService.deleteDoctor(id);

        if(deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
