package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;

import java.util.DoubleSummaryStatistics;

public class UserService {

    private UserRepository userRepo;

    public UserService() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
        userRepo = new UserRepository();
    }

    public AppUser authenticate(String username, String password) {

        // validate that the provided username and password are not non-values
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            // TODO implement a custom InvalidRequestException
            throw new RuntimeException("Invalid credential values provided!");
        }

        AppUser authenticatedUser = userRepo.findUserByCredentials(username, password);

        if (authenticatedUser == null) {
            // TODO implement a custom AuthenticationException
            throw new RuntimeException("No user found with the provided credentials");
        }

        return authenticatedUser;

    }

    public  AppUser register(AppUser newUser) {

        if(!isUserFields(newUser)){
            // TODO implement a custome InvalidRequestException
            throw new RuntimeException("Invalid user field values provided during registration!");
        }

        return null;
    }

    public AppUser update(AppUser updatedUser) {
        return null;
    }

    /**
     * Validates that the given user and its fields are valid (not null or empty strings).
     * Does not perform validation on id or role fields
     *
     * @param user
     * @return true or false depending on if the user was valid or not
     */

    public boolean isUserFields(AppUser user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
    }


}