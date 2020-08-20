package com.revature.revbooks.screens;

public abstract class Screen {
    /**
     * Display a particular menu
     */


    private String name;
    private String route;

    protected Screen(String name,String route){
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public abstract void render();

}
