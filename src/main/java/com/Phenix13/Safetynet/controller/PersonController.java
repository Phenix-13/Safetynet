package com.Phenix13.Safetynet.controller;

import com.Phenix13.Safetynet.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    public final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("communityEmail")
    public List<String> communityEmail(){
        return personService.communityEmail();
    }
    @GetMapping("phoneAlert")
    public List<String> phoneAlert(@RequestParam(name = "firestation") String station){
        return personService.phoneAlert(station);
    }
}
