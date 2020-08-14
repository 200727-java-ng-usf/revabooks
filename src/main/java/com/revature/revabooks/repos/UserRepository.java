package com.revature.revabooks.repos;

import com.revature.revabooks.db.UserDb;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import java.util.Optional;

public class UserRepository {

    public UserRepository() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
    }

    private UserDb userDataset = UserDb.userDataset;

    public AppUser findUserByCredentials(String username, String password) {
        if (!username.equals("admin") && !password.equals("P4ssw0rd")) {
            throw new RuntimeException();
        }
        return new AppUser(1, "Adam", "Inn", "admin", "p4ssw0rd", Role.ADMIN);
    }

    public Optional<AppUser> findUserByUsername(String username) {
        return userDataset.findUserByUsername(username);
    }

    public AppUser save(AppUser newUser) {
        return userDataset.addUser(newUser);
    }
}
