package com.Phenix13.Safetynet.service.DTO;


import com.Phenix13.Safetynet.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Child {
    private String firstName;
    private String lastName;
    private String age;
    private List<Person> familyMember;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Person> getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(List<Person> familyMember) {
        this.familyMember = familyMember;
    }

    public Child(String firstName, String lastName, String age, List<Person> familyMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.familyMember = familyMember;

    }
    public Child(){

    }

}
