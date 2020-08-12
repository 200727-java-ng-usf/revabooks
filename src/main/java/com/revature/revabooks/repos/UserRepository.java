package com.revature.revabooks.repos;

import com.revature.revabooks.db.UserDB;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

public class UserRepository {
    private UserDB userDataset = UserDB.userDataset;
    //TODO replace mock implementation with in-memory persistence
    public AppUser findUserByCredentials(String username, String password){
        return userDataset.findUserByCredential(username,password);
        
//on top replaced what we had wrote on top
//        if(!username.equals("admin") && !password.equals("p4ssw0rd") ){
//         //   throw new RuntimeException("No user found with the given credentials")
//            return null;
//        }
//        return new AppUser(1,"Adam","Inn","admin","p4ssw0rd", Role.ADMIN);

    }

}
