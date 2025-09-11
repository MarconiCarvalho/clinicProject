package com.project.clinic.models.dtos;

import com.project.clinic.models.registration.StatusType;

import java.time.LocalDateTime;
import java.util.UUID;

public record RegistrationRequestDTO(UUID idRegistration, LocalDateTime timeStamp, StatusType status) {
}
