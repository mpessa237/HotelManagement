package com.example.bankApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRespDTO {
    private Integer clientId;
    private String firstname;
    private String lastname;
    private String email;
    private Integer phone;
    private String address;
}
