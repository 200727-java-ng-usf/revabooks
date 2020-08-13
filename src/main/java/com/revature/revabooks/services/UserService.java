package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;

import javax.xml.bind.SchemaOutputResolver;

public class UserService {

    private UserRepository userRepo;

    public UserService() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
        userRepo = new UserRepository();
    }

    public AppUser authenticate(String username, String password) {

        if (username == null || username.trim().equals("")||password == null||password.trim().equals("")) {
            // TODO implement a custom InvalidRequestException
            throw new RuntimeException("Invalid credential values provided");
        }

        AppUser authenticatedUser = userRepo.findUserByCredentials(username,password);

        if (authenticatedUser == null) {
            // TODO implement a custom AuthonticationException
            throw new RuntimeException("No user found with provided credentials");
        }
        return authenticatedUser;

    }

    public AppUser register(AppUser newUser) {

        if (!isUserValid(newUser)) {
            // TODO implement a custom InvalidRequestException
            throw new RuntimeException("Invalid user field values provided during registration!");
        }

        // TODO implement a custom ResourcePersistenceException
        // TODO cww provided username is already in use

        // newUser.setRole();
        // TODO cww
        return null;
    }

    public AppUser update(AppUser updatedUser) {
        return null;
    }

    /**
     * Validates that the given user and its fields are valid (not null or empty strings). Does
     * not perform validation on id or role fields.
     *
     * @param user
     * @return true or false depending on if the user was valid or not
     */
    public boolean isUserValid(AppUser user) {
        if (user== null ||
            user.getFirstName() == null || user.getFirstName().trim().equals("") ||
            user.getLastName() == null  || user.getLastName().trim().equals("")  ||
            user.getUsername() == null  || user.getUsername().trim().equals("")  ||
            user.getPassword() == null  || user.getPassword().trim().equals(""))
            return false;

        return true;

    }
}
