package com.revature.revbooks.db;

import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.models.Role;

import java.util.HashMap;

public class UserDB extends HashMap<Integer, AppUser> {

    public static UserDB userDataSet = new UserDB();

    public static int key = 1;

    static {

        userDataSet.addUser(new AppUser("Adam","Inn", "admin","password",Role.ADMIN));
        userDataSet.addUser(new AppUser("yuanfeng","Gu","guyuanfeng8","12345",Role.PREMIUM_MEMBER));
        userDataSet.addUser(new AppUser("Eden","Gu","melon","54321",Role.BASIC_MEMBER));
        userDataSet.addUser(new AppUser("effie","shen","yanfei","abcde",Role.MANAGER));
        userDataSet.addUser(new AppUser("yuqin","zhao","yuqin","abcde",Role.BASIC_MEMBER));


    }

    public AppUser addUser(AppUser newUser){
        //for none duplicate variable name
        AppUser nUser = new AppUser(newUser);
        // set ID first
        newUser.setId(key);
        // key will add one automatically ,self set
        userDataSet.put(key++,nUser);

        // return a AppUser , add new user in the userDataSet
        return nUser;
    }

    public  AppUser findUserByCredentials(String username,String password){
        // traverse all AppUser to check the username and password
        for(AppUser user:userDataSet.values()){

            //checker
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){

                // if qualified return the AppUser the one matched
                return  user;
            }
        }
        return  null;
    }
}
