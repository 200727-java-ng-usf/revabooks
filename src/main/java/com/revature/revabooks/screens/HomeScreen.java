package com.revature.revabooks.screens;

import java.io.Console;

import static com.revature.revabooks.AppDriver.app;

public class HomeScreen extends Screen{

        public HomeScreen() {
            super("")
        }

        @Override
        public void render() {

            System.out.println("Welcome to Revabooks!");
            System.out.println();
            System.out.println();
            System.out.println();

            try {
                System.out.println("> ");
                String userSelection = Console.

                switch(userSelection) {
                    case "1":
                        app.getRouter().navigate("/login");
                        break;
                    case "2":
                        app.getRouter().navigate("/register");
                        break;
                    case "3":
                        app.setAppRunning(false);
                        break;

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
