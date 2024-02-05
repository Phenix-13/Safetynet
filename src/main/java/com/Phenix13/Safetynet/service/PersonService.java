package com.Phenix13.Safetynet.service;

import com.Phenix13.Safetynet.model.FireStation;
import com.Phenix13.Safetynet.model.MedicalRecord;
import com.Phenix13.Safetynet.model.Person;
import com.Phenix13.Safetynet.repository.FireStationRepository;
import com.Phenix13.Safetynet.repository.PersonRepository;
import com.Phenix13.Safetynet.service.DTO.*;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonService {
    public final PersonRepository personRepository;
    public final FireStationRepository fireStationRepository;
    public final ChildDTO child;
    public final StationNumberDTO stationNumberDTO;
    public final FireDTO fireDTO;

    public PersonService(PersonRepository personRepository, FireStationRepository fireStationRepository, ChildDTO child, StationNumberDTO stationNumberDTO, FireDTO fireDTO) {
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
        this.child = child;
        this.stationNumberDTO = stationNumberDTO;
        this.fireDTO = fireDTO;
    }//meh

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

    public List<ChildDTO> childAlert(String address) throws ParseException {
        List<ChildDTO> childList = new ArrayList<>();
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
                        childList.add(new ChildDTO(person.getFirstName(),person.getLastName(),age.toString(),familyMember));
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
    public List<PersonInFireDTO> listPersonByAddress(String address){
        List<Person> personList = personRepository.personList();
        List<MedicalRecord> medicalRecordList = personRepository.medicalRecordList();
        List<PersonInFireDTO> personInFireDTOList = new ArrayList<>();

        for (Person person:personList){
            if (address.equals(person.getAddress())){
                for (MedicalRecord medicalRecord:medicalRecordList){
                    if (person.getLastName().equals(medicalRecord.getLastName()) && person.getFirstName().equals(medicalRecord.getFirstName())){
                        Integer age = parseAge(medicalRecord.getBirthdate());
                        personInFireDTOList.add(new PersonInFireDTO(person.getLastName(),person.getPhone(),age,medicalRecord.getMedications(),medicalRecord.getAllergies()));
                    }
                }
            }
        }
        return personInFireDTOList;
    }


    public StationNumberDTO stationNumber(String station){

        List<PersonByStationDTO> personByStationDTOList = new ArrayList<>();

        List<FireStation> fireStationList = fireStationRepository.fireStationList();
        List<Person> personList = personRepository.personList();
        List<MedicalRecord> medicalRecordList = personRepository.medicalRecordList();

        for (FireStation fireStation:fireStationList){
            if (fireStation.getStation().equals(station)){
                for (Person person:personList){
                    if (person.getAddress().equals(fireStation.getAddress())){
                        personByStationDTOList.add(
                                new PersonByStationDTO(person.getFirstName(),person.getLastName(),person.getAddress(),person.getPhone())
                        );
                    }
                }
            }
        }

        Integer nbChild = 0;
        Integer nbAdult = 0;
        for (PersonByStationDTO person:personByStationDTOList){
            for (MedicalRecord medicalRecord:medicalRecordList){
                if(person.getFirstName().equals(medicalRecord.getFirstName()) && person.getLastName().equals(medicalRecord.getLastName())){
                    Integer age = parseAge(medicalRecord.getBirthdate());

                    if (age <= 18) {
                        nbChild ++ ;
                    }
                    else {
                        nbAdult ++ ;
                    }
                }
            }
        }
        StationNumberDTO stationNumberDTO = new StationNumberDTO(nbChild,nbAdult,personByStationDTOList);
        return stationNumberDTO;
    }

    public List<PersonInfoDTO> personInfoDTOList(String lastName){
        List<PersonInfoDTO> personInfoDTOList = new ArrayList<>();

        List<Person> personList = personRepository.personList();
        List<MedicalRecord> medicalRecordList = personRepository.medicalRecordList();

        for (Person person:personList){
            if (person.getLastName().equals(lastName)){
                for (MedicalRecord medicalRecord:medicalRecordList){
                    if(person.getLastName().equals(medicalRecord.getLastName()) && person.getFirstName().equals(medicalRecord.getFirstName())){
                        Integer age = parseAge(medicalRecord.getBirthdate());
                        personInfoDTOList.add(new PersonInfoDTO(person.getLastName(),person.getAddress(),age,person.getEmail(),medicalRecord.getMedications(),medicalRecord.getAllergies()));
                    }
                }
            }
        }
    return personInfoDTOList;
    }
    public FireDTO fireListPerson(String address){

        List<FireStation> fireStationList = fireStationRepository.fireStationList();
        List<Person> personList = personRepository.personList();
        List<MedicalRecord> medicalRecordList = personRepository.medicalRecordList();
        List<PersonInFireDTO> personInFireDTOList = listPersonByAddress(address);

        String station="";
        for (FireStation fireStation:fireStationList){
            if (fireStation.getAddress().equals(address)){
                station = fireStation.getStation();
            }
        }
        return new FireDTO(personInFireDTOList,station);
    }

    public List<FloodDTO> floodDTOList(List<String> station){
        List<FloodDTO> floodDTOList = new ArrayList<>();
        List<FireStation> fireStationList = fireStationRepository.fireStationList();
        for (String stations:station){
            List<PersonByAddressDTO> personByAddressDTOList = new ArrayList<>();
            for (FireStation fireStation:fireStationList){
                if (stations.equals(fireStation.getStation())){
                    List<PersonInFireDTO> personInFireDTOList = listPersonByAddress(fireStation.getAddress());
                    personByAddressDTOList.add(new PersonByAddressDTO(fireStation.getAddress(),personInFireDTOList));
                }
            }
            floodDTOList.add(new FloodDTO(stations,personByAddressDTOList));
        }
        return floodDTOList;
    }

    ////////////////////////////////////////////// == ENDPOINT == //////////////////////////////////////////////

    public Person postPerson(Person person){
        return personRepository.postPerson(person);
    }

    public List<Person> getAllPerson(){
        return personRepository.personList();
    }
    public Person updatePerson(String firstName,String lastName,Person putperson){
        for(Person person:personRepository.personList()){
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)){
                personRepository.updatePerson(person,putperson);
                break;
            }
        }
        return putperson;
    }
    public void deletePerson(String firstName,String lastName){
        int index = 0;
        for (Person person:personRepository.personList()){
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)){
                personRepository.deletePerson(index);
                break;
            }
            index ++;
        }
    }



}
