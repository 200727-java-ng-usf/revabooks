package com.revature.revabooks.util;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.screens.DashboardScreen;
import com.revature.revabooks.screens.HomeScreen;
import com.revature.revabooks.screens.LoginScreen;
import com.revature.revabooks.screens.RegisterScreen;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.revature.revabooks.AppDriver.app;

public class AppState {
	private BufferedReader console;
	private AppUser currentUser;
	private ScreenRouter router;
	private boolean appRunning;
	private boolean debug = false;

	public AppState(){
		if(app.isDebug()) System.out.println("[LOG] - Initializing Application...");

		appRunning = true;
		console = new BufferedReader(new InputStreamReader(System.in));

		final UserRepository userRepo = new UserRepository();
		final UserService userService = new UserService(userRepo);

		router = new ScreenRouter();
		router.addScreen(new HomeScreen())
			  .addScreen(new DashboardScreen())
		 	  .addScreen(new LoginScreen(userService))
			  .addScreen(new RegisterScreen(userService))
			  ;

		if(app.isDebug()) System.out.println("[LOG] - Application Initialization complete.");
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

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
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
