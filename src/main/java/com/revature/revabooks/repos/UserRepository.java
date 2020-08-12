package com.revature.revabooks.repos;

import com.revature.revabooks.db.UserDB;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

public class UserRepository {

    private UserDB userDataset = UserDB.userDataset;


    public AppUser findUserByCredentials(String username, String password){

        return userDataset.findUserByCredentials(username, password);

//
//        if(username.equals("admin")&&password.equals("password")){
//            //throw new RuntimeException("No user found with given credentials.");
//            return null;
//        }
//        //temp
//        return new AppUser(1, "Adam", "John", "AJOHN", "password", Role.ADMIN);
    }

    public AppUser findUserByUsername(String username){
        return userDataset.findUserByUsername(username);
    }

    public AppUser save(AppUser newUser){
        return userDataset.addUser(newUser);
    }

}
