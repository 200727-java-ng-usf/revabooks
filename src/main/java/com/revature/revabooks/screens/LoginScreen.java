package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginScreen extends Screen {

    private UserService userService;

    public LoginScreen(UserService userService) {
        super("Login Screen", "/login");
        this.userService = userService;
    }

    @Override
    public void render() {

        String username, password;

        try {
            System.out.println("Please provide your login credentials.");
            System.out.print("Username: ");
            username = app.getconsole.readLine();

            System.out.println("Password: ");
            password = console.readLine();

            System.out.println("You entered username: " + username + " / " + password);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
