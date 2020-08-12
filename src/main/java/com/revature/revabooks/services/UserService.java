package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;

public class UserService {
    private UserRepository userRepo;
    public UserService(){
        System.out.println("[LOG] - instantiating " + this.getClass().getName());
        userRepo = new UserRepository();
    }

    public AppUser authenticate(String userName, String passWord){
        if (userName == null || userName.trim().equals("") || passWord == null ||  passWord.trim().equals("")){
            //TODO implement a custom InvalidRequestException
            throw new RuntimeException("Invalid credential values provided");
        }

        AppUser authenticatedUser = userRepo.findUsersByCredentials(userName, passWord);
        if(authenticatedUser == null){
            throw new RuntimeException("No user found Dog");
        }
        return authenticatedUser;
    }
}
