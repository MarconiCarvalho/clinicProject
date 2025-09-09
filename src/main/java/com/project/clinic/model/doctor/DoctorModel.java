package com.project.clinic.model.doctor;

import com.project.clinic.model.dtos.DoctorRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "DOCTOR_TABLE")
@Table(name = "DOCTOR_TABLE")
@NoArgsConstructor
@EqualsAndHashCode(of = "idDoctor")
public class DoctorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idDoctor;
    private String name;
    private String crm;
    private String specialty;
    private String contact;

    public DoctorModel(DoctorRequestDTO data){
        this.name = data.name();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.contact = data.contact();
    }
    public UUID getIdDoctor() {
        return idDoctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


}
