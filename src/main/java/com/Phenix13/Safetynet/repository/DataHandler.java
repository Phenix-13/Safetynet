package com.Phenix13.Safetynet.repository;

import com.Phenix13.Safetynet.model.Data;
import com.Phenix13.Safetynet.model.Person;
import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import java.io.*;
import java.nio.charset.StandardCharsets;

@Component
public class DataHandler {

    private final Data data;

    public DataHandler() throws IOException{
        String temp = getFromResource("data.json");
        this.data = JsonIterator.deserialize(temp,Data.class);
    }

    private String getFromResource(String s) throws IOException {
        InputStream is = new ClassPathResource(s).getInputStream();
        return IOUtils.toString(is, StandardCharsets.UTF_8);
    }


    public Data getData() {
        return data;
    }

}
