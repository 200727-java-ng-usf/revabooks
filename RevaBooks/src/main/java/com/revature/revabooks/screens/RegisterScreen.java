package com.revature.revabooks.screens;

import com.revature.revabooks.AppDriver;
import com.revature.revabooks.db.UserDB;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class RegisterScreen extends Screen {
	private String name = "RegisterScreen";
	private String route = "/register";
	private UserService userService;

	public RegisterScreen(UserService userService){
		System.out.println("[LOG] - Instantiating " + this.getClass().getName());
		this.userService = userService;
//		userService = new UserService();
	}

	@Override
	public void render(){

		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String firstName;
		String lastName;
		String userName;
		String password;

		try{
			System.out.println("Sign up for a new account!");
			System.out.println("First name: ");
			firstName = console.readLine();
			System.out.println("Last name: ");
			lastName = console.readLine();
			System.out.println("Username: ");
			userName = console.readLine();
			System.out.println("Password: ");
			password = console.readLine();

			AppUser newUser = new AppUser(firstName, lastName, userName, password);

			AppUser registeredUser = userService.register(newUser);
			System.out.println(registeredUser);
		} catch(Exception e) {
		    e.printStackTrace();
		}


	}
}
