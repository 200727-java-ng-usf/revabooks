package com.revature.revabooks;

import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.screens.HomeScreen;
import com.revature.revabooks.screens.LoginScreen;
import com.revature.revabooks.screens.RegisterScreen;
import com.revature.revabooks.services.UserService;
import com.revature.revabooks.util.AppState;

public class AppDriver {
	public static AppState app = new AppState();
/*
	Domain driven approach -> focus on implementing user stories one at a time.
	 */

	public static void main(String[] args) {
		app.setDebug(true);
		while(app.isAppRunning()){
			app.getRouter().navigate("/home");
		}
//
//		HomeScreen homeScreen = new HomeScreen();
//		homeScreen.render();
//		UserRepository userRepo = new UserRepository();
//		UserService userService = new UserService(userRepo);
//
//		RegisterScreen registerScreen = new RegisterScreen(userService);
//		registerScreen.render();
//
//		LoginScreen loginScreen = new LoginScreen(userService);
//		loginScreen.render();
	}
}
