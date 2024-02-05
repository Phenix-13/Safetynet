package com.Phenix13.Safetynet.service;

import com.Phenix13.Safetynet.model.FireStation;
import com.Phenix13.Safetynet.model.Person;
import com.Phenix13.Safetynet.repository.FireStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireStationService {
    public final FireStationRepository fireStationRepository;

    public FireStationService(FireStationRepository fireStationRepository) {
        this.fireStationRepository = fireStationRepository;
    }


    public FireStation postFireStation(FireStation firestion){
        return fireStationRepository.postFireStation(firestion);
    }
    public List<FireStation> getAllFireStation() {return fireStationRepository.fireStationList();}

    public FireStation updateFireStation(String address,FireStation newfireStation){
        for(FireStation fireStation:fireStationRepository.fireStationList()){
            if (fireStation.getAddress().equals(address)){
                fireStationRepository.updateFireStation(fireStation,newfireStation);
                break;
            }
        }
        return newfireStation;
    }

    public void deleteFireStation(String address){
        int index = 0;
        for(FireStation fireStation:fireStationRepository.fireStationList()){
            if (fireStation.getAddress().equals(address)){
                fireStationRepository.deleteFireStation(index);
                break;
            }
            index ++;
        }
    }
}
