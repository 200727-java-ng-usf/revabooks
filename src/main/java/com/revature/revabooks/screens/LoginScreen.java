package com.revature.revabooks.screens;

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
     * Renders the logins screen menu to the console
     * */
    public void render(){

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String username, password;

        try {
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = console.readLine();
            //read from the console: BufferReader

            //prompt psw
            System.out.print("Password: ");
            password = console.readLine();

            System.out.println("You entered: " + username + "/" + password);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }


    }
}
