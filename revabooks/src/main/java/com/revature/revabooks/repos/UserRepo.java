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

    public AppUser save(AppUser newUser){
        return userDataset.addUser(newUser);
    }

    public AppUser findUserByUsername(String username) {
        for (AppUser user : userDataset.values()) {
            if (user.getUsername().equals(username)) {
                return user;

            }

        }
        return null;
    }
    public UserRepo() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
    }

}
