package com.project.clinic.model.dtos;

import com.project.clinic.model.user.UserType;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserRequestDTO(String userName, String registration, String password, UUID CreateBy, UUID updateBy, LocalDateTime updateAt, UserType role){
}
