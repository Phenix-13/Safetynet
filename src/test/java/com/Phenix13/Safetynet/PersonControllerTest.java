package com.Phenix13.Safetynet;

import com.Phenix13.Safetynet.controller.PersonController;
import com.Phenix13.Safetynet.model.Person;
import com.Phenix13.Safetynet.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class PersonControllerTest {
    @Autowired
    private PersonController personController;
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void communityEmailTest(){
        assertThat(personController.communityEmail()).isNotNull();
    }

    @Test
    public void phoneAlertTest(){
        assertThat(personController.phoneAlert("1")).isNotNull();
    }

    @Test
    public void childAlertTest() throws ParseException {
        assertThat(personController.childAlert("1509 Culver St")).isNotNull();
    }

    @Test
    public void fireStationTest(){
        assertThat(personController.fireStation("1")).isNotNull();
    }

    @Test
    public void personInfoDTOList(){
        assertThat(personController.personInfoDTOList("John","Boyd")).isNotNull();
    }

    @Test
    public void fireDTO(){
        assertThat(personController.fireDTO("1509 Culvert St")).isNotNull();
    }

    @Test
    public void floodDTO(){
        assertThat(personController.floodDTO(new ArrayList<String>(){{add("1");add("2");}})).isNotNull();
    }

    @Test
    public void addPersonTest(){
        List<Person> personList = personRepository.personList();
        int sizestart = personList.size();
        personController.addPerson(new Person("Alexis","Aujard","1 rue des 1","mehland","12345","888-888-888","a@mail.com"));
        int sizeend = personList.size();
        assertThat(sizeend).isGreaterThan(sizestart);
    }

    @Test
    public void getAllPersonTest(){
        assertThat(personController.getAllPerson()).isNotNull();
    }

    @Test
    public void updatePersonTest(){
        List<Person> personList = personRepository.personList();
        String firstName = "John";
        String lastName = "Boyd";
        Person person = new Person("Alexis","Aujard","1 rue des 1","mehland","12345","888-888-888","a@mail.com");
        assertThat(personController.updatePerson(firstName,lastName,person).getAddress().equals("1 rue des 1"));
    }

    @Test
    public void deletPersonTest(){
        List<Person> personList = personRepository.personList();
        int sizestart = personList.size();
        personController.deletePerson("John","Boyd");
        int sizeend = personList.size();
        assertThat(sizestart).isGreaterThan(sizeend);
    }
}
