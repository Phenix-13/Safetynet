package com.Phenix13.Safetynet.model;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Data {
    private List<Person> persons;
    private List<FireStation> firestations;
    private List<MedicalRecord> medicalrecords;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<FireStation> getFirestations() {
        return firestations;
    }

    public void setFirestations(List<FireStation> firestations) {
        this.firestations = firestations;
    }

    public List<MedicalRecord> getMedicalrecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(List<MedicalRecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    public Data(List<Person> persons, List<FireStation> fireStations, List<MedicalRecord> medicalRecords) {
        this.persons = persons;
        this.firestations = fireStations;
        this.medicalrecords = medicalRecords;
    }

    public Data() {
    }
}
