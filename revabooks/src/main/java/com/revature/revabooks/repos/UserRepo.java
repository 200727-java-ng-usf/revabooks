package com.revature.revabooks.repos;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

public class UserRepo {

    //TODO replace mock implementation with in-memory persistence

    public AppUser findUserCredentials(String username, String password){
        if (!username.equals("admin") && !password.equals("p4ssw0rd")){
            throw new RuntimeException("No user found with the given credentials");
        }

        return new AppUser(1,"Adam","Inn","admin","p4ssw0rd", Role.ADMIN);
    }

}
