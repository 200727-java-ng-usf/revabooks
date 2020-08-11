package com.revature.revabooks.repos;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.models.Role;

import javax.swing.*;

public class UserRepository {

	// TODO replace mock implementation with in-memory persistence
	public AppUser findUserByCredentials(String username, String password){

		if(!username.equals("admin") && !password.equals("p4ssw0rd")){
			return null;
//			// TODO implement a custom ResourceNotFoundException
//			throw new RuntimeException("No user found with the given credentials!");
		}

		return new AppUser(1, "Adam", "Inn", "admin", "p4ssw0rd", Role.ADMIN);
//		return new AppUser(1, "Adam", "Inn", "admin", "p4ssw0rd", Role.ADMIN);
	}
}
