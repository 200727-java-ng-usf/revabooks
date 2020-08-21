package com.revature.revabooks.models;

import java.util.Arrays;

public enum Role {

    ADMIN("Admin"), MANAGER("Manager"), PREMIUM_MEMBER("Premium Member"), BASIC_MEMBER("Basic Member"), LOCKED("Locked");
// values declared within enums are constants

    private String rolename;

    Role(String name){
        this.rolename = name;
    }

    public static Role getByName(String name){
        for(Role role : Role.values()){
            if (role.rolename.equals(name)){
                return role;
            }
        }

        return LOCKED;
    }


    @Override
    public String toString() {
        return rolename;
    }
}
