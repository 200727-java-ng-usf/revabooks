package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginScreen {
    private UserService userService;

    public LoginScreen() {
        System.out.println("[LOG] - instanciating " + this.getClass().getName());
        userService = new UserService();
    }

    /**
     * render the login screen menu to compile
     */
    public void render() {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String username, password;

        try {
            System.out.println("please provide your credentials");
            System.out.print("Username: ");
            username = console.readLine();
            System.out.print("Password: ");
            password = console.readLine();


            System.out.println("you entered: " + username + "/" + password);
            AppUser  authUser = userService.authentication(username,password);
            System.out.println(authUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
