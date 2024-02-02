package com.Phenix13.Safetynet.controller;

import com.Phenix13.Safetynet.service.DTO.ChildDTO;
import com.Phenix13.Safetynet.service.DTO.FireDTO;
import com.Phenix13.Safetynet.service.DTO.PersonInfoDTO;
import com.Phenix13.Safetynet.service.DTO.StationNumberDTO;
import com.Phenix13.Safetynet.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class PersonController {
    public final PersonService personService;
    public final ChildDTO child;
    public final StationNumberDTO stationNumberDTO;

    public PersonController(PersonService personService, ChildDTO child, StationNumberDTO stationNumberDTO) {
        this.personService = personService;
        this.child = child;
        this.stationNumberDTO = stationNumberDTO;
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
    public List<ChildDTO> childAlert(@RequestParam(name="address") String address) throws ParseException {
        return personService.childAlert(address);
    }

    @GetMapping("firestation")
    public StationNumberDTO fireStation(@RequestParam(name="stationNumber") String station){
        return personService.stationNumber(station);
    }

    @GetMapping("personInfo")
    public List<PersonInfoDTO> personInfoDTOList(@RequestParam(name="firstName") String firstName,@RequestParam(name="lastName")String lastName){
        return personService.personInfoDTOList(lastName);
    }

    @GetMapping("fire")
    public FireDTO fireDTO(@RequestParam(name = "address")String address){
        return personService.fireListPerson(address);
    }
}
