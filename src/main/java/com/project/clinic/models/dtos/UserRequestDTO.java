package com.project.clinic.models.dtos;

import com.project.clinic.models.user.UserType;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserRequestDTO(String userName, String registration, String password, UUID CreateBy, UUID updateBy, LocalDateTime updateAt, UserType role){
}
