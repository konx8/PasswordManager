package com.application.Manager;

import com.application.Data.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileManager {

    File dataFile = new File("User.json");
    ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);;

    public void saveDataToFile(Set<User> list){
        try {
            objectMapper.writeValue(dataFile,list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<User> getDataFromFile(){
        try {
            return objectMapper.readValue(dataFile, new TypeReference<Set<User>>(){});
        } catch (IOException e) {
            return new HashSet<>();
        }
    }

}


