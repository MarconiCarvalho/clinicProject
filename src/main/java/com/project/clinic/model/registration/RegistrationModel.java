package com.project.clinic.model.registration;

import com.project.clinic.model.dtos.RegistrationRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@NoArgsConstructor
@EqualsAndHashCode(of = "idRegistration")
public class RegistrationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idRegistration;
    private LocalDateTime timeStamp;
    private StatusType status;


    public RegistrationModel(RegistrationRequestDTO data){
        this.idRegistration = data.idRegistration();
        this.timeStamp = data.timeStamp();
        this.status = data.status();
    }

    public UUID getIdRegistration() {
        return idRegistration;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }


}
