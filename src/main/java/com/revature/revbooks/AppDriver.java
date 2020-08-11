package com.revature.revbooks;

import com.revature.revbooks.screens.LoginScreen;

public class AppDriver {
    public static void main(String[] args) {

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.render();

    }
}
