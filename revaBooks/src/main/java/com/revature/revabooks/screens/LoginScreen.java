package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.revature.revabooks.AppDriver.app;

public class LoginScreen extends Screen {

    // UserService is a dependency to the LoginScreen
    private UserService userService;

    // Inject the dependency through the constructor (constructor injection)
    public LoginScreen(UserService userService) {
        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());

        // loosely coupled, because this class is not responsible for instantiation of a UserService
        this.userService = userService;

//        userService = new UserService();

    }

    /**
     * Renders the login screen menu to the console.
     */
    public void render() {


        String username, password;

        try {
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = app.getConsole().readLine();
            System.out.print("Password: ");
            password = app.getConsole().readLine();

            userService.authenticate(username, password);

            if (app.isSessionValid()) {
                app.getRouter().navigate("/dashboard");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
