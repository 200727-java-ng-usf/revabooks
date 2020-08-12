package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
//        userRepo = new UserRepository(); //impossible to unit test
        userRepo = repo;
    }

    public AppUser authenticate(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {

            throw new InvalidRequestException("Invalid Credential Values Provided");
        }

        AppUser authenticatedUser = userRepo.findUserByCredentials(username, password);

        if (authenticatedUser == null) {
            throw new AuthenticationException("No user found with the provided credentials");
        }

        return authenticatedUser;
    }

    public AppUser register(AppUser newUser) {
        if (!isUserValid(newUser)) {
            //TODO implement a custom InvalidRequestException
            throw new RuntimeException("Invalid user field values provided during registration.");
        }

        if (userRepo.findUserByUsername(newUser.getUsername()) != null) {
            // TODO implement a custom ResourcePersistenceException
            throw new RuntimeException("Provided username is already in use!");
        }

        newUser.setRole(Role.BASIC_MEMBER);
        AppUser registeredUser = userRepo.save(newUser);


        return registeredUser;
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

    public boolean deleteUserById(int id){
        return false;
    }


    public Boolean update(AppUser updatedUser) {
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
