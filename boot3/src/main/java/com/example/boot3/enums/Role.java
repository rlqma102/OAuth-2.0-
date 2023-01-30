package com.example.boot3.enums;


public enum Role {

    GUEST("ROLE_GUEST"),
    USER("ROLE_USER"),
    ADMIN("ADMIN"),
    CAT("CAT");

    private final String key;

    Role(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
