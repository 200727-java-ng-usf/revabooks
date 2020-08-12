package com.revature.revabooks.services;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepo;

import java.util.HashSet;
import java.util.Set;

public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo repo){
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
        userRepo = new UserRepo();
    }

    public AppUser authentic(String username, String password){
        //validate that the provided username and password are not non values
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

    public AppUser register(AppUser newUser){
        if(!validateUserFields(newUser)){
            throw new RuntimeException("Invalid");
        }

        if(userRepo.findUserByUsername(newUser.getUsername())!=null){
            throw new RuntimeException();
        }

        newUser.setRole(Role.BASIC_MEMBER);
        return userRepo.save(newUser);
    }

    public AppUser update(AppUser updatedUser){
        return null;
    }





    public boolean validateUserFields(AppUser user){
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }

    public Set<AppUser> getAllUsers(){
        return new HashSet<>();
    }
    public Set<AppUser> getUserByRole(){
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

    public boolean updateUser(AppUser updatedUser){
        return false;
    }
}
