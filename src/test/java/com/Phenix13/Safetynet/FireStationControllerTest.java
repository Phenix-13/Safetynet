package com.Phenix13.Safetynet;

import com.Phenix13.Safetynet.controller.FireStationController;
import com.Phenix13.Safetynet.model.FireStation;
import com.Phenix13.Safetynet.model.Person;
import com.Phenix13.Safetynet.repository.FireStationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FireStationControllerTest {
    @Autowired
    private FireStationController fireStationController;
    @Autowired
    private FireStationRepository fireStationRepository;

    @Test
    public void addFireStationTest(){
        List<FireStation> fireStationList = fireStationRepository.fireStationList();
        int sizestart = fireStationList.size();
        fireStationController.addFirestation(new FireStation("1111 rue des 1","1"));
        int sizeend = fireStationList.size();
        assertThat(sizeend).isGreaterThan(sizestart);
    }

    @Test
    public void getAllFireStationTest(){
        assertThat(fireStationController.getAllFireStation()).isNotNull();
    }

    @Test
    public void updateFireStationTest(){
        List<FireStation> personList = fireStationRepository.fireStationList();
        String address = "1509 Culver St";
        FireStation fireStation = new FireStation("","4");
        assertThat(fireStationController.updateFireStation(address,fireStation).getStation().equals("4"));
    }

    @Test
    public void deletFireStationTest(){
        List<FireStation> fireStationList = fireStationRepository.fireStationList();
        int sizestart = fireStationList.size();
        fireStationController.deleteFireStation("1509 Culver St");
        int sizeend = fireStationList.size();
        assertThat(sizestart).isGreaterThan(sizeend);
    }
}
