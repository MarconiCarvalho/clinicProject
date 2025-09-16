package com.project.clinic.services;

import com.project.clinic.models.consultation.ConsultationModel;
import com.project.clinic.models.dtos.ConsultationRequestDTO;
import com.project.clinic.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    public void saveConsultation(ConsultationModel consultationModel){
        this.consultationRepository.save(consultationModel);
    }

    public ConsultationModel createConsultation(ConsultationRequestDTO consultation){
        ConsultationModel newConsultation = new ConsultationModel(consultation);
        this.saveConsultation(newConsultation);
        return newConsultation;
    }

    public ConsultationModel updateConsultation(UUID id,ConsultationRequestDTO consultationRequestDTO){
        ConsultationModel updateConsultation = consultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation with " + id + " not found"));

        updateConsultation.setDate(consultationRequestDTO.date());
        updateConsultation.setTimer(consultationRequestDTO.timer());
        updateConsultation.setStatus(consultationRequestDTO.status());
        updateConsultation.setUpdateBy(consultationRequestDTO.updateBy());
        updateConsultation.setUpdateAt(LocalDateTime.now());

        return updateConsultation;
    }

    public List<ConsultationModel> findAllConsultation(){
        return consultationRepository.findAll();
    }

    public ConsultationModel findConsultationById(UUID id){
        return consultationRepository.findById(id).orElseThrow(() -> new RuntimeException("User with ID: " +id+ " not found"));
    }

    public Boolean deleteConsultationById(UUID id){
        if (consultationRepository.existsById(id)){
            consultationRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
