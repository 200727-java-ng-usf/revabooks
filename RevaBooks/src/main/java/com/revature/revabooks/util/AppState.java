package com.revature.revabooks.util;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.screens.*;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {
	private BufferedReader console;
	private AppUser currentUser;
	private ScreenRouter router;
	private boolean appRunning;

	public AppState(){
		System.out.println("[LOG] - Initializing Application...");

		appRunning = true;
		console = new BufferedReader(new InputStreamReader(System.in));

		final UserRepository userRepo = new UserRepository();
		final UserService userService = new UserService(userRepo);

		router = new ScreenRouter();
		router.addScreen(new HomeScreen())
				.addScreen(new DashboardScreen())
				.addScreen(new SearchBooksScreen())
				.addScreen(new UserProfileScreen())
		 	  .addScreen(new LoginScreen(userService))
			  .addScreen(new RegisterScreen(userService))
			  ;

		System.out.println("[LOG] - Application Initialization complete.");
	}

	public BufferedReader getConsole() {
		return console;
	}

	public AppUser getCurrentUser() {
		return currentUser;
	}

	public ScreenRouter getRouter() {
		return router;
	}

	public boolean isAppRunning() {
		return appRunning;
	}

	public void setAppRunning(boolean appRunning) {
		this.appRunning = appRunning;
	}

	public void invalidateCurrentSession(){
		currentUser = null;
	}

	public boolean isSessionValid(){
		return (this.currentUser != null);
	}

	public void setCurrentUser(AppUser newUser) {
		currentUser = newUser;
	}
}
