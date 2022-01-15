package com.application;

import java.util.Scanner;

public class UserView {

    UserManager userManager = new UserManager();
    PasswordPageManager ppm = new PasswordPageManager();

    public void userInterface(){

        System.out.println("To create/add User press 1.");
        System.out.println("To Log in 2.");
        System.out.println("To check if user exist press 3.");
        System.out.println("Remove user press 4.");
        System.out.println("Display all users 5.");
        System.out.println("Press 0 to exit.");
        System.out.println("");
    }

    public void loggedInterface(String login2){

        Scanner scan2 = new Scanner(System.in);
        int exit = 0;
        while (exit == 0) {

            System.out.println("");
            System.out.println("To add password press 1.");
            System.out.println("To remove password press 2.");
            System.out.println("View all saved pages 3.");
            System.out.println("Get password to page 4.");
            System.out.println("Go back press 0.");
            System.out.println("");

            String dataFromUser = scan2.nextLine();
            int userNumber = Integer.parseInt(dataFromUser);

            switch (userNumber) {
                case 1 -> {
                    System.out.println("WebName");
                    String webName = scan2.nextLine();
                    System.out.println("Login to web page");
                    String loginToWebName = scan2.nextLine();
                    System.out.println("Password to web page");
                    String passwordToWebName = scan2.nextLine();
                    ppm.addWebData(login2, webName, loginToWebName, passwordToWebName);
                }
                case 2 -> {
                    System.out.println("Enter the page you want to delete");
                    String webName = scan2.nextLine();

                    ppm.deletePage(login2,webName);
                }
                case 3 -> {
                    System.out.println("Passwords saved on pages:");
                    ppm.viewAllPages(login2);
                }
                case 4 -> {
                    System.out.println("Password for the page you want to receive");
                    String webName = scan2.nextLine();
                    ppm.getPassword(login2,webName);
                }

                case 5 ->{
                    ppm.listOfPages(login2);
                }
                case 0 -> {
                    exit = 1;
                }
            }
        }
    }

    public void userInteraction() {

        Scanner scan = new Scanner(System.in);
        int exit = 0;

        System.out.println("Hello");

        while (exit == 0) {

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
                    System.out.println("");
                }
                case 2 -> {
                    System.out.println("Login");
                    String login2 = scan.nextLine();
                    System.out.println("Password");
                    String pass2 = scan.nextLine();
                    if (userManager.logged(login2, pass2)) {
                        System.out.println("Logged");
                        loggedInterface(login2);
                    }else {
                        System.out.println("Wrong login or password");
                    }
                    System.out.println("");
                }
                case 3 -> { // check if user exist
                    System.out.println("Enter login");
                    String login3 = scan.nextLine();
                    if(userManager.userExist(login3)){
                        System.out.println("User exist");
                    }else {
                        System.out.println("User doesn't exist");
                    }
                    System.out.println("");
                }
                case 4 -> { // remove user
                    System.out.println("Set login");
                    String login4 = scan.nextLine();
                    userManager.deleteUser(login4);
                    System.out.println("User " +login4+ " remover.");
                    System.out.println("");
                }
                case 5 -> {
                    userManager.getAllUsers();
                }

                case 0 -> {
                    exit = 1;
                }

            }
        }
    }



}
