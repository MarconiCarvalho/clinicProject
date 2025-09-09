package com.project.clinic.model.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record HistoryRequestDTO(UUID doctorId, String diagnostic, String treatment, String observations, LocalDateTime dateRegister) {
}
