package com.project.clinic.model.patient;

import jakarta.persistence.Embeddable;

@Embeddable
public class AndressPatient {

    private String number;
    private String City;
    private String state;
    private String cep;
    private String zone;
}
