package com.project.clinic.services;

import com.project.clinic.model.consultation.ConsultationModel;
import com.project.clinic.model.dtos.ConsultationRequestDTO;
import com.project.clinic.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    private void saveConsultation(ConsultationModel consultationModel){
        this.consultationRepository.save(consultationModel);
    }

    private ConsultationModel createConsultation(ConsultationRequestDTO consultation){
        ConsultationModel newConsultation = new ConsultationModel(consultation);

        newConsultation.setDate(consultation.date());
        newConsultation.setTimer(consultation.timer());
        newConsultation.setStatus(consultation.status());
        newConsultation.setCreateBy(consultation.createBy());
        newConsultation.setCreateAt(consultation.createAt());
        newConsultation.setUpdateBy(consultation.updateBy());
        newConsultation.setUpdateAt(consultation.updateAt());
        return newConsultation;
    }

    private List<ConsultationModel> findAllConsultation(){
        return consultationRepository.findAll();
    }

    private ConsultationModel findConsultationById(UUID id){
        return consultationRepository.findById(id).orElseThrow(() -> new RuntimeException("User with ID: " +id+ " not found"));
    }
}
