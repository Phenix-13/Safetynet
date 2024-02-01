package com.Phenix13.Safetynet.controller;

import com.Phenix13.Safetynet.service.DTO.Child;
import com.Phenix13.Safetynet.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class PersonController {
    public final PersonService personService;
    public final Child child;

    public PersonController(PersonService personService, Child child) {
        this.personService = personService;
        this.child = child;
    }

    @GetMapping("communityEmail")
    public List<String> communityEmail(){
        return personService.communityEmail();
    }
    @GetMapping("phoneAlert")
    public List<String> phoneAlert(@RequestParam(name = "firestation") String station){
        return personService.phoneAlert(station);
    }
    @GetMapping("childAlert")
    public List<Child> childAlert(@RequestParam(name="address") String address) throws ParseException {
        return personService.childAlert(address);
    }
}
