package com.revature.revabooks.repos;

import com.revature.revabooks.models.AppUser;

public class UserRepository {

    public AppUser findUserByCredentials(String username, String password) {
        if (!username.equals("admin") && !password.equals("P4ssw0rd")) {
            throw new RuntimeException()
        }
        return username;
    }
}
