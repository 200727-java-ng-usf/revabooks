package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

import java.io.IOException;

import static com.revature.revabooks.AppDriver.app;

public class LoginScreen extends Screen {

    private UserService userService;

    public LoginScreen(UserService userService) {
        super("Login Screen", "/login");
    }

    @Override
    public void render() {

        String username, password;

        try {
            System.out.println("Please provide your login credentials.");
            System.out.print("Username: ");
            username = app.getConsole().readLine();

            System.out.println("Password: ");
            password = app.getConsole().readLine();

            System.out.println("You entered username: " + username + " / " + password);

            app.setCurrentUser(userService.authenticate(username, password));


            if (app.isSessionValid()) {
                app.getRouter().navigate("/dashboard");
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
