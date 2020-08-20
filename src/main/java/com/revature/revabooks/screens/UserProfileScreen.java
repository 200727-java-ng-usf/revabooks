package com.revature.revabooks.screens;

import static com.revature.revabooks.AppDriver.app;

public class UserProfileScreen extends Screen {

    public UserProfileScreen() {
        super("UserProfileScreen", "/profile");
        System.out.println("[LOG] - Initializing " + getName().getClass());
    }


    @Override
    public void render() {
        System.out.println("Current User: " + app.getCurrentUser() + "\n");
    }
}
