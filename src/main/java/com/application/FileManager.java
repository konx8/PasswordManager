package com.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileManager {

    File dataFile = new File("User.json");
    ObjectMapper objectMapper = new ObjectMapper();

    public boolean userExist(String login ){
        for(User setObj : getDataFromFile()){
            if(setObj.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    public void updateDataToFile(Set<User> list){
        try {
            objectMapper.writeValue(dataFile,list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createUser(String login, String pass){

        if(!dataFile.exists()) {
            try {
                objectMapper.writeValue(dataFile, "");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(userExist(login)){
            System.out.println("User exist !!!");
        }else {
            addUserToExistingList(login, pass);
        }
    }

    public void deleteUser(String login) {

        if (userExist(login)) {
            for (User setObj : getDataFromFile()) {
                Set<User> userListToUpdate = getDataFromFile();
                userListToUpdate.remove(setObj);
                updateDataToFile(userListToUpdate);
                System.out.println("User " + login + " removed");
            }
        } else {
            System.out.println("User doesn't exist ");
        }
    }

    public void addUserToExistingList(String login, String pass){
        Set<User> userListToUpdate = getDataFromFile();
        userListToUpdate.add(new User(login,pass));
        updateDataToFile(userListToUpdate);
    }

    public Set<User> getDataFromFile(){
        try {
            return objectMapper.readValue(dataFile, new TypeReference<Set<User>>(){});
        } catch (IOException e) {
            return new HashSet<>();
        }
    }

    public void checkLoginAndPassword(String login, String pass) {

        for(User setObj : getDataFromFile()){

            if(setObj.getLogin().equals(login) ){
                if (setObj.getPassword().equals(pass)){
                    System.out.println("logged");
                }else {
                    System.out.println("Wrong password");
                }

            }
//            else {
//                System.out.println("User doesn't exist");
//            }
//            else if (!setObj.getLogin().equals(login) || !setObj.getPassword().equals(pass)){
//                System.out.println("Wrong login or password");
//            }

        }

    }



}


