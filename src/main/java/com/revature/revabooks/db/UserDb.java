package com.revature.revabooks.db;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import java.util.HashMap;
import java.util.Optional;

public class UserDb extends HashMap<Integer, AppUser> {

    public static UserDb userDataset = new UserDb();
    public static int key = 1;

    static {
        userDataset.addUser(new AppUser("Adam", "Inn", "admin", "p4ssw0rd", Role.ADMIN));
        userDataset.addUser(new AppUser("Wezley", "Singleton", "wsingleton", "j4v4", Role.MANAGER));
        userDataset.addUser(new AppUser("Jason", "Hernandez", "jHernan", "nunya", Role.BASIC_MEMBER));
        userDataset.addUser(new AppUser("Dylan", "McBee", "dmcbee", "password", Role.BASIC_MEMBER));
        userDataset.addUser(new AppUser("Blake", "Kruppa", "bkruppa", "javascript", Role.PREMIUM_MEMBER));
    }

    public AppUser addUser(AppUser newUser) {
        AppUser nUser = new AppUser(newUser);
        newUser.setId(key);
        userDataset.put(key++, newUser);
        return newUser;
    }

//    public AppUser findUserByCredentials(String username, String password) {
//
//        for(AppUser user : userDataset.values()) {
//            if(user.getUserName().equals(username) && user.getPassword().equals(password)) {
//                return user;
//            }
//        }
//        return null;
//    }

    public Optional<AppUser> findUserByUsername(String username) {
        return userDataset.values()
                            .stream()
                            .filter(user -> user.getUserName().equals(username))
                            .findFirst();


//    public AppUser findUserByUsername(String username) {
//        for(AppUser user : userDataset.values()) {
//            if(user.getUserName().equals(username)) {
//                return user;
//            }
    }

        public Optional<AppUser> findUserByCredentials(String username, String password) {
            return userDataset.values()
                    .stream()
                    .filter(user -> user.getUserName().equals(username) && user.getPassword().equals(password))
                    .findFirst();
    }

}
