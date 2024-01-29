package com.Phenix13.Safetynet.model;

import org.springframework.web.bind.annotation.RestController;


public class FireStation {
    private String address;
    private String station;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public FireStation(String address, String station) {
        this.address = address;
        this.station = station;
    }

    public FireStation() {
    }
}
