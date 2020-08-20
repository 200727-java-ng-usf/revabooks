package com.revature.revbooks;

import com.revature.revbooks.db.UserDB;
import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.models.Role;
import com.revature.revbooks.repos.UserRepository;
import com.revature.revbooks.screens.LoginScreen;
import com.revature.revbooks.screens.RegisterScreen;
import com.revature.revbooks.services.UserService;


import com.revature.revbooks.util.AppState;

public class AppDriver {

    public static AppState app = new AppState();

    public static void main(String[] args) {


//        UserRepository userRepository = new UserRepository();
//        UserService userService = new UserService(userRepository);
//
//
//        RegisterScreen registerScreen = new RegisterScreen(userService);
//       registerScreen.render();
//
//        LoginScreen loginScreen = new LoginScreen(userService);
//        loginScreen.render();

        while(app.isAppRunning()) {
            app.getRouter().navigate("/home");
        }



    }
}
