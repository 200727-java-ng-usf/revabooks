package com.revature.revabooks.util;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepo;
import com.revature.revabooks.screens.DashboardScreen;
import com.revature.revabooks.screens.HomeScreen;
import com.revature.revabooks.screens.LoginScreen;
import com.revature.revabooks.screens.RegisterScreen;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader console;
    private AppUser currentUser;
    private ScreenRouter router;
    private boolean appRunning;

    public AppState(){
        System.out.println("[LOG]");

        appRunning =true;
        console = new BufferedReader( new InputStreamReader(System.in));

        final UserRepo userRepo = new UserRepo();
        final UserService userService = new UserService(userRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new DashboardScreen());

        System.out.println("[LOG] - Application initialization complete");
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
}
