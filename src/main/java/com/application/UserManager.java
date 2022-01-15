package com.application;

import java.io.IOException;
import java.util.*;

public class UserManager {

    FileManager fileManager = new FileManager();

    public void createUser(String login, String pass){
        if(!fileManager.dataFile.exists()) {
            try {
                fileManager.objectMapper.writeValue(fileManager.dataFile, "");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!userExist(login)){
            addUserToExistingList(login, pass);
        }else {
            System.out.println("User already exist");
        }
    }

    public void deleteUser(String login) {
        if (userExist(login)) {
            for (User setObj : fileManager.getDataFromFile()) {
                if(setObj.getLogin().equals(login)){
                    Set<User> userListToUpdate = fileManager.getDataFromFile();
                    userListToUpdate.remove(setObj);
                    fileManager.saveDataToFile(userListToUpdate);
                }
            }
        }
    }

    public boolean userExist(String login ){
        for(User setObj : fileManager.getDataFromFile()){
            if(setObj.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    public void addUserToExistingList(String login, String pass){
        Set<User> userListToUpdate = fileManager.getDataFromFile();
        userListToUpdate.add(new User(login,pass));
        fileManager.saveDataToFile(userListToUpdate);
    }

    public boolean checkLoginAndPassword(String login, String pass) {

        for(User setObj : fileManager.getDataFromFile()){
            if(setObj.getLogin().equals(login) ){
                if (setObj.getPassword().equals(pass)){
                    return true;
                }
            }
        }
        return false;
    }

    public User getUserByLogin(String log){
        for(User setObj : fileManager.getDataFromFile()){
            if(setObj.getLogin().equals(log) ){
                return setObj;
            }
        }
        return null;
    }

    public boolean logged(String login,String pass){
        return checkLoginAndPassword(login, pass);
    }

    public void getAllUsers(){

        for(User user : fileManager.getDataFromFile()){
            System.out.println(user.getLogin()+"\n");
        }
    }

}
