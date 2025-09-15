package com.project.clinic.services;

import com.project.clinic.models.dtos.HistoryRequestDTO;
import com.project.clinic.models.patientHistory.PatientHistoryModel;
import com.project.clinic.repositories.PatientHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientHistoryService {

    @Autowired
    private PatientHistoryRepository historyRepository;

    public void saveHistory(PatientHistoryModel historyModel){
        this.historyRepository.save(historyModel);
    }

    public PatientHistoryModel createPatient(HistoryRequestDTO historyRequestDTO){
        PatientHistoryModel newHistory = new PatientHistoryModel(historyRequestDTO);
        this.saveHistory(newHistory);
        return newHistory;
    }

    public PatientHistoryModel updatePatient(UUID id, HistoryRequestDTO historyRequestDTO){
        PatientHistoryModel updateHistory = historyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("History with id: " + id + ""));

        updateHistory.setDoctorId(historyRequestDTO.doctorId());
        updateHistory.setDiagnostic(historyRequestDTO.diagnostic());
        updateHistory.setTreatment(historyRequestDTO.treatment());
        updateHistory.setObservation(historyRequestDTO.observations());
        updateHistory.setDateRegistration(historyRequestDTO.dateRegister());

        return updateHistory;

    }

    public List<PatientHistoryModel> findAllHistory(){
        return historyRepository.findAll();
    }

    public PatientHistoryModel findHistoryById(UUID id){
        return historyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("History with id: " + id + " not found."));

    }

    public boolean deleteHistory(UUID id){
        if(historyRepository.existsById(id)){
            historyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
