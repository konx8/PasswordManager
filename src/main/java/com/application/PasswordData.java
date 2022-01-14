package com.application;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor

public class PasswordData {

    private static final AtomicInteger count = new AtomicInteger(0);

    private int id;
    private String webName;
    private String login;
    private String password;


    public PasswordData(String webName,String login, String password) {
        this.id = count.incrementAndGet();
        this.login = login;
        this.webName = webName;
        this.password = password;
    }
}
