package com.expertise.ebudget.user.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN("Admin"),
    MANAGER("Admin"),
    USER("User");

    private final String role;

    public static Role fromRole(String role){
        for (Role roles : Role.values()){
            if (roles.getRole().equalsIgnoreCase(role)){
                return roles;
            }
        }
        throw new IllegalArgumentException("No role for : " + role);
    }
}
