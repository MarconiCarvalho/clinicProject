package com.project.clinic.models.patient;

import jakarta.persistence.Embeddable;

@Embeddable
public class AndressPatient {

    private String number;
    private String City;
    private String state;
    private String cep;
    private String zone;
}
