package com.revature.revabooks.repos;

import com.revature.revabooks.db.UserDb;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

public class UserRepo {
    private UserDb userDataset = UserDb.userDataset;
    //TODO replace mock implementation with in-memory persistence

    public AppUser findUserCredentials(String username, String password){

    return userDataset.findUserByCredentials(username,password);

    }

}
