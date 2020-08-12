package com.revature.revabooks;

import com.revature.revabooks.screens.LoginScreen;

import java.io.IOException;

public class AppDriver {

    public static void main(String[] args) throws IOException {

        LoginScreen loginScreen = new LoginScreen();
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