package com.revature.revabooks.db;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import java.util.HashMap;

public class UserDB extends HashMap<Integer, AppUser> {

    public static UserDB userDataSet = new UserDB();
    public static int key = 1;

    static {
        userDataSet.addUser(new AppUser("Adam", "Inn", "admin", "p4ssw0rd", Role.ADMIN));
        userDataSet.addUser(new AppUser("Wezley", "Singleton", "wsingleton", "java", Role.MANAGER));
        userDataSet.addUser(new AppUser("farren", "Springer", "fjs507", "uhm", Role.ADMIN));
        userDataSet.addUser(new AppUser("Dylan", "McBree", "dmcbree", "password", Role.PREMIUM_MEMBER));
        userDataSet.addUser(new AppUser("Nickolas", "Jurczak", "njurczak", "drowssap", Role.BASIC_MEMBER));
    }

    public AppUser addUser(AppUser newUser) {
        AppUser nUser = new AppUser(newUser);
        newUser.setId(key);
        userDataSet.put(key++, nUser);
        return nUser;
    }

    public AppUser findUserByCredentials(String username, String password) {

        for(AppUser user : userDataSet.values()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

}
