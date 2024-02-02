package com.Phenix13.Safetynet.service.DTO;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StationNumberDTO {
    private Integer nbChild;
    private Integer nbAdult;
    private List<PersonByStationDTO> personByStationDTOList;

    public Integer getNbChild() {
        return nbChild;
    }

    public void setNbChild(Integer nbChild) {
        this.nbChild = nbChild;
    }

    public Integer getNbAdult() {
        return nbAdult;
    }

    public void setNbAdult(Integer nbAdult) {
        this.nbAdult = nbAdult;
    }

    public List<PersonByStationDTO> getPersonByStationDTOList() {
        return personByStationDTOList;
    }

    public void setPersonByStationDTOList(List<PersonByStationDTO> personByStationDTOList) {
        this.personByStationDTOList = personByStationDTOList;
    }

    public StationNumberDTO(Integer nbChild, Integer nbAdult, List<PersonByStationDTO> personByStationDTOList) {
        this.nbChild = nbChild;
        this.nbAdult = nbAdult;
        this.personByStationDTOList = personByStationDTOList;
    }

    public StationNumberDTO() {
    }
}
