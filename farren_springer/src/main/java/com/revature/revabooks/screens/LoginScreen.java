package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginScreen {

    private UserService userService;

    public LoginScreen() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
        userService = new UserService();
    }

    /**
     * Renders the login screen menu to the console.
     */
    public void render() {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String username, password;

        try {
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = console.readLine();
            System.out.println("Password: ");
            password = console.readLine();

            System.out.println("You entered: " + username + " " + password);

            AppUser authUser = userService.authenticate(username, password);
            System.out.println(authUser
            );
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } // better to use try/catch block than add throws to the renders method signature


    }
}
