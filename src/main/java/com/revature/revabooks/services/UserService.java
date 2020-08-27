package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;

import java.util.*;

import static com.revature.revabooks.AppDriver.app;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
        userRepo = repo;
//        userRepo = new UserRepository(); // tight coupling! ~hard~ impossible to unit test
    }

    public Set<AppUser> getAllUsers() {

        Set<AppUser> users = userRepo.findAllUsers();

        if (users.isEmpty()) {
            throw new RuntimeException("No users found...");
        }

        return users;
    }


    public void authenticate(String username, String password) {

        // validate that the provided username and password are not non-values
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid credential values provided!");
        }

        AppUser authUser = userRepo.findUserByCredentials(username, password)
                                    .orElseThrow(AuthenticationException::new);

        app.setCurrentUser(authUser);

    }

    public void register(AppUser newUser) {

        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Invalid user field values provided during registration!");
        }

        Optional<AppUser> existingUser = userRepo.findUserByUsername(newUser.getUsername());
        if (existingUser.isPresent()) {
            // TODO implement a custom ResourcePersistenceException
            throw new RuntimeException("Provided username is already in use!");
        }

        newUser.setRole(Role.BASIC_MEMBER);
        userRepo.save(newUser);
        System.out.println(newUser);
        app.setCurrentUser(newUser);

    }

    public Set<AppUser> getUsersByRole() {
        return new HashSet<>();
    }

    public AppUser getUserById(int id) {
        return null;
    }

    public AppUser getUserByUsername(String username) {
        return null;
    }

    public boolean deleteUserById(int id) {
        return false;
    }

    public boolean update(AppUser updatedUser) {
        return false;
    }

    /**
     * Validates that the given user and its fields are valid (not null or empty strings). Does
     * not perform validation on id or role fields.
     *
     * @param user
     * @return true or false depending on if the user was valid or not
     */
    public boolean isUserValid(AppUser user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;

        return true;
    }


}
