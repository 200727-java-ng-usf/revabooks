package com.revature.revabooks.utilities;

import com.revature.revabooks.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Set<Screen> screenSet = new HashSet<>();

    public Set<Screen> getScreenSet() {
        return screenSet;
    }

    public ScreenRouter addScreen(Screen screen) {
        screenSet.add(screen);
        return this;
    }

    public void navigate(String route) {
        screenSet.stream()
                .filter(screen -> screen.getRoute().equals(route))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No screen found."))
                .render();
    }
}
