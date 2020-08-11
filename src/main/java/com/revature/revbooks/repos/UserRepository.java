package com.revature.revbooks.repos;

import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.models.Role;

public class UserRepository {

    // TODO replace mock implementation with in - memory

    public AppUser findUserCredentials( String username, String password){
        if (username.equals("admin")&& !password.equals("p4ssw@rd")){
            throw  new RuntimeException("No user found with the given credentials!");
        }

        return new AppUser(1,"yuan","Gu","admin","p4ssw@rd",Role.ADMIN);
    }
}
