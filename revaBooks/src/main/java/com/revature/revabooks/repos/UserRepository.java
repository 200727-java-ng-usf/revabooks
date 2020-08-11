package com.revature.revabooks.repos;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

public class UserRepository {

    //TODO replace mock implementation with in-memory persistence
    public AppUser findUserByCredentials(String username, String password) {
        if (!username.equals("admin") && !password.equals("p4ssword")) {

            return null;
        }
        return new AppUser(1, "Adam", "Inn", "admin", "p4ssword", Role.ADMIN);

    }
}
