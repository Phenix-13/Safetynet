package com.Phenix13.Safetynet.controller;
import com.Phenix13.Safetynet.model.FireStation;
import com.Phenix13.Safetynet.service.FireStationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FireStationController {
    public final FireStationService fireStationService;

    public FireStationController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    @PostMapping("firestation")
    public FireStation addFirestation(@RequestBody FireStation firestion){
        return fireStationService.postFireStation(firestion);
    }

    @GetMapping("firestations")
    public List<FireStation> getAllFireStation(){return fireStationService.getAllFireStation();
    }
    @PutMapping("firestation")
    public FireStation updateFireStation(@RequestParam(name="address")String address,@RequestBody FireStation firestation){
        return fireStationService.updateFireStation(address,firestation);
    }
    @DeleteMapping("firestation")
    public void deleteFireStation(@RequestParam(name="address")String address){
        fireStationService.deleteFireStation(address);
    }

}
