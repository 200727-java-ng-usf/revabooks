package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegisterScreen extends Screen{
    private UserService userService;

    public RegisterScreen(UserService userService){
        //take out this before I present
        System.out.println("[LOG] - Instantiating"+ this.getClass().getName());
        this.userService = userService; // this is loosely coupled , becasue this class is not responsible for instantiation of a userService
//        userService = new UserService(); - this is tight coupling - thats bad we aim for looseness

    }
    @Override
    public void render(){

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String firstname, lastname, username, password;

        try{
            System.out.println("Sign up for a new account!" );

            System.out.println("First Name: ");
            firstname = console.readLine();

            System.out.println("Last Name: ");
            lastname = console.readLine();

            System.out.println("Username: ");
            username = console.readLine();

            System.out.println("Password: ");
            password = console.readLine();

            AppUser newUser = new AppUser(firstname,lastname,username,password);
            AppUser registeredUser = userService.register(newUser);
            System.out.println(registeredUser);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
