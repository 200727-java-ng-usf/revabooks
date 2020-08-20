package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

import static com.revature.revabooks.AppDriver.app;

public class UserProfileScreen extends Screen{

    private UserService userService;

    protected UserProfileScreen(UserService userService) {
        super("UserProfile", "/userProfile");
    }

    @Override
    public void render() {
        System.out.println(app.getCurrentUser());
    }
}
