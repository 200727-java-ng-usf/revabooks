package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        System.out.println("[LOG] instantiating " + this.getClass().getName());
        userRepo =  repo;
//        userRepo = new UserRepository();
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

    public AppUser register(AppUser newUser) {
        if (!isUserValid(newUser)) {
            throw new RuntimeException("Invalid user fields provided during registration");
        }
        if (userRepo.findUserByUsername(newUser.getUsername()) != null) {
            throw new RuntimeException("Provided username is already in user");
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

        public boolean isUserValid(AppUser user) {
            if (user == null) return false;
            if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
            if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
            if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
            if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
            return true;
        }
}
