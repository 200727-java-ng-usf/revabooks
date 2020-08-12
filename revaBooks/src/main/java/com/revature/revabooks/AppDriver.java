package com.revature.revabooks;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.screens.LoginScreen;
import com.revature.revabooks.screens.RegisterScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {
    public static void main(String[] args) {
//
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.render();

        RegisterScreen registerScreen = new RegisterScreen();
        registerScreen.render();
    }
}
