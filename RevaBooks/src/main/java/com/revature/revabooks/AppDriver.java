package com.revature.revabooks;

import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.screens.LoginScreen;
import com.revature.revabooks.screens.RegisterScreen;
import com.revature.revabooks.services.UserService;

public class AppDriver {
	private static boolean debug = true;

	public static boolean isDebug() {
		return debug;
	}

	public static void setDebug(boolean debug) {
		AppDriver.debug = debug;
	}
/*
	Domain driven approach -> focus on implementing user stories one at a time.
	 */

	public static void main(String[] args) {

		UserRepository userRepo = new UserRepository();
		UserService userService = new UserService(userRepo);

		RegisterScreen registerScreen = new RegisterScreen(userService);
		registerScreen.render();

		LoginScreen loginScreen = new LoginScreen(userService);
		loginScreen.render();
	}
}
