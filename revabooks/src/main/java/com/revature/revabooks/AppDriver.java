package com.revature.revabooks;

import com.revature.revabooks.repos.UserRepo;
import com.revature.revabooks.screens.LoginScreen;
import com.revature.revabooks.screens.RegisterScreen;
import com.revature.revabooks.services.UserService;
import com.revature.revabooks.util.AppState;

public class AppDriver {

    public static AppState app = new AppState();

    public static void main(String[] args) {

      while (app.isAppRunning()){
          app.getRouter().navigate("/home");
      }

    }
}
