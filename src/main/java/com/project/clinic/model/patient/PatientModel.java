package com.project.clinic.model.patient;

import com.project.clinic.model.dtos.PatientRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "PATIENT_TABLE")
@Table(name = "PATIENT_NAME")
@AllArgsConstructor
@EqualsAndHashCode(of = "idPatient")
public class PatientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    UUID idPatient;
    String name;
    String documentation;
    String contact;
    String dateBirth;
    String email;
    AndressPatient andressPatient;
    UUID createBy;
    LocalDateTime createAt;
    UUID updateBy;
    LocalDateTime updateAt;

    public PatientModel(PatientRequestDTO data) {
        this.name = data.name();
        this.documentation = data.documentation();
        this.contact = data.contact();
        this.dateBirth = data.dateBirth();
        this.email = data.email();
        this.andressPatient = data.andressPatient();
        this.createAt = data.createAt();
        this.createBy = data.createBy();
        this.updateBy = data.updateBy();
        this.updateAt = data.updateAt();
    }

    public UUID getIdPatient() {
        return idPatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AndressPatient getAndressPatient() {
        return andressPatient;
    }

    public void setAndressPatient(AndressPatient andressPatient) {
        this.andressPatient = andressPatient;
    }

    public UUID getCreateBy() {
        return createBy;
    }

    public void setCreateBy(UUID createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public UUID getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(UUID updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
