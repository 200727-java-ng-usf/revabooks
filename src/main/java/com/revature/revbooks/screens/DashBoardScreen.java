package com.revature.revbooks.screens;

import com.revature.revbooks.util.AppState;

import java.util.Scanner;

import static com.revature.revbooks.AppDriver.app;

public class DashBoardScreen extends Screen {
    public DashBoardScreen() {
        super("DashboardScreen", "/dashboard");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {
        System.out.println(" 1) Search Books");
        System.out.println(" 2) View Profile");
        System.out.println(" 3) Logout");

        try {
            Scanner console = new Scanner(System.in);
            System.out.println(">");
            String userSelecting = console.nextLine();

            switch (userSelecting){
                case "1": app.getRouter().navigate("/searchBook");
                    break;
                case "2": app.getRouter().navigate("/userProfile");
                    break;
                case "3": app.setCurrentUser(null);
                    app.getRouter().navigate("/home");

                    break;
                default:
                    System.out.println("[log]- Invalid !");
                    render();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
