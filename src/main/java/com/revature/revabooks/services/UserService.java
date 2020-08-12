package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;

public class UserService {

        private UserRepository userRepo;

        public UserService() {
            System.out.println("[LOG] - Instantiating " + this.getClass().getName());
            userRepo = new UserRepository();
        }

        public AppUser authenticate(String username, String password) {

            // validate the provided username and password are not non-values
            if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
                // TODO implement a custom InvalidRequestException
                throw new RuntimeException("Invalid credentials entered!");
            }

            AppUser authenticatedUser = userRepo.findUserByCredentials(username, password);

            if (authenticatedUser == null) {
                throw new RuntimeException("User not found.");
            }

            return authenticatedUser;

        }

}

