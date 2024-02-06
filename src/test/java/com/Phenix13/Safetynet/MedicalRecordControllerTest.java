package com.Phenix13.Safetynet;

import com.Phenix13.Safetynet.controller.FireStationController;
import com.Phenix13.Safetynet.controller.MedicalRecordController;
import com.Phenix13.Safetynet.model.FireStation;
import com.Phenix13.Safetynet.model.MedicalRecord;
import com.Phenix13.Safetynet.repository.FireStationRepository;
import com.Phenix13.Safetynet.repository.MedicalRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MedicalRecordControllerTest {
    @Autowired
    private MedicalRecordController medicalRecordController;
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Test
    public void addMedicalRecordTest(){
        List<MedicalRecord> medicalRecordList = medicalRecordRepository.medicalRecordList();
        int sizestart = medicalRecordList.size();
        medicalRecordController.addMedicalRecord(new MedicalRecord());
        int sizeend = medicalRecordList.size();
        assertThat(sizeend).isGreaterThan(sizestart);
    }

    @Test
    public void getAllMedicalRecordTest(){
        assertThat(medicalRecordController.getAllMedicalRecord()).isNotNull();
    }

    @Test
    public void updateMedicalRecordTest(){
        List<MedicalRecord> medicalRecordList = medicalRecordRepository.medicalRecordList();
        String firstName = "John";
        String lastName = "Boyd";
        String[] medication = new String[1];
        String[] allergies = new String[1];
        MedicalRecord medicalRecord = new MedicalRecord("Kendrik", "Stelzer", "03/06/2014",medication,allergies);
        assertThat(medicalRecordController.updateMedicalRecord(firstName,lastName,medicalRecord).getBirthdate().equals(""));
    }

    @Test
    public void deletMedicalRecordTest(){
        List<MedicalRecord> medicalRecordList = medicalRecordRepository.medicalRecordList();
        int sizestart = medicalRecordList.size();
        medicalRecordController.deleteMedicalRecord("John","Boyd");
        int sizeend = medicalRecordList.size();
        assertThat(sizestart).isGreaterThan(sizeend);
    }
}
