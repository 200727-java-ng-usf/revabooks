package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegisterScreen extends Screen{

    private UserService userService;

    public RegisterScreen(UserService userService) {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
        // userService = new UserService(); //tight coupling! we want loose coupling
        this.userService = userService;
    }

    @Override
    public void render() {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String firstName, lastName, username, password;

        try {

            System.out.println("Sign up for a new account!");
            System.out.println("First name: ");
            firstName = console.readLine();
            System.out.println("Last name: ");
            lastName = console.readLine();
            System.out.println("username: ");
            username = console.readLine();
            System.out.println("Password: ");
            password = console.readLine();

            AppUser newUser = new AppUser(firstName, lastName, username, password);
            AppUser registeredUser = userService.register(newUser);
            System.out.println(registeredUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
