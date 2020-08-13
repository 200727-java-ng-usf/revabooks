package com.revature.revbooks.services;

import com.revature.revbooks.exceptions.AuthenticationException;
import com.revature.revbooks.exceptions.InvalidRequestException;
import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.models.Role;
import com.revature.revbooks.repos.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
        this.userRepo = userRepo;
    }


    public AppUser authenticate(String username, String password) throws AuthenticationException, InvalidRequestException {

        // username.trim().equals("") make sure not empty string
        // validate the user input are not null also
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid credential values provide!");
        }

        AppUser authenticatedUser = userRepo.findUserCredentials(username, password);


            if (authenticatedUser == null) {
                // TODO implement a custom AuthenticationException
                throw new AuthenticationException("No user found with the provided credentials");
            }
            return authenticatedUser;
        }

        public AppUser register(AppUser newUser){
        if (!isUserValid(newUser)){
            //TODO implememnt a custom InvalidRequest Exception
            throw new RuntimeException("Invalid user field values provided during registration");
        }

        if(userRepo.findUserByUsername(newUser.getUsername())!=null){
            // TODO implement a custom Exception
            throw new RuntimeException("Provide username is already in use!")
;        }

        newUser.setRole(Role.BASIC_MEMBER);

        return userRepo.save(newUser);

        }
        //TODO getAllUsers
        public Set<AppUser> getAllUsers(){
        return  new HashSet<>();
        }
        //TODO boolean deleteUserById
        public boolean deleteUserById(int id){

        return false;
        }

        public boolean update(AppUser updatedUser){
        return  false;
        }

        public boolean isUserValid(AppUser user){
        if(user == null)return  false;
        if(user.getFirstname() == null || user.getFirstname().trim().equals("")) return false;
        if(user.getLastname() == null || user.getLastname().trim().equals("")) return false;
        if(user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if(user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;

        }

}