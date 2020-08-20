package com.revature.revbooks.screens;


import com.revature.revbooks.models.AppUser;

import static com.revature.revbooks.AppDriver.app;

public class UserProfileScreen extends Screen{



    public UserProfileScreen() {
        super("UserProfileScreen", "/userProfile");
        System.out.println("[LOG] = Instantiating " + super.getName());

    }



    @Override
    public void render() {



        System.out.println("UserProfile Screen Works");

        System.out.println(app.getCurrentUser().toString());


    }
}
