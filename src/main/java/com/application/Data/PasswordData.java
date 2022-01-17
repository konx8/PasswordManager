package com.application.Data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PasswordData {

    private String webName;
    private String login;
    private String password;

    public PasswordData(String webName,String login, String password) {
        this.login = login;
        this.webName = webName;
        this.password = password;
    }


}
