package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepo;

public class UserService {

    private UserRepo userRepo;

    public UserService(){
        System.out.println("[LOG] - Instaniatting " + this.getClass().getName());
        userRepo = new UserRepo();
    }

    public AppUser authentic(String username, String password){

        if(username==null || username.trim().equals("")||password==null||password.trim().equals("")){

            //TODO implement a custom InvalidRequestException
            throw new RuntimeException("Invalid credential values provided!");
        }

        AppUser authenticatedUser = userRepo.findUserCredentials(username,password);

        if (authenticatedUser == null) {
            // TODO implement a custom AuthenticationException
            throw new RuntimeException("No user found with the provided credentials");
        }

        return authenticatedUser;

    }
}
