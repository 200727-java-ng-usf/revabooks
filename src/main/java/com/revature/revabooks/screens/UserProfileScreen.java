package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

import static com.revature.revabooks.AppDriver.app;

public class UserProfileScreen extends Screen{

    public UserProfileScreen() {
        super("User Profile", "/profile");
    }

    @Override
    public void render() {
        System.out.println("Current user: " + app.getCurrentUser());
    }

}
