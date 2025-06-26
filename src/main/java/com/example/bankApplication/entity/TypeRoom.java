package com.example.bankApplication.entity;

import lombok.Getter;

@Getter
public enum TypeRoom {
    TYPE_ROOM_STANDARD("STANDARD"),
    TYPE_ROOM_DELUXE("DELUXE"),
    TYPE_ROOM_SUITE("SUITE"),
    TYPE_ROOM_VIP("VIP");

    TypeRoom(String typeRoom){

    }
}
