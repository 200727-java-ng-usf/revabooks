package com.revature.revabooks.repos;

import com.revature.revabooks.db.UserDB;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

public class UserRepository {
    private UserDB userDataset = UserDB.userDataset;

    public AppUser findUserByCredentials(String username, String password){
        return userDataset.findUserByCredential(username, password);
    }
}
