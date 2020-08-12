package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegisterScreen extends Screen {

    private UserService userService;

    public RegisterScreen(UserService userService) {
        System.out.println("[LOG] - instanciating " + this.getClass().getName());
//        userService = new UserService();
        this.userService = userService;


    }

    @Override
    public void render() {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String firstName, LastName, username, password;

        try {

            System.out.println("Sign up for a new account");
            System.out.print("First Name: ");
            firstName = console.readLine();
            System.out.print("Last Name: ");
            LastName = console.readLine();
            System.out.print("Username: ");
            username = console.readLine();
            System.out.print("Password: ");
            password = console.readLine();



            AppUser newUser = new AppUser(firstName, LastName,username, password);
            AppUser registeredUser = userService.register(newUser);
            System.out.println(registeredUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
