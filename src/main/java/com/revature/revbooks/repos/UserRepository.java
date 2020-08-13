package com.revature.revbooks.repos;

import com.revature.revbooks.db.UserDB;
import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.models.Role;

public class UserRepository {

    private UserDB userDataSet = UserDB.userDataSet;

    // TODO replace mock implementation with in - memory

    public UserRepository() {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
    }

    public AppUser findUserCredentials( String username, String password){

        return userDataSet.findUserByCredentials(username,password);
    }

    public AppUser findUserByUsername(String username){
        return userDataSet.findUserByUsername(username);
    }

    public  AppUser save(AppUser newUser){
        return userDataSet.addUser(newUser);
    }

}
