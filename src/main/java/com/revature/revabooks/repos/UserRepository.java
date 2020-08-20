package com.revature.revabooks.repos;

import com.revature.revabooks.db.UserDB;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import java.util.Optional;

public class UserRepository {

    private UserDB userDataset = UserDB.userDataset;

    public UserRepository() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
    }

    public Optional<AppUser> findUserByCredentials(String username, String password) {
        return userDataset.findUserByCredentials(username, password);
    }

    public Optional<AppUser> findUserByUsername(String username) {
        return userDataset.findUserByUsername(username);
    }

    public AppUser save(AppUser newUser) {
        return userDataset.addUser(newUser);
    }

}
