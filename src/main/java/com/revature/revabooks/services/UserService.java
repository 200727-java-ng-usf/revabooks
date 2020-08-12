package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;

public class UserService {

    private UserRepository userRepo;

    public UserService(){
        System.out.println("[LOG] - Instantiating "+this.getClass().getName());
        userRepo=new UserRepository();
    }

    public AppUser authenticate(String username, String password){
        //returning AppUser
        //handling edge cases first (non-values)
        if(username==null || password==null || username.trim().equals("") || password.trim().equals("")){
            //todo implement a custom InvalidRequestException
            throw new RuntimeException("Invalid credential values provided!");

        }

        AppUser authenticatedUser = userRepo.findUserByCredentials(username, password);

        if (authenticatedUser == null) {
            //todo implement custom exception
            throw new RuntimeException();
        }
        return authenticatedUser;
    }

}
