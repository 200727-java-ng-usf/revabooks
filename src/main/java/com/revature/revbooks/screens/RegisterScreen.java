package com.revature.revbooks.screens;

import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static com.revature.revbooks.AppDriver.*;

public class RegisterScreen extends Screen {

    private UserService userService;

    public RegisterScreen(UserService userService) {
        super("registerScreen","/register");
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
       // userService = new UserService();
        this.userService = userService;
    }

    @Override
    public void render(){

        String firstname,lastname,username,password;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Sign up for a new account");
            System.out.println("First name: ");
            firstname = reader.readLine();
            System.out.println("Last name: ");
            lastname = reader.readLine();
            System.out.println("User name: ");
            username = reader.readLine();
            System.out.println("Password: ");
            password = reader.readLine();

            AppUser newUser  = new AppUser(firstname,lastname,username,password);
            AppUser registeredUser = userService.register(newUser);

            System.out.println(registeredUser);

            app.setCurrentUser(registeredUser);


            app.getRouter().navigate("/dashboard");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
