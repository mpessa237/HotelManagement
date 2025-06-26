package com.example.bankApplication.entity;

import lombok.Getter;

@Getter
public enum Status {

    STATUS_CONFIRMED("CONFIRMED"),
    STATUS_CANCELLED("CANCELLED"),
    STATUS_PENDING("PENDING");

    Status(String status){

    }

}
