package com.revature.revabooks.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("no resources found using the specfied criteria ");
    }
}
