package com.revature.revabooks.screens;

import java.io.Console;

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
                String userSelection = Console.Re

                switch(userSelection) {
                    case "1":

                    case "2":

                    case "3":


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
