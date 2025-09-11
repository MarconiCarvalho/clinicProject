package com.project.clinic.models.dtos;

import com.project.clinic.models.patient.AndressPatient;
import java.time.LocalDateTime;
import java.util.UUID;

public record PatientRequestDTO(String name, String documentation, String contact, String dateBirth, String email, AndressPatient andressPatient, UUID createBy, LocalDateTime createAt, UUID updateBy, LocalDateTime updateAt){
}
