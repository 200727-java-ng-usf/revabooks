package com.revature.revabooks.utilities;

import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;
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



    public AppState() {
            appRunning = true;
            console = new BufferedReader(new InputStreamReader(System.in));

            final UserRepository userRepo = new UserRepository();
            final UserService userService = new UserService(userRepo);

            router = new ScreenRouter();
            router.addScreen(new HomeScreen())
                    .addScreen(new RegisterScreen(userService))
                    .addScreen(new LoginScreen(userService));

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

    public void invalidateSession() {
        currentUser = null;
    }

    public boolean isSessionValid() {
        return (this.currentUser != null);
    }
}
