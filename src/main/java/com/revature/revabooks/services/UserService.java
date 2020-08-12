package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;

import java.util.HashSet;
import java.util.Set;

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

    //registration method
    public AppUser register(AppUser newUser){
        if(!isUserValid(newUser)){
            throw new RuntimeException("Invalid user field values during registration.");
        }
        //ensure username hasn't been taken
        if(userRepo.findUserByUsername(newUser.getUsername())!=null){
            throw new RuntimeException("Username already taken!");
        }
        newUser.setRole(Role.BASIC_MEMBER);
        return userRepo.save(newUser);
    }

    public Set<AppUser> getAllUsers(){
        return new HashSet<>();
    }
    public Set<AppUser> getUsersByRoles(){
        return new HashSet<>();
    }
    public AppUser getUserById(int id){
        return null;
    }
    public AppUser getUserByUsername(String username){
        return null;
    }

    public boolean deleteUserById(int id){
        return false;
    }



    public boolean update(AppUser updated){
        return false;
    }

    /**
     * Validates user input fields to ensure they are valid (not null) and not empty.
     * No validation on ID or ROLE fields.
     * @param user
     * @return
     */

    public boolean isUserValid(AppUser user){
        if(user==null) return false;
        if(user.getFirstName()==null || user.getFirstName().equals("")) return false;
        if(user.getLastName()==null || user.getLastName().equals("")) return false;
        if(user.getUsername()==null || user.getUsername().equals("")) return false;
        if(user.getPassword()==null || user.getPassword().equals("")) return false;
        return true;
    }


}
