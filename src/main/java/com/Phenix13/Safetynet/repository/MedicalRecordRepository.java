package com.Phenix13.Safetynet.repository;

import com.Phenix13.Safetynet.model.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MedicalRecordRepository {
    public final DataHandler dataHandler;

    public MedicalRecordRepository(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }
    public List<MedicalRecord> medicalRecordList(){return dataHandler.getData().getMedicalrecords();}

    public MedicalRecord postMedicalRecord(MedicalRecord medicalRecord){
        medicalRecordList().add(new MedicalRecord(medicalRecord.getFirstName(),medicalRecord.getLastName(),medicalRecord.getBirthdate(),medicalRecord.getMedications(),medicalRecord.getAllergies()));
        return medicalRecord;
    }

    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord, MedicalRecord newmedicalrecord){
        medicalRecord.setBirthdate(newmedicalrecord.getBirthdate());
        medicalRecord.setMedications(newmedicalrecord.getMedications());
        medicalRecord.setAllergies(newmedicalrecord.getAllergies());
        return medicalRecord;
    }
    public void deleteMedicalRecord(int index){
        medicalRecordList().remove(index);
    }
}
