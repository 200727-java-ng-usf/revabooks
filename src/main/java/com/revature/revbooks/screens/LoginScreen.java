package com.revature.revbooks.screens;

import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginScreen {

    private UserService userService;

    public LoginScreen(){
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
        userService = new UserService();
    }


    /**
     * Renders the login screen menu to the console
     */
    public void render(){

        // BufferedReader object to read user input
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String username, password;

        try {
            System.out.println("Please provide your login credentials ");
            System.out.println("Username: ");
            username = console.readLine();

            System.out.println("Password: ");
            password = console.readLine();

            AppUser authUser = userService.authenticate(username,password);
            System.out.println(authUser);

            System.out.println("You entered Username: " + username + "  Password: " + password);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
