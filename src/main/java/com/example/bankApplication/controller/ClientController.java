package com.example.bankApplication.controller;

import com.example.bankApplication.configuration.common.ApiResponse;
import com.example.bankApplication.dto.ClientReqDTO;
import com.example.bankApplication.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> save(@RequestBody @Validated ClientReqDTO clientReqDTO){
        var client = clientService.registerClient(clientReqDTO);
        return ResponseEntity.ok(new ApiResponse("client register successfully",client.getFirstname()));
    }
}
