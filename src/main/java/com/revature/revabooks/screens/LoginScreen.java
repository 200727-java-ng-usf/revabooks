package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginScreen extends Screen{
// UserService is a dependency to the LoginScreen
    private UserService userService;
//  Inject the dependency through the constructor (constructor injection)
    public LoginScreen(UserService userService){
        System.out.println("[LOG] - Instantiating"+ this.getClass().getName());

        this.userService = userService; // this is loosely coupled , becasue this class is not responsible for instantiation of a userService
//        userService = new UserService();

    }

    @Override
    public void render(){
        /**
         Renders the login screen meny to the console.
         */
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String username, password;
        try {
            System.out.println("Please provide your login credentials");
            System.out.println("Username: ");
            username = console.readLine();
            System.out.println("Password: ");
            password = console.readLine();

            AppUser authUser = userService.authenticate(username,password);
            System.out.println(authUser);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
