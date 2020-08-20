package com.revature.revbooks.util;

import com.revature.revbooks.models.AppUser;
import com.revature.revbooks.repos.UserRepository;
import com.revature.revbooks.screens.*;
import com.revature.revbooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader console;
    private AppUser currentUser;
    private ScreenRouter router;
    private boolean appRunning;

    public AppState() {
        System.out.println("[log] - initializing application ....");

        appRunning = true;
        console = new BufferedReader((new InputStreamReader(System.in)));

        final UserRepository userRepository = new UserRepository();
        final UserService userService = new UserService(userRepository);
        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new DashBoardScreen())
                .addScreen(new SearchBookScreen())
                .addScreen(new UserProfileScreen());

    }

    public void setCurrentUser(AppUser currentUser) {
        this.currentUser = currentUser;
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

    public  boolean isSessionValid(){
         return (this.currentUser != null);
    }
}
