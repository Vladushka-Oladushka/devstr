package com.devstr.model.enumerations;

public enum UserRole {

    DEVELOPER("DEVELOPER"),
    GROUP_MANAGER("GROUP_MANAGER"),
    TECHNICAL_MANAGER("TECHNICAL_MANAGER"),
    PROJECT_MANAGER("PROJECT_MANAGER"),
    ADMIN("ADMIN");

    String userRole;

    private UserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getFullName() {
        return userRole;
    }

}
