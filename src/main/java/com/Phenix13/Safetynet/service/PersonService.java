package com.Phenix13.Safetynet.service;

import com.Phenix13.Safetynet.model.Data;
import com.Phenix13.Safetynet.model.FireStation;
import com.Phenix13.Safetynet.model.MedicalRecord;
import com.Phenix13.Safetynet.model.Person;
import com.Phenix13.Safetynet.repository.FireStationRepository;
import com.Phenix13.Safetynet.repository.PersonRepository;
import com.Phenix13.Safetynet.service.DTO.Child;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class PersonService {
    public final PersonRepository personRepository;
    public final FireStationRepository fireStationRepository;
    public final Child child;

    public PersonService(PersonRepository personRepository, FireStationRepository fireStationRepository, Child child) {
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
        this.child = child;
    }

    public List<String> communityEmail(){
        return personRepository.communityEmail();
    }

    public List<String> phoneAlert(String station){
        List<FireStation> fireStationList = fireStationRepository.fireStationList();
        List<Person> personList = personRepository.personList();
        List<String> listPhoneNumber = new ArrayList<>();

        for (FireStation fireStation:fireStationList){
            if (Objects.equals(fireStation.getStation(), station)) {
                for (Person person : personList) {
                    if (Objects.equals(fireStation.getAddress(), person.getAddress())) {
                        listPhoneNumber.add(person.getPhone());
                    }
                }
            }
        }
        return listPhoneNumber;
    }

    public List<Child> childAlert(String address) throws ParseException {
        List<Child> childList = new ArrayList<>();
        List<MedicalRecord> medicalRecords = personRepository.medicalRecordList();
        List<Person> personList = personRepository.personList();
        for (Person person:personList) {
            for(MedicalRecord medicalRecord:medicalRecords){
                if(person.getFirstName().equals(medicalRecord.getFirstName()) && person.getLastName().equals(medicalRecord.getLastName()) && person.getAddress().equals(address)) {
                    Integer age = parseAge(medicalRecord.getBirthdate());

                    if (age <= 18) {
                        List<Person> familyMember = new ArrayList<>();
                        for (Person people : personList) {
                            if (person.getAddress().equals(people.getAddress())) {
                                familyMember.add(people);
                            }
                        }
                        Child child = new Child();
                        child.setAge(age.toString());
                        child.setFirstName(person.getFirstName());
                        child.setLastName(person.getLastName());
                        child.setFamilyMember(familyMember);
                        childList.add(child);
                    }
                }
            }
        }
        return childList;
    }
    public Integer parseAge(String birthDate) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatIn = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatOut = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(birthDate, formatIn);
        date.format(formatOut);
        return Period.between(date,today).getYears();
    }

}
