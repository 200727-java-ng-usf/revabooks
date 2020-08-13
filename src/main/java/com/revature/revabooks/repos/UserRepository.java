package com.revature.revabooks.repos;

import com.revature.revabooks.db.UserDB;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

public class UserRepository {

    private UserDB userDataset = UserDB.userDataset;

    // TODO replace mock implementation with in-memory persistence
    public AppUser findUserByCredentials(String username, String password) {

        return  userDataset.findUserByCredentials(username, password);

//        if (!username.equals("admin") && !password.equals("p4ssw0rd")) {
//            return null;
//        }
//
//        return new AppUser(1, "Adam", "Inn", "admin", "p4ssw0rd", Role.ADMIN);

    }

    //TODO cww findUserByUsername, save
}
