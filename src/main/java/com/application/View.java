package com.application;

import java.util.Scanner;

public class View {

    FileManager fileManager = new FileManager();
    UserManager userManager = new UserManager();

    public void userInterface(){
        System.out.println("Hello");
        System.out.println("To create/add User press 1.");
        System.out.println("To Log in 2.");
        System.out.println("To check if user exist press 3.");
        System.out.println("Remove user press 4.");
    }

    public void userInteraction() {

        Scanner scan = new Scanner(System.in);

        while (true) {

            userInterface();

            String dataFromUser = scan.nextLine();
            int userNumber = Integer.parseInt(dataFromUser);

            switch (userNumber) {
                case 1 -> { // create user
                    System.out.println("Set login");
                    String login = scan.nextLine();
                    System.out.println("Set password");
                    String pass = scan.nextLine();
                    userManager.createUser(login, pass);
                }
                case 2 -> {
                    System.out.println("Login");
                    String login2 = scan.nextLine();
                    System.out.println("Password");
                    String pass2 = scan.nextLine();
                    userManager.logged(login2, pass2);
                }
                case 3 -> { // check if user exist
                    System.out.println("Enter login");
                    String login3 = scan.nextLine();
                    if(userManager.userExist(login3)){
                        System.out.println("User exist");
                    }else {
                        System.out.println("User doesn't exist");

                    }
                }
                case 4 -> { // remove user
                    System.out.println("Set login");
                    String login4 = scan.nextLine();
                    userManager.deleteUser(login4);
                }
                case 5 -> {
                    System.out.println("Login");
                    String log = scan.nextLine();
                    System.out.println("WebName");
                    String webName = scan.nextLine();
                    System.out.println("Login to web page");
                    String loginToWebName = scan.nextLine();
                    System.out.println("Password to web page");
                    String passwordToWebName = scan.nextLine();
                    userManager.addWebData(log,webName, loginToWebName, passwordToWebName);
                }
            }
        }
    }



}
