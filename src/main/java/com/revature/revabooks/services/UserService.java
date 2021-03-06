package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourceNotFoundException;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;

import java.util.*;


public class UserService {

    private UserRepository userRepo = new UserRepository();

    public Set<AppUser> getAllUsers() {

        Set<AppUser> users = userRepo.findAllUsers();

        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return users;

    }

    public AppUser authenticate(String username, String password) {

        // validate that the provided username and password are not non-values
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid credential values provided!");
        }

        return userRepo.findUserByCredentials(username, password)
                        .orElseThrow(AuthenticationException::new);

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

    }

    public Set<AppUser> getUsersByRole() {
        return new HashSet<>();
    }

    public AppUser getUserById(int id) {

        if (id <= 0) {
            throw new InvalidRequestException("The provided id cannot be less than or equal to zero.");
        }

        return userRepo.findUserById(id)
                        .orElseThrow(ResourceNotFoundException::new);
    }

    public boolean isUsernameAvailable(String username) {
        AppUser user = userRepo.findUserByUsername(username).orElse(null);
        return user == null;
    }

    public boolean isEmailAvailable(String email) {
        AppUser user = userRepo.findUserByEmail(email).orElse(null);
        return user == null;
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
        return true;
    }


}
