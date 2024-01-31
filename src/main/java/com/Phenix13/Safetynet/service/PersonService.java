package com.Phenix13.Safetynet.service;

import com.Phenix13.Safetynet.model.FireStation;
import com.Phenix13.Safetynet.model.Person;
import com.Phenix13.Safetynet.repository.FireStationRepository;
import com.Phenix13.Safetynet.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonService {
    public final PersonRepository personRepository;
    public final FireStationRepository fireStationRepository;

    public PersonService(PersonRepository personRepository, FireStationRepository fireStationRepository) {
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
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
}
