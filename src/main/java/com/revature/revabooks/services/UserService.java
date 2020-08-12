package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserService {
    private UserRepository userRepo;

    public UserService(UserRepository userRepo){
        System.out.println("[LOG] - Instantiating "+ this.getClass().getName());
        this.userRepo = userRepo;
//        userRepo = new UserRepository();//tight coupling! ~hard~ impossible to UNIT TEST

    }
    public AppUser authenticate(String username, String password){

        if(username==null|| username.trim().equals("")||password == null||password.trim().equals("")){
            throw new InvalidRequestException("Invalid credential values provided!");
        }
        AppUser authenticatedUser = userRepo.findUserByCredentials(username,password);

        if(authenticatedUser == null){
            throw new AuthenticationException("No user found with the provided credential");
        }
        return authenticatedUser;
    }

    public AppUser register(AppUser newUser){
        if(!isUserValid(newUser)){
            //TODO implement a custom InvalidRequestException
            throw new RuntimeException("Invalid user field values provided during registration!");
        }

        if(userRepo.findUserByUsername(newUser.getUserName()) != null){
            //TODO implement a custom ResourcePersistenceExcetion
            throw new RuntimeException("Provided username is already in use!")  ;

        }
        newUser.setRole(Role.BASIC_MEMBER);
        return userRepo.save(newUser);

    }

    public Set<AppUser> getAllUsers(){
        return new HashSet<>();
    }

    public Set<AppUser> getUsersByRole(){
        return new HashSet<>();
    }
    public AppUser getUserByID(int id){
        return null;
    }
    public AppUser getUserByUsername(String username){
        return null;
    }

    public boolean deleteUserById(int id){
        return false;
    }

    public boolean update(AppUser updatedUser){
        return false;
    }

    /**
     * Validates that the given user and its fields are valid (not null or empty strings).
     * does not perform validation on id or role fields.
     * @param user
     * @return true or false depending on if the user was valid or not
     */
    public boolean isUserValid (AppUser user){
        if (user==null) return false;

        if(user.getFirstName() == null || user.getFirstName().trim().equals(""))return false;
        if(user.getLastName() == null || user.getLastName().trim().equals(""))return false;
        if(user.getUserName() == null || user.getUserName().trim().equals(""))return false;
        if(user.getPassWord() == null || user.getPassWord().trim().equals(""))return false;
        return true;

    }
}

