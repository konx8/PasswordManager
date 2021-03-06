package com.application.Manager;

import com.application.Data.PasswordData;
import com.application.Data.User;

import java.util.HashSet;
import java.util.Set;

public class PasswordPageManager {

    UserManager userManager = new UserManager();
    FileManager fileManager = new FileManager();

    public void addWebData(String log, String webName, String loginToWeb, String passToWeb){

        User user = userManager.getUserByLogin(log);
        Set<User> userList = fileManager.getDataFromFile();
        if(userManager.userExist(log)) {
            if (user.getSavePasswords() == null) {
                for (User setObj : userList) {
                    setObj.setSavePasswords(Set.of(new PasswordData(webName, loginToWeb, passToWeb)));
                    fileManager.saveDataToFile(userList);
                }
            } else if (!checkIfPageAlreadyExist(webName)) {
                {
                    for (User setObj : userList) {
                        if (setObj.getLogin().equals(log)) {
                            setObj.getSavePasswords().add(new PasswordData(webName, loginToWeb, passToWeb));
                            fileManager.saveDataToFile(userList);
                        }
                    }
                }
            }
        }
    }

    public boolean checkIfPageAlreadyExist(String webName){
        for(User user : fileManager.getDataFromFile()){
            for(PasswordData pd : user.getSavePasswords()){
                if(pd.getWebName().equals(webName)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIfPageIsNull(String log){
        return userManager.getUserByLogin(log).getSavePasswords() == null;
    }

    public void deletePage(String log, String webName){

        User user = userManager.getUserByLogin(log);
        User userToUpdate = new User(user.getLogin(), user.getPassword());
        Set<User> userList = fileManager.getDataFromFile();

        Set<PasswordData> passwordData = new HashSet<>();

        Set<User> userListToUpdate = fileManager.getDataFromFile();
        if (checkIfPageAlreadyExist(webName)) {
            for (User setObj : userListToUpdate) {
                if (setObj.getLogin().equals(log)) {
                    for (PasswordData passData : setObj.getSavePasswords()) {
                        if (!passData.getWebName().equals(webName)) {
                            passwordData.add(passData);
                        }
                    }
                }
            }
        }
        userToUpdate.setSavePasswords(passwordData);
        for (User setObj : userList) {
            if (setObj.getLogin().equals(log)) {
                setObj.setSavePasswords(userToUpdate.getSavePasswords());
                fileManager.saveDataToFile(userList);
            }
        }
    }

    public void listOfPages(String log){

    Set<PasswordData> userListToUpdate = new HashSet<>();
        for (User setObj : fileManager.getDataFromFile()) {
            if (setObj.getLogin().equals(log)) {
                userListToUpdate.addAll(setObj.getSavePasswords());
            }
        }
        System.out.println(userListToUpdate);

    }

    public void viewAllPages(String login){
        for (User setObj : fileManager.getDataFromFile()) {
            if(setObj.getSavePasswords() != null) {
                if (setObj.getLogin().equals(login)) {
                    for (PasswordData passData : setObj.getSavePasswords()) {
                        System.out.println(passData.getWebName());
                    }
                }
            }
        }
    }

    public void getPassword(String log, String webName){

        for (User setObj : fileManager.getDataFromFile()) {
            if (setObj.getLogin().equals(log)) {
                if (checkIfPageAlreadyExist(webName)){
                    for (PasswordData passData : setObj.getSavePasswords()) {
                        if(passData.getWebName().equals(webName))
                            System.out.println(passData.getPassword());
                    }
                }else {
                    System.out.println("Password has not been created for the page.");
                }
            }
        }
    }

}
