package com.revature.revabooks.repos;

import com.revature.revabooks.db.UserDB;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import javax.swing.*;
import java.util.Optional;

import static com.revature.revabooks.AppDriver.app;

public class UserRepository {

	private UserDB userDataset = UserDB.userDataset;

	public UserRepository(){
		System.out.println("[LOG] - Instantiating " + this.getClass().getName());
	}

	public Optional<AppUser> findUserByCredentials(String username, String password){

		return userDataset.findUserByCredentials(username, password);

//		if(!username.equals("admin") && !password.equals("p4ssw0rd")){
//			return null;
////			// TODO implement a custom ResourceNotFoundException
////			throw new RuntimeException("No user found with the given credentials!");
//		}
//
//		return new AppUser(1, "Adam", "Inn", "admin", "p4ssw0rd", Role.ADMIN);
////		return new AppUser(1, "Adam", "Inn", "admin", "p4ssw0rd", Role.ADMIN);
	}

	public Optional<AppUser> findUserByUsername(String username){
		return userDataset.findUserByUsername(username);
	}

	public AppUser save(AppUser newUser){
//		return newUser;
		return userDataset.addUser(newUser);
	}
}
