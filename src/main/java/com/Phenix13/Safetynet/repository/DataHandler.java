package com.Phenix13.Safetynet.repository;

import com.Phenix13.Safetynet.model.Data;
import com.Phenix13.Safetynet.model.Person;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class DataHandler {

    private final Data data;

    public DataHandler() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            this.data = mapper.readValue(new File("src/main/resources/data.json"), Data.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Data getData() {
        return data;
    }
}
