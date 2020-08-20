package com.revature.revabooks.screens;

public abstract class Screen {

    private String name;
    private String route;

    protected Screen (String name, String route) {
        this.name;
        this.route;
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public abstract void render();


}
