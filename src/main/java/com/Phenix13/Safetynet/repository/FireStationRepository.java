package com.Phenix13.Safetynet.repository;

import com.Phenix13.Safetynet.model.FireStation;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FireStationRepository {
    public final DataHandler dataHandler;

    public FireStationRepository(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    public List<FireStation> fireStationList(){
        List<FireStation> fireStationList = dataHandler.getData().getFirestations();
        return fireStationList;
    }

    public FireStation postFireStation(FireStation firestion){
        fireStationList().add(new FireStation(firestion.getAddress(),firestion.getStation()));
        return firestion;
    }

    public FireStation updateFireStation(FireStation fireStation,FireStation newfireStation){
        fireStation.setStation(newfireStation.getStation());
        return fireStation;
    }

    public void deleteFireStation(int index){
        fireStationList().remove(index);
    }
}
