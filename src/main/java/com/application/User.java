package com.application;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class User {

    private String login;
    private String password;
    private Set<PasswordData> savePasswords;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, Set<PasswordData> savePasswords) {
        this.login = login;
        this.password = password;
        this.savePasswords = savePasswords;
    }

    public User() {
    }
}
