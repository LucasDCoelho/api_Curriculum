package com.curriculum.api_cadastro_curriculum.domain.enums;

import lombok.Getter;

@Getter
public enum UserRole {
    DEV("dev"),
    ADMIN("admin"),
    USER("user");

    private final String role;

    UserRole(String role){
        this.role = role;
    }

}
