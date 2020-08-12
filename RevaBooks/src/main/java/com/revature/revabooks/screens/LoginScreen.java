package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginScreen extends Screen{
	private String name;
	// UserrService is a dependency to the LoginScreen
	private UserService userService;

	// Inject the dependency through the constructor (constructor injection)
	public LoginScreen(UserService userService){
		System.out.println("[LOG] - Instantiating " + this.getClass().getName());

		// loosely coupled, because this class is not responsible for instantiation of a UserService
		this.userService = userService;
//		userService = new UserService(); // tight coupling! We aim for loose coupling
	}

	/**
	 * Renders the login screen menu to the console.
	 */
	@Override
	public void render(){
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String username;
		String password;

		try{
			System.out.println("Please provide your login credentials");
			System.out.print("Username: ");
			username = console.readLine();
			System.out.print("Password: ");
			password = console.readLine();

//			System.out.println("You entered: " + username + "/" + password);
			AppUser authUser = userService.authenticate(username, password);

			System.out.println(authUser);

			console.close();
		} catch(Exception ioe) {
			ioe.printStackTrace();
		}

		System.out.println();

	}
}
