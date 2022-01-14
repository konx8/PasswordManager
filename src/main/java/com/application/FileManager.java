package com.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileManager {

    File dataFile = new File("User.json");
    ObjectMapper objectMapper = new ObjectMapper();

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


