package com.revature.revabooks.screens;

import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.revature.revabooks.AppDriver.app;

public class DashboardScreen extends Screen{

	public DashboardScreen(){
		super("DashboardScreen", "/dashboard");
		if(app.isDebug()) System.out.println("[LOG] - Instantiating " + this.getClass().getName());

	}

	/**
	 * Renders the login screen menu to the console.
	 */
	@Override
	public void render(){
		System.out.println("Dashboard works!");

	}
}
