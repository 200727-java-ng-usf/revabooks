package com.revature.revabooks.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("No resources found using the specified criteria.");
    }
}
