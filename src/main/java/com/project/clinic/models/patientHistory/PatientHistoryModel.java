package com.project.clinic.models.patientHistory;

import com.project.clinic.models.dtos.HistoryRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@NoArgsConstructor
@EqualsAndHashCode(of = "idHistory")
public class PatientHistoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idHistory;
    private UUID doctorId;
    private String diagnostic;
    private String treatment;
    private String observation;
    private LocalDateTime dateRegistration;

    public PatientHistoryModel(HistoryRequestDTO data){
        this.doctorId = data.doctorId();
        this.diagnostic = data.diagnostic();
        this.treatment = data.treatment();
        this.observation = data.observations();
        this.dateRegistration = data.dateRegister();
    }

    public UUID getIdHistory() {
        return idHistory;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public LocalDateTime getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(LocalDateTime dateRegistration) {
        this.dateRegistration = dateRegistration;
    }
}
