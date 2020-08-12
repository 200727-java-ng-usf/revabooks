package com.revature.revabooks.db;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import java.util.HashMap;

public class UserDB extends HashMap<Integer, AppUser> {

    public static UserDB userDataset = new UserDB();
    public static int key = 1;

    static {
        userDataset.addUser(new AppUser("Adam", "Inn", "admin", "password", Role.ADMIN));
        userDataset.addUser(new AppUser("Wezley", "Singleton", "wsingleton", "java", Role.MANAGER));
        userDataset.addUser(new AppUser("Mia", "Capoli", "mcapoli", "what", Role.BASIC_MEMBER));
        userDataset.addUser(new AppUser("Liv", "Shoup", "ors123", "Olivia3512", Role.BASIC_MEMBER));
        userDataset.addUser(new AppUser("Shawn", "Reasin", "39nwahs", "cutie", Role.BASIC_MEMBER));

    }

    public AppUser addUser(AppUser newUser) {
        AppUser nUser = new AppUser(newUser);
        nUser.setId(key);
        userDataset.put(key++, nUser);
        return nUser;
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

//        return userDataset.values().stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);

        for (AppUser user : userDataset.values()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

}
