package com.revature.revabooks.screens;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.revature.revabooks.AppDriver.app;

public class HomeScreen extends Screen{

	public HomeScreen(){
		super("HomeScreen", "/home");
		System.out.println("[LOG] - Instantiating " + this.getClass().getName());

	}

	/**
	 * Renders the login screen menu to the console.
	 */
	@Override
	public void render(){
		String prompt;
		System.out.println("Welcome to RevaBooks!\n");
		System.out.println("1) Login");
		System.out.println("2) Register");
		System.out.println("3) Exit Application");

		try{
			System.out.print("> ");
			prompt = app.getConsole().readLine();

			switch(prompt){
				case "1":
					app.getRouter().navigate("/login");
					break;
				case "2":
					app.getRouter().navigate("/register");
					break;
				case "3":
					app.setAppRunning(false);
					// how can we stop the application smoothly (without using System.exit());
					break;
				default:
					System.out.println("[LOG] - Invalid Selection!");
					break;
			}
//			app.setAppRunning(false);
		} catch(Exception e) {
			e.printStackTrace();
		}


	}
}
