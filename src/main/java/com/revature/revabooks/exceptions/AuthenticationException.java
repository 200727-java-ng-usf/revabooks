package com.revature.revabooks.exceptions;

public class AuthenticationException extends RuntimeException{

        public AuthenticationException() {
            super("Failed to authenticate");
        }
    }

