package com.project.clinic.model.dtos;

import com.project.clinic.model.patient.AndressPatient;
import java.time.LocalDateTime;
import java.util.UUID;

public record PatientRequestDTO(String name, String documentation, String contact, String dateBirth, String email, AndressPatient andressPatient, UUID createBy, LocalDateTime createAt, UUID updateBy, LocalDateTime updateAt){
}
