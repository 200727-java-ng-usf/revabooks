package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;

public class UserService {

    private UserRepository userRepo;

    public UserService() {
        System.out.println("[LOG] - Instantiating" + this.getClass().getName());
        userRepo = new UserRepository();
    }
    public AppUser authenticate(String username, String password) {
        if(username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new RuntimeException("Invalid credentials provided!");
        }
        AppUser authenticatedUser = userRepo.findUserByCredentials(username, password);
    }
}
