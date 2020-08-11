package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;

public class UserService {

    private UserRepository userRepo;

    public UserService() {
        System.out.println("[LOG] instantiating " + this.getClass().getName());
        userRepo = new UserRepository();
    }

    public AppUser authentication(String username, String password) {
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new RuntimeException("invalid credentials provided");
        }
        AppUser authenticatedUser = userRepo.findUserByCredentials(username, password);

        if (authenticatedUser == null) {
            throw new RuntimeException("invalid credentials provided");
        }
        return authenticatedUser;
    }
}
