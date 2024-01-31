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
}
