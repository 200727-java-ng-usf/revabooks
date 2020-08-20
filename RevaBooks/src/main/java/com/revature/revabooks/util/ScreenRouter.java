package com.revature.revabooks.util;

import com.revature.revabooks.screens.Screen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static com.revature.revabooks.AppDriver.app;

public class ScreenRouter {
	private Set<Screen> screens = new HashSet<>();

	public Set<Screen> getScreens() {
		return screens;
	}

	public ScreenRouter addScreen(Screen screen){
		if(app.isDebug()) System.out.println("[LOG] - Loading " + screen.getName() + " into the router");
		screens.add(screen);
		return this;
	}

	public void navigate(String route){

//		for (Screen screen : screens) {
//			if(screen.getRoute().equals(route)) {
//				screen.render();
//				return;
//			}
//		}
//
//		throw new RuntimeException("No screen found with that route.");

		screens.stream()
				.filter(screen -> screen.getRoute().equals(route))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No screen found with that route."))
				.render();
	}
}
