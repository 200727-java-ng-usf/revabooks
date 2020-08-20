package com.revature.revabooks;

import com.revature.revabooks.util.AppState;

public class AppDriver {

    public static AppState app = new AppState();

    public static void main(String[] args) {

        while (app.isAppRunning()) {
            System.out.println("beginning of whileloop" + app.isAppRunning());
            app.getRouter().navigate("/home");
            System.out.println("end of while loop");
        }
    }
}
