package com.revature.revabooks;

import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.screens.LoginScreen;
import com.revature.revabooks.screens.RegisterScreen;
import com.revature.revabooks.services.UserService;

import java.io.IOException;

public class AppDriver {

    public static void main(String[] args) throws IOException {

        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo);

        RegisterScreen registerScreen = new RegisterScreen(userService);
        registerScreen.render();

        LoginScreen loginScreen = new LoginScreen(userService);
        loginScreen.render();



    }

}


/*
    Basic user:
        can register for an account
        can login in using credentials
        search for books by title
        search for books by genre
        search for books by isbn
*/