package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegisterScreen extends Screen{

    private UserService userService;

    public RegisterScreen(){
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
        userService = new UserService();
    }
    @Override
    public void render(){

        String firstName, lastName, userName, password;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("Sign up for a new account");
            System.out.print("First name: ");
            firstName = console.readLine();
            System.out.print("Last name");
            lastName = console.readLine();
            System.out.println("username: ");
            userName = console.readLine();
            System.out.println("pasword");
            password = console.readLine();

            AppUser newUser = new AppUser(firstName,lastName,userName,password);
            AppUser registeredUser = userService.register(newUser);
            System.out.println(registeredUser);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
