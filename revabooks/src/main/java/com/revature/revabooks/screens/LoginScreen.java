package com.revature.revabooks.screens;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginScreen extends Screen{

    private UserService userService;

    public LoginScreen(UserService userService){
        System.out.println("[LOG] - Instantiating "+this.getClass().getName());
       this.userService = userService;
    }

    /**
     * Renders the login screen menu to the console.
     */
    @Override
    public void render(){
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String username, password;


        try {
            System.out.println("Please provide your login credentials");
            System.out.println("Username: ");
            username = console.readLine();
            System.out.println("Please provide password: ");
            password = console.readLine();

            AppUser authUser = userService.authentic(username,password);
            System.out.println(authUser);
        }catch(Exception e){
            e.printStackTrace();
        }




    }
}
