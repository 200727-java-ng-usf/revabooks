package com.revature.revabooks.screens;

import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.revature.revabooks.AppDriver.app;

public class DashboardScreen extends Screen{

	public DashboardScreen(){
		super("DashboardScreen", "/dashboard");
		System.out.println("[LOG] - Instantiating " + this.getClass().getName());

	}

	/**
	 * Renders the login screen menu to the console.
	 */
	@Override
	public void render(){
		String prompt;

		while(app.isSessionValid()){
			System.out.println("Welcome to your Dashboard!\n");
			System.out.println("1) Search Books");
			System.out.println("2) View Profile");
			System.out.println("3) Logout");
			try {
				System.out.print("> ");
				prompt = app.getConsole().readLine().trim();

				switch (prompt) {
					case "1":
						app.getRouter().navigate("/search");
						break;
					case "2":
						app.getRouter().navigate("/profile");
						break;
					case "3":
						app.invalidateCurrentSession();
						break;
					default:
						System.out.println("[LOG] - Invalid Selection!");
						break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
