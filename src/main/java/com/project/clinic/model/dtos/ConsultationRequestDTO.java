package com.project.clinic.model.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ConsultationRequestDTO(LocalDate date, String timer, String status, UUID createBy, LocalDateTime createAt, UUID updateBy, LocalDateTime updateAt){
}
