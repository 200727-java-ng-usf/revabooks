package com.revature.revabooks;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.screens.LoginScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {
    public static void main(String[] args) {
//        Boolean appRunning = false;
//        AppUser currentUser = new AppUser();
//
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.render();
    }
}
