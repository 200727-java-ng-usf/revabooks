package com.revature.revabooks.repos;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

public class UserRepository {

    //TODO replace mock implementation with in memory persistence
    public AppUser findUsersByCredentials(String userName, String Password){
        if(!userName.equals("admin") && !Password.equals("password")){
            return null;
        }
        return new AppUser(1,"Adam","Inn","admin","password", Role.ADMIN);
    }
}
