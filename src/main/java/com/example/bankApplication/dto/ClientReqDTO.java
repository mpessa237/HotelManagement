package com.example.bankApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientReqDTO {
    private String firstname;
    private String lastname;
    private String email;
    private Integer phone;
    private String address;
}
