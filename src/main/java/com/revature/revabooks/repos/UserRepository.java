package com.revature.revabooks.repos;


import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import java.util.Optional;

public class UserRepository {

    public UserRepository() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
    }

    public Optional<AppUser> findUserByCredentials(String username, String password) {
        return Optional.of(null);
    }

    public Optional<AppUser> findUserByUsername(String username) {
        return Optional.of(null);
    }

    public Optional<AppUser> save(AppUser newUser) {
        return Optional.of(null);
    }

}