package com.project.clinic.model.dtos;

import com.project.clinic.model.registration.StatusType;

import java.time.LocalDateTime;
import java.util.UUID;

public record RegistrationRequestDTO(UUID idRegistration, LocalDateTime timeStamp, StatusType status) {
}
