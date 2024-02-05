package com.Phenix13.Safetynet.service.DTO;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FloodDTO {
    private String station;
    private List<PersonByAddressDTO> addressList;

    public FloodDTO(String station, List<PersonByAddressDTO> personByAddressDTOList) {
        this.station = station;
        this.addressList = personByAddressDTOList;
    }

    public FloodDTO() {
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public List<PersonByAddressDTO> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<PersonByAddressDTO> addressList) {
        this.addressList = addressList;
    }
}
