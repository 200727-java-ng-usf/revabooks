package com.revature.revabooks.db;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import java.util.HashMap;

public class UserDB extends HashMap<Integer, AppUser> {
    //extending hashmap to get them juicy methods. yum.

    public static UserDB userDataset = new UserDB();
    public static int key = 1;

    static{
        userDataset.addUser(new AppUser("stef","anderson","stef1", "Tacossa", Role.ADMIN));
        userDataset.addUser(new AppUser("john","ivan","john1", "Tacossa", Role.ADMIN));
        userDataset.addUser(new AppUser("ediha","ztec","eddy1", "Tacossa", Role.ADMIN));

    }

    public AppUser addUser(AppUser newUser){
        newUser.setId(key);
        userDataset.put(key++, newUser); //post-iteration
        return newUser;

    }

    public AppUser findUserByCredentials(String username, String password){
        for(AppUser user : userDataset.values()){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
//                userDataset.values().stream().filter(user ->{
//            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
//                return user;
//            }
//            return null;
//        });
    }

    public AppUser findUserByUsername(String username){
        for(AppUser user : userDataset.values()){
            if(user.getUsername().equals(username)){
                return user;
            }
        }

        return null;
    }

}
