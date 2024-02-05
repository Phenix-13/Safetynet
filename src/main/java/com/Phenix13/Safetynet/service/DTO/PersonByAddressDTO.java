package com.Phenix13.Safetynet.service.DTO;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PersonByAddressDTO {
    private String address;
    private List<PersonInFireDTO> personAtAddress;

    public PersonByAddressDTO(String address, List<PersonInFireDTO> personInFireDTOList) {
        this.address = address;
        this.personAtAddress = personInFireDTOList;
    }

    public PersonByAddressDTO() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PersonInFireDTO> getPersonAtAddress() {
        return personAtAddress;
    }

    public void setPersonAtAddress(List<PersonInFireDTO> personAtAddress) {
        this.personAtAddress = personAtAddress;
    }
}
