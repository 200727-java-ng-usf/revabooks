package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.repos.UserRepository;

import java.util.*;

import static com.revature.revabooks.AppDriver.app;

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
	public void authenticate(String username, String password){

		// Validate that the provided username and password are not non-values
		if(username == null || username.trim().equals("") || password == null || password.trim().equals("")){
			throw new InvalidRequestException("Invalid credential values provided");
		}

//		List<AppUser> users = Arrays.asList(new AppUser(), new AppUser());
//		users.forEach(user -> System.out.println(user)); // double colon operator = method reference operator.

		AppUser authUser =  userRepo.findUserByCredentials(username,password)
				.orElseThrow(AuthenticationException::new);

		app.setCurrentUser(authUser);

//		Optional<AppUser> _authUser = userRepo.findUserByCredentials(username, password);
//
//		if(!_authUser.isPresent()){
//			throw new AuthenticationException("No user found with the provided credentials");
//		}
//
//		return _authUser.get();
	}

	public void register(AppUser newUser){
		//
		if(!isUserValid(newUser)){
			throw new InvalidRequestException("Invalid user field values provided during registration!");
		}

		Optional<AppUser> existingUser = userRepo.findUserByUsername(newUser.getUserName());

		if(existingUser.isPresent()){
			throw new AuthenticationException("Provided username is already in use!");
		}

		newUser.setRole(Role.BASIC_MEMBER);
		Optional<AppUser> registeredUser = userRepo.save(newUser);

		app.setCurrentUser(newUser);

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
