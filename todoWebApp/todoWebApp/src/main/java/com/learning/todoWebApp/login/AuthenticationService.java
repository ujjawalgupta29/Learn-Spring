package com.learning.todoWebApp.login;

import org.springframework.stereotype.Service;

//To authenticate a user
@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        boolean isValidUser = username.equals("Ujjawal");
        boolean isValidPwd = password.equals("123");

        return isValidUser && isValidPwd;
    }
}
