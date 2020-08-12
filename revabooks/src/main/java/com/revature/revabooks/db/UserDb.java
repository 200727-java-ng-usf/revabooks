package com.revature.revabooks.db;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import java.util.HashMap;

public class UserDb extends HashMap<Integer, AppUser> {

    public static UserDb userDataset = new UserDb();
    public static int key = 1;

    static {

        userDataset.addUser(new AppUser("Adam", "Inn", "admin", "p4ssw0rd", Role.ADMIN));
        userDataset.addUser(new AppUser("Shea", "Wilson", "swilson", "sosaid", Role.MANAGER));
        userDataset.addUser(new AppUser("Blake", "Kruppa", "bkruppa", "javascript", Role.PREMIUM_MEMBER));
        userDataset.addUser(new AppUser("Dylan", "McBee", "dmcbee", "password", Role.BASIC_MEMBER));
        userDataset.addUser(new AppUser("Nickolas", "Jurczak", "njurczak", "drowssap", Role.BASIC_MEMBER));
    }

    // custom method to populate the HashMap
    public AppUser addUser(AppUser newUser) {
        newUser.setId(key);
        userDataset.put(key++, newUser);
        return newUser;
    }

    public AppUser findUserByCredentials(String username, String password) {

        for (AppUser user : userDataset.values()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public AppUser findUserByUsername(String username) {
        for (AppUser user : userDataset.values()) {
            if (user.getUsername().equals(username)) {
                return user;

            }

        }
        return null;
    }
}
