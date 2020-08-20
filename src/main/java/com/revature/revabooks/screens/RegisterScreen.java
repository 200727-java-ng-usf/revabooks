package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;
import static com.revature.revabooks.AppDriver.app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegisterScreen extends Screen {

    private UserService userService;


    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");
        this.userService = userService;
    }

    @Override
    public void render() {

        String firstname, lastname, username, password;

        try {
            System.out.println("Sign up for a new account.");
            System.out.print("first name: ");
            firstname = app.getConsole().readLine();
            System.out.print("last name: ");
            lastname = app.getConsole().readLine();
            System.out.print("Username: ");
            username = app.getConsole().readLine();
            System.out.println("Password: ");
            password = app.getConsole().readLine();

            AppUser newUser = new AppUser(firstname, lastname, username, password);
            userService.register(newUser);

            if (app.isSessionValid()) {
                app.getRouter().navigate("/home");
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}