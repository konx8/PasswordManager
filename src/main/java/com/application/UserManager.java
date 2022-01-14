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
        }
    }

    public void deleteUser(String login) {
        if (userExist(login)) {
            for (User setObj : fileManager.getDataFromFile()) {
                if(setObj.getLogin().equals(login)){
                    Set<User> userListToUpdate = fileManager.getDataFromFile();
                    userListToUpdate.remove(setObj);
                    fileManager.saveDataToFile(userListToUpdate);
                    System.out.println("User " + login + " removed");
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
                    System.out.println("logged");
                    return true;
                }else {
                    System.out.println("Wrong password");
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

    public void logged(String login,String pass){
        if(checkLoginAndPassword(login, pass)){
            System.out.println("Hello " + login);
            System.out.println("To add web");


        }
        else {
            System.out.println("Wrong login or password");
        }
    }

    public void addWebData(String log, String webName, String loginToWeb, String passToWeb){

        User user = getUserByLogin(log);
        Set<PasswordData> data = user.getSavePasswords();
        if (data == null) {
            user.setSavePasswords(Set.of(new PasswordData(webName,loginToWeb,passToWeb)));
            fileManager.saveDataToFile(Collections.singleton(user));
        }else {
            data.add(new PasswordData(webName,loginToWeb,passToWeb));
            fileManager.saveDataToFile(data);
        }

    }


}
