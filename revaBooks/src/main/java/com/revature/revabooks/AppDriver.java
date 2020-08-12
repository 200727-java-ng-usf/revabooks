package com.revature.revabooks;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.screens.LoginScreen;
import com.revature.revabooks.screens.RegisterScreen;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {
    public static void main(String[] args) {

        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo);

        RegisterScreen registerScreen = new RegisterScreen(userService);
        registerScreen.render();

        LoginScreen loginScreen = new LoginScreen(userService);
        loginScreen.render();
    }
}
