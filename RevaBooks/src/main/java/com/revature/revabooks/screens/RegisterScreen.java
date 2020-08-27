package com.revature.revabooks.screens;

import com.revature.revabooks.AppDriver;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

import static com.revature.revabooks.AppDriver.app;

public class RegisterScreen extends Screen {
	private UserService userService;

	public RegisterScreen(UserService userService){
		super("RegisterScreen", "/register");
		System.out.println("[LOG] - Instantiating " + this.getClass().getName());
		this.userService = userService;
//		userService = new UserService();
	}

	@Override
	public void render(){

		String firstName, lastName, userName, password, email;

		try{
			System.out.println("Sign up for a new account!");
			System.out.println("First name: ");
			firstName = app.getConsole().readLine().trim();
			System.out.println("Last name: ");
			lastName = app.getConsole().readLine().trim();
			System.out.println("Email: ");
			email = app.getConsole().readLine().trim();
			System.out.println("Username: ");
			userName = app.getConsole().readLine().trim();
			System.out.println("Password: ");
			password = app.getConsole().readLine().trim();

			AppUser newUser = new AppUser(firstName, lastName, userName, password, email);
			userService.register(newUser);

			if(app.isSessionValid()){
				app.getRouter().navigate("/dashboard");
			}

		} catch(Exception e) {
		    e.printStackTrace();
		}


	}
}