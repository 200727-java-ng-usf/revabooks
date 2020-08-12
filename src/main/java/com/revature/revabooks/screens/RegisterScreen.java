package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

public class RegisterScreen {

    private UserService userService;

    public RegisterScreen(){
        System.out.println("[LOG] - Instantiating "+this.getClass().getName());
        userService = new UserService();
    }



}
