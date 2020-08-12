package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

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
     * Renders the login screen menu to the console.
     */
    public void render(){
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String userName, password;

        //not parsing text, no ints or floats, anticipate all strings
        try {
            System.out.println("Please provide login credentials");
            System.out.println("Username: ");
            userName = console.readLine();
            System.out.println("Password: ");
            password = console.readLine();
            System.out.println("you entered: " + userName + "/" + password);
            AppUser authUser = userService.authenticate(userName, password);
            System.out.println(authUser);
        }
        catch (Exception E ){
            E.printStackTrace();
        }

    }
}
