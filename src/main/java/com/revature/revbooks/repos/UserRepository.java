package com.revature.revbooks.repos;

import com.revature.revbooks.db.UserDB;
import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.models.Role;

public class UserRepository {

    private UserDB userDataSet = UserDB.userDataSet;

    // TODO replace mock implementation with in - memory

    public AppUser findUserCredentials( String username, String password){

        return userDataSet.findUserByCredentials(username,password);


    }
}
