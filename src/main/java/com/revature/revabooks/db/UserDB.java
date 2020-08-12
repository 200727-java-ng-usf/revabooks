package com.revature.revabooks.db;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import java.util.HashMap;

public class UserDB extends HashMap<Integer, AppUser> {

    public static UserDB userDataset = new UserDB();
    public static int key = 1;
    //this is a static block
    static {
        userDataset.addUser(new AppUser("Adam","Inn","admin","p4ssw0rd", Role.ADMIN));
        userDataset.addUser(new AppUser("miguel","partida","m1gu3l","p4ssw0rd", Role.MANAGER));
        userDataset.addUser(new AppUser("Blake","knighten","knights","p4ssw0rd", Role.PREMIUM_MEMBER));
        userDataset.addUser(new AppUser("Dylan","Mcbee","Bees","p4ssw0rd", Role.BASIC_MEMBER));
        userDataset.addUser(new AppUser("Wezely","Singelton","wSingelton","p4ssw0rd", Role.BASIC_MEMBER));



    }

    public AppUser addUser(AppUser newUser ){
        AppUser nUser = new AppUser((newUser));
        newUser.setId(key);
        userDataset.put(key++, newUser);
        return newUser;
    }
    public AppUser findUserByCredential(String username,String password){
        for(AppUser user: userDataset.values() ) {
            if (user.getUserName().equals(username) && user.getPassWord().equals(password)) {
                return user;
            }
        }
        return null;
    }

}
