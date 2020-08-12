package com.revature.revabooks.db;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import java.util.HashMap;

public class UserDB extends HashMap<Integer, AppUser> {

    public static UserDB userDataset = new UserDB();
    public static int key =1;

    static {
        userDataset.addUser(new AppUser("adam", "Inn", "admin" ,"p4ssw0rd", Role.ADMIN));
        userDataset.addUser(new AppUser("eli", "p", "ep" ,"123", Role.MANAGER));
        userDataset.addUser(new AppUser("cpt", "falcon", "punch" ,"blueFalcon", Role.BASIC_MEMBER));
        userDataset.addUser(new AppUser("luigi", "mario", "bros" ,"fireball", Role.PREMIUM_MEMBER));
        userDataset.addUser(new AppUser("darth", "vader", "father" ,"darkside", Role.BASIC_MEMBER));




    }
    public AppUser addUser(AppUser newUser){
        AppUser nUser = new AppUser(newUser);
        nUser.setId(key);
        userDataset.put(key++, nUser);
        return nUser;
    }

    public AppUser findUserByCredential(String username, String password){

        for (AppUser user: userDataset.values()){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    public AppUser findByUserName(String username){
        for (AppUser user: userDataset.values()){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
}






