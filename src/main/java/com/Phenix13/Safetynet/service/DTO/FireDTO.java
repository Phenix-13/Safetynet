package com.Phenix13.Safetynet.service.DTO;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FireDTO {
    private String station;
    private List<PersonInFireDTO> persons;


    public FireDTO(List<PersonInFireDTO> persons, String station) {
        this.station = station;
        this.persons = persons;

    }

    public FireDTO() {
    }

    public List<PersonInFireDTO> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonInFireDTO> persons) {
        this.persons = persons;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
