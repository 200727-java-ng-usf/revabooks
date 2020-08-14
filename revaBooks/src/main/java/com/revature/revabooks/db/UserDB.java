package com.revature.revabooks.db;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import java.util.HashMap;
import java.util.Optional;

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

    public Optional<AppUser> findUserByCredentials(String username, String password) {

        return userDataset.values()
                .stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();

//        for (AppUser user : userDataset.values()) {
//            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
//                return user;
//            }
//        }
//        return null;
    }

    public Optional<AppUser> findUserByUsername(String username) {

//        Optional<AppUser> _user = Optional.of(new AppUser());
//        _user.isPresent();

        return userDataset.values().
                stream().
                filter(user -> user.getUsername().equals(username)).
                findFirst();

//        for (AppUser user : userDataset.values()) {
//            if (user.getUsername().equals(username)) {
//                return user;
//            }
//        }
//
//        return null;
    }

}
