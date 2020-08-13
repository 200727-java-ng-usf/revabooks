package com.revature.revbooks;

import com.revature.revbooks.db.UserDB;
import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.models.Role;
import com.revature.revbooks.repos.UserRepository;
import com.revature.revbooks.screens.LoginScreen;
import com.revature.revbooks.screens.RegisterScreen;
import com.revature.revbooks.services.UserService;

public class AppDriver {
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

        UserDB userDB = new UserDB();
        AppUser appUser = new AppUser("eee","fff","ggg","1234", Role.BASIC_MEMBER);

        System.out.println(userDB.addUser(appUser).toString());


    }
}
