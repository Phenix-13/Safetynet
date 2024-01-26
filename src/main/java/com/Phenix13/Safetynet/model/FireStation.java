package com.Phenix13.Safetynet.model;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class FireStation {
    private String address;
    private Integer station;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStation() {
        return station;
    }

    public void setStation(Integer station) {
        this.station = station;
    }
}
