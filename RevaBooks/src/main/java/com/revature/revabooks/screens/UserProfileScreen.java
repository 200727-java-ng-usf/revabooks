package com.revature.revabooks.screens;

import static com.revature.revabooks.AppDriver.app;

public class UserProfileScreen extends Screen{

	public UserProfileScreen() {
		super("UserProfileScreen", "/profile");
	}

	@Override
	public void render() {
		System.out.println(app.getCurrentUser());
	}
}
