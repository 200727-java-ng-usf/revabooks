package com.revature.revabooks.screens;

import java.io.IOException;

import static com.revature.revabooks.AppDriver.app;

public class DashboardScreen extends Screen{

    public DashboardScreen() {
        super("DashboardScreen", "/dashboard");
        System.out.println("instantiating" + super.getName());
    }

    @Override
    public void render() {
        System.out.println("Welcome to your Dashboard!\n");
        System.out.println("1) Search Books");
        System.out.println("2) View Profile");
        System.out.println("3) Logout");

        try {
            System.out.print("> ");
            String userSelection = app.getConsole().readLine().trim();

            switch (userSelection) {
                case "1":
                    System.out.println("Searching books...");
                    app.getRouter().navigate("/searchBooks");
                    break;
                case "2":
                    System.out.println("Viewing Profile...,");
                    app.getRouter().navigate("/userProfile");
                    break;
                case "3":
                    app.getRouter().navigate("/home");
                    break;
                default:
                    System.out.println("[LOG] - Invalid selection!");
                    app.getRouter().navigate("/dashboard");
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
