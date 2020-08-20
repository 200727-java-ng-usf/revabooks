package com.revature.revabooks.screens;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.revature.revabooks.AppDriver.app;

public class LoginScreen extends Screen{

    private UserService userService;

    public LoginScreen(UserService userService){
        super("LoginScreen","/login");
        System.out.println("[LOG] - Instantiating "+this.getClass().getName());
       this.userService = userService;
    }

    /**
     * Renders the login screen menu to the console.
     */
    @Override
    public void render(){
        String username, password;


        try {
            System.out.println("Please provide your login credentials");
            System.out.println("Username: ");
            username = app.getConsole().readLine();
            System.out.println("Please provide password: ");
            password = app.getConsole().readLine();

            userService.authentic(username,password);

            if (app.isSessionValid()) {
                app.getRouter().navigate("/dashboard");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    @Override
    public void add(Screen screen) {

    }
}
