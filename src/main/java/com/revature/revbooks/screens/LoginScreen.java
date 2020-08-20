package com.revature.revbooks.screens;

import com.revature.revbooks.exceptions.AuthenticationException;
import com.revature.revbooks.exceptions.InvalidRequestException;
import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.revature.revbooks.AppDriver.app;

public class LoginScreen extends Screen {

    private UserService userService;

    public LoginScreen(UserService userService){

        super("loginScreen","/login");
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());

        // make a link to the UserService
        this.userService = userService;
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

            // pass the userInput to check for authentication
            AppUser authUser = userService.authenticate(username,password);
            System.out.println(authUser);

            app.setCurrentUser(authUser);

            System.out.println("You entered Username: " + username + "  Password: " + password);


            app.getRouter().navigate("/dashboard");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

    }

}
