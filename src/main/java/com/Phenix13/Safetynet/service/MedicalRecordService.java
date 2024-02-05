package com.Phenix13.Safetynet.service;

import com.Phenix13.Safetynet.model.MedicalRecord;
import com.Phenix13.Safetynet.model.Person;
import com.Phenix13.Safetynet.repository.MedicalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {
    public final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public MedicalRecord postMedicalRecord(MedicalRecord medicalRecord){
        return medicalRecordRepository.postMedicalRecord(medicalRecord);
    }

    public List<MedicalRecord> getAllMedicalRecord(){
        return medicalRecordRepository.medicalRecordList();
    }

    public MedicalRecord updateMedicalRecord(String firstName, String lastName, MedicalRecord newmedicalrecord){
        for(MedicalRecord medicalRecord:medicalRecordRepository.medicalRecordList()){
            if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName)){
                medicalRecordRepository.updateMedicalRecord(medicalRecord,newmedicalrecord);
                break;
            }
        }
        return newmedicalrecord;
    }

    public void deleteMedicalRecord(String firstName,String lastName){
        int index = 0;
        for (MedicalRecord medicalRecord:medicalRecordRepository.medicalRecordList()){
            if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName)){
                medicalRecordRepository.deleteMedicalRecord(index);
                break;
            }
            index ++;
        }
    }
}
