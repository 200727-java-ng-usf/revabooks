package com.revature.revbooks.screens;

import static com.revature.revbooks.AppDriver.app;

public class SearchBookScreen extends Screen {



    public SearchBookScreen() {
        super("SearchBookScreen", "/searchBook");
        System.out.println("[LOG] = Instantiating " + super.getName());

    }

    @Override
    public void render() {

        System.out.println("Search Books Works");


    }
}
