package com.revature.revabooks.repos;

import com.revature.revabooks.db.UserDB;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

public class UserRepository {
    private UserDB userDataset = UserDB.userDataset;

    public AppUser findUserByCredentials(String username, String password){
        return userDataset.findUserByCredential(username, password);
    }
    public AppUser findUserByUsername(String username){
        return userDataset.findByUserName(username);
    }
    public AppUser save(AppUser newUser){
        return userDataset.addUser(newUser);
    }
}
