package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        System.out.println("[LOG] - Instantiating" + this.getClass().getName());
        userRepo = repo;
    }
    public AppUser authenticate(String username, String password) {
        if(username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new RuntimeException("Invalid credentials provided!");
        }
        AppUser authenticatedUser = userRepo.findUserByCredentials(username, password);

        if (authenticatedUser == null) {
            // TODO implement a custom AuthenticationException
            throw new RuntimeException("No user found with the provided credentials");
        }

        return authenticatedUser;
    }
    public AppUser register(AppUser newUser) {
        if (!validateUserFields(newUser)) {
            throw new RuntimeException("Invalid user fields provided during registration.");
        }
        Optional<AppUser> existingUser = userRepo.findUserByUsername(newUser.getUserName());
        if(userRepo.findUserByUsername(newUser.getUserName()) != null) {
            throw new RuntimeException("That username is already in use.");
        }

        newUser.setRole(Role.BASIC_MEMBER);
        return userRepo.save(newUser);
    }

    public Set<AppUser> getAllUsers() {
        return new HashSet<>();
    }
    public Set<AppUser> getUsersByRole() {
        return new HashSet<>();
    }
    public Set<AppUser> getUserById() {
        return new HashSet<>();
    }
    public Set<AppUser> getUserByName() {
        return new HashSet<>();
    }

    public boolean deleteUserById() {
        return false;
    }

    public boolean update(AppUser updatedUser) {
        return false;
    }
    public boolean validateUserFields(AppUser user) {
        if(user == null) return false;
        if(user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if(user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if(user.getUserName() == null || user.getUserName().trim().equals("")) return false;
        if(user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }

}
