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

	public UserService(UserRepository repo) {
		System.out.println("[LOG] - Instantiating " + this.getClass().getName());
		userRepo = repo;
//		userRepo = new UserRepository(); // tight coupling ~hard~ impossible to unit test
	}

	/**
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public AppUser authenticate(String username, String password){

		// Validate that the provided username and password are not non-values
		if(username == null || username.trim().equals("") || password == null || password.trim().equals("")){
			// TODO implement a custom invalid request exception.
			throw new InvalidRequestException("Invalid credential values provided");
		}
		AppUser authenticatedUser = userRepo.findUserByCredentials(username, password);

		if(authenticatedUser == null){
			// TODO implement a custom AuthenticationException
			throw new AuthenticationException("No user found with the provided credentials");
		}

		return authenticatedUser;
	}

	public AppUser register(AppUser newUser){
		//
		if(!isUserValid(newUser)){
			//TODO implement a custom InvalidRequestException
			throw new InvalidRequestException("Invalid user field values provided during registration!");
		}
		if(userRepo.findUserByUsername(newUser.getUserName()) != null){
			// TODO implement a custom ResourcePersistenceException
			throw new AuthenticationException("Provided username is already in use!");
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

	public AppUser getUserByUserName(String username){
		return null;
	}

	public boolean deleteUserByID(int id){
		return false;
	}

	public boolean update(AppUser updatedUser){
		return false;
	}

	/**
	 * Validates that the given user and its fields are valid (not null or empty strings). Does not
	 * perform validation on id or Role fields.
	 *
	 * @param user
	 * @return true if the user is valid.
	 */
	public boolean isUserValid(AppUser user){

		if(user == null) return false;
		if(user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
		if(user.getLastName() == null || user.getLastName().trim().equals("")) return false;
		if(user.getUserName() == null || user.getUserName().trim().equals("")) return false;
		if(user.getPassword() == null || user.getPassword().trim().equals("")) return false;

		return true;
	}
}
