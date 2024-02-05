package com.Phenix13.Safetynet.repository;

import com.Phenix13.Safetynet.model.FireStation;
import com.Phenix13.Safetynet.model.MedicalRecord;
import com.Phenix13.Safetynet.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PersonRepository {
    public final DataHandler dataHandler;

    public PersonRepository(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    public List<String> communityEmail() {
        List<Person> personList = dataHandler.getData().getPersons();
        List<String> listEmail = new ArrayList<>();
        for (Person person : personList) {
            listEmail.add(person.getEmail());
        }
        return listEmail;
    }

    public List<Person> personList() {
        List<Person> personList = dataHandler.getData().getPersons();
        return personList;
    }

    public List<MedicalRecord> medicalRecordList(){
        return dataHandler.getData().getMedicalrecords();
    }

    public Person postPerson(Person person){
        List<Person> personList = dataHandler.getData().getPersons();
        personList.add(new Person(person.getFirstName(),person.getLastName(),person.getAddress(),person.getCity(),person.getZip(),person.getPhone(),person.getEmail()));
        return person;
    }
    public Person updatePerson(Person person,Person putperson){
        person.setAddress(putperson.getAddress());
        person.setCity(putperson.getCity());
        person.setZip(putperson.getZip());
        person.setPhone(putperson.getPhone());
        person.setEmail(putperson.getEmail());
        return person;
    }
    public void deletePerson(int index){
        personList().remove(index);
    }
}
