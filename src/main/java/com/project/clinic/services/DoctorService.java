package com.project.clinic.services;

import com.project.clinic.model.doctor.DoctorModel;
import com.project.clinic.model.dtos.DoctorRequestDTO;
import com.project.clinic.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void saveDoctor(DoctorModel doctorModel){
        this.doctorRepository.save(doctorModel);
    }

    public DoctorModel createDoctor(DoctorRequestDTO doctorRequestDTO){
        DoctorModel newDoctor = new DoctorModel(doctorRequestDTO);
        this.saveDoctor(newDoctor);
        return newDoctor;
    }

    public DoctorModel updateDoctor(UUID id, DoctorRequestDTO doctorRequestDTO){
        DoctorModel updateDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor with id: "+ id + " not found."));

        updateDoctor.setName(doctorRequestDTO.name());
        updateDoctor.setCrm(doctorRequestDTO.crm());
        updateDoctor.setSpecialty(doctorRequestDTO.specialty());
        updateDoctor.setContact(doctorRequestDTO.contact());

        return updateDoctor;
    }

    public List<DoctorModel> findAllDoctor(){
        return this.doctorRepository.findAll();
    }

    public DoctorModel findDoctorById(UUID id){
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor with id: " + id + " not found."));
    }

    public boolean deleteDoctor(UUID id){
        if(doctorRepository.existsById(id)){
            doctorRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
