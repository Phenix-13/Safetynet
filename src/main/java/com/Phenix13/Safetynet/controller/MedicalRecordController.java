package com.Phenix13.Safetynet.controller;

import com.Phenix13.Safetynet.model.MedicalRecord;
import com.Phenix13.Safetynet.service.MedicalRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalRecordController {
    public final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }


    @PostMapping("medicalRecord")
    public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord medicalRecord){
        return medicalRecordService.postMedicalRecord(medicalRecord);
    }

    @GetMapping("medicalRecord")
    public List<MedicalRecord> getAllMedicalRecord(){
        return medicalRecordService.getAllMedicalRecord();
    }
    @PutMapping("medicalRecord")
    public MedicalRecord updateMedicalRecord(@RequestParam(name="firstName")String firstName,@RequestParam(name="lastName") String lastName,@RequestBody MedicalRecord medicalRecord){
        return medicalRecordService.updateMedicalRecord(firstName,lastName,medicalRecord);
    }
    @DeleteMapping("medicalRecord")
    public void deleteMedicalRecord(@RequestParam(name="firstName")String firstName,@RequestParam(name="lastName") String lastName) {
        medicalRecordService.deleteMedicalRecord(firstName, lastName);
    }
}
