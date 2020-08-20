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

    public AppState() {
        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepository = new UserRepository();
        final UserService userService = new UserService(userRepository);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
              .addScreen(new RegisterScreen(userService))
              .addScreen(new LoginScreen(userService))
              .addScreen(new DashboardScreen())
              .addScreen(new SearchBooksScreen(userService))
              .addScreen(new UserProfileScreen(userService));

    }

    public BufferedReader getConsole() {
        return console;
    }

    public AppUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(AppUser currentUser) {
        this.currentUser = currentUser;
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

    public void invalidateCurrentUser() {
        currentUser = null;
    }

    public boolean isSessionValid() {
        return (this.currentUser != null);
    }
}
