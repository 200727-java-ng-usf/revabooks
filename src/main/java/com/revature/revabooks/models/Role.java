package com.revature.revabooks.models;

public enum Role {

    ADMIN("Admin"),
    MANAGER("Manager"),
    PREMIUM_MEMBER("Premium Member"),
    BASIC_MEMBER("Basic Member"),
    LOCKED("Locked");

    private String roleName;

    Role(String name) {
        this.roleName = name;
    }



    public static Role getByName(String name) {
        for (Role role : Role.values()) {
            if (role.roleName.equals(name)) {
                return role;
            }

        }
        return LOCKED;
    }

        @Override
        public String toString () {
            return "Role{" +
                    "roleName='" + roleName + '\'' +
                    '}';
        }

    }

