package com.revature.revabooks;

import com.revature.revabooks.repos.UserRepo;
import com.revature.revabooks.screens.LoginScreen;
import com.revature.revabooks.screens.RegisterScreen;
import com.revature.revabooks.services.UserService;

public class AppDriver {

    public static void main(String[] args) {

        UserRepo userRepo = new UserRepo();
        UserService userService = new UserService(userRepo);

        RegisterScreen registerScreen= new RegisterScreen(userService);
        registerScreen.render();

        LoginScreen loginScreen = new LoginScreen(userService);
        loginScreen.render();

    }
}
