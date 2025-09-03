package com.project.clinic.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "USER_TABLE")
@Table(name = "USER_TABLE")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserModel {

    @Id
    @GeneratedValue
    private UUID id;
    @NotBlank(message = "nome é obrigatório")
    private String name;
    @NotBlank(message = "registro é obrigatório")
    private String registration;
    @NotBlank(message = "a senha é obrigatória")
    private String password;
    private UUID createBy;
    private LocalDateTime createAt;
    private UUID updateBy;
    private LocalDateTime updateAt;
    private UserType role;
}
