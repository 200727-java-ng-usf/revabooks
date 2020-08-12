package com.revature.revabooks;

import com.revature.revabooks.screens.LoginScreen;
import com.revature.revabooks.screens.RegisterScreen;

public class AppDriver {
    public static void main(String[] args) {

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.render();

        RegisterScreen registerScreen = new RegisterScreen();
        registerScreen.render();
    }
}
