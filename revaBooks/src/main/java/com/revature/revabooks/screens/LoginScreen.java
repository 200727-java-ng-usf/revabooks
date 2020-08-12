package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginScreen extends Screen {

    // UserService is a dependency to the Login Screen
    private UserService userService;


    //Ingect the dependency through the constructor (constructor injection)
    public LoginScreen(UserService userService) {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
//        userService = new UserService(); //tight coupling! we want loose coupling

        //loosely coupled, bc this class is not responsible for the instantiation of a Userservice
        this.userService = userService;
    }

    /**
     *  Renders the login screen menu to the console
     */
    @Override
    public void render() {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String username, password;

        try {
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = console.readLine();
            System.out.println("Password: ");
            password = console.readLine();

            AppUser authUser = userService.authenticate(username, password);
            System.out.println(authUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
