package com.revature.revabooks.screens;

import static com.revature.revabooks.AppDriver.app;

public class DashboardScreen extends Screen {

    public DashboardScreen() {
        super("DashboardScreen", "/dashboard");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {
//      System.out.println("Dashboard works!");

        while(app.isSessionValid()) {
            System.out.println("Welcome to Revabooks!\n");
            System.out.println("1) Search Books");
            System.out.println("2) View Profile");
            System.out.println("3) Logout");

            try {
                System.out.print("> ");
                String selection = app.getConsole().readLine().trim();

                switch (selection) {
                    case "1":
                        app.getRouter().navigate("/search");
                        break;
                    case "2":
                        app.getRouter().navigate("/profile");
                        break;
                    case "3":
                        app.invalidateCurrentSession();
                        break;
                    default:
                        System.out.println("[LOG] - Invalid selection!");
                }

                //          app.setAppRunning(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}
