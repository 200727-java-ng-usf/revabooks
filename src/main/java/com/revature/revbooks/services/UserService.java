package com.revature.revbooks.services;

import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.repos.UserRepository;

public class UserService {

    private UserRepository userRepo;

    public UserService() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
        userRepo = new UserRepository();
    }


    public AppUser authenticate(String username, String password) {

        // username.trim().equals("") make sure not empty string
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new RuntimeException("Invalid credential values provide!");
        }

        AppUser authenticatedUser = userRepo.findUserCredentials(username, password);


            if (authenticatedUser == null) {
                // TODO implement a custom AuthenticationException
                throw new RuntimeException("No user found with the provided credentials");
            }
            return authenticatedUser;
        }

}