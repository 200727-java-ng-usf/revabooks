package com.revature.revbooks.screens;

import java.util.Scanner;
import static com.revature.revbooks.AppDriver.*;

public class HomeScreen extends Screen {


    public HomeScreen() {
        super("HomeScreen", "/home");
        System.out.println("[log] - HomeScreen Instantiating  ");
    }

    @Override
    public void render() {



        System.out.println(" 1) Login");
        System.out.println(" 2) Register");
        System.out.println(" 3) Exit");

        try {
            Scanner console = new Scanner(System.in);
            System.out.println(">");
            String userSelecting = console.nextLine();

            switch (userSelecting){
                case "1": app.getRouter().navigate("/login");
                break;
                case "2": app.getRouter().navigate("/register");
                break;
                case "3": app.setAppRunning(false);
                break;
                default:
                    System.out.println("[log]- Invalid !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
