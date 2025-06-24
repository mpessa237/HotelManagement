package com.example.bankApplication.entity;

import lombok.Getter;


@Getter

public enum Role {

    ROLE_CUSTOMER("CUSTOMER"),
    ROLE_ADMIN("ADMIN");

    Role(String role) {

    }
}
