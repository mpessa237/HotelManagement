package com.example.bankApplication.entity;

import lombok.Getter;

@Getter
public enum StatusPayment {
    STATUS_PAYMENT_PAID("PAID"),
    STATUS_PAYMENT_UNPAID("UNPAID"),
    STATUS_PAYMENT_PARTIAL("PARTIAL");

    StatusPayment(String statusPayment){

    }

}
