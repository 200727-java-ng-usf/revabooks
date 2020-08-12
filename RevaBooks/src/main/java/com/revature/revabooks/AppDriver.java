package com.revature.revabooks;

import com.revature.revabooks.screens.LoginScreen;
import com.revature.revabooks.screens.RegisterScreen;

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
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.render();

		RegisterScreen registerScreen = new RegisterScreen();
		registerScreen.render();
	}
}
