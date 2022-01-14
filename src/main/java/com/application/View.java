package com.application;

import org.w3c.dom.ranges.Range;

import java.util.Scanner;
import java.util.stream.IntStream;

public class View {

    FileManager fileManager = new FileManager();

    public void userExistView(String login){
        if (fileManager.userExist(login)){
            System.out.println("User Exist");
        }else {
            System.out.println("User doesn't Exist");
        }
    }

    public void userInterface(){
        System.out.println("Hello");
        System.out.println("To create/add User press 1.");
        System.out.println("To Log in 2.");
        System.out.println("To check if user exist press 3.");
        System.out.println("Remove user press 4.");
    }


    public void userInteraction(){

        Scanner scan = new Scanner(System.in);
        String dataFromUser = scan.nextLine();
        int userNumber = Integer.parseInt(dataFromUser);


        switch (userNumber) {
            case 1: // create user
                System.out.println("Set login");
                String login = scan.nextLine();
                System.out.println("Set password");
                String pass = scan.nextLine();
                fileManager.createUser(login,pass);
                break;
            case 2:
                System.out.println("Login");
                String login2 = scan.nextLine();
                System.out.println("Password");
                String pass2 = scan.nextLine();
                fileManager.checkLoginAndPassword(login2, pass2);
                break;
            case 3: // check if user exist
                System.out.println("Enter login");
                String login3 = scan.nextLine();
                userExistView(login3);
                break;
            case 4: // remove user
                System.out.println("Set login");
                String login4 = scan.nextLine();
                fileManager.deleteUser(login4);
                break;
        }

    }

}
