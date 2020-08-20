package com.revature.revabooks.screens;

public class DashboardScreen extends Screen{

    public DashboardScreen(){
        super ("DashboardScreen","/dash");
        System.out.println("");
    }

    @Override
    public void render() {
        System.out.println("Dash works!");

    }
}
