package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;

import java.util.*;
import static com.revature.revabooks.AppDriver.app;

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
        AppUser authUser = userRepo.findUserByCredentials(username, password)
                .orElseThrow(AuthenticationException::new);

        app.setCurrentUser(authUser);
        return authUser;
    }

    public void register(AppUser newUser) {
        if (!validateUserFields(newUser)) {
            throw new RuntimeException("Invalid user fields provided during registration.");
        }
        Optional<AppUser> existingUser = userRepo.findUserByUsername(newUser.getUserName());
        if(userRepo.findUserByUsername(newUser.getUserName()) != null) {
            throw new RuntimeException("That username is already in use.");
        }

        newUser.setRole(Role.BASIC_MEMBER);
        AppUser registeredUser = userRepo.save(newUser);

        app.setCurrentUser(registeredUser);
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
