package com.application;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private String login;
    private String password;
    private List<PasswordData> savePasswords;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, List<PasswordData> savePasswords) {
        this.login = login;
        this.password = password;
        this.savePasswords = savePasswords;
    }

    public User() {
    }
}
