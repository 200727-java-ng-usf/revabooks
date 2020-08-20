package com.revature.revabooks.screens;

public abstract class Screen {
    /**
     * Displays a particular menu depending on the screen implementation
     */

    private String name;
    private String route;

    protected Screen(String name, String route){
        this.name =name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public abstract void render();

    public abstract void add(Screen screen);
}
