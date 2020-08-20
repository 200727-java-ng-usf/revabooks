package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

public class SearchBooksScreen extends Screen {

    private UserService userService;

    public SearchBooksScreen(UserService userService) {
        super("SearchBooksScreen", "/searchBooks");
    }

    @Override
    public void render() {
        System.out.println("It works");
    }
}
