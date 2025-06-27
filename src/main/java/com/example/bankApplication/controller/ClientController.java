package com.example.bankApplication.controller;

import com.example.bankApplication.configuration.common.ApiResponse;
import com.example.bankApplication.dto.ClientReqDTO;
import com.example.bankApplication.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    @PostMapping("/register/client")
    public ResponseEntity<ApiResponse> save(@RequestBody @Validated ClientReqDTO clientReqDTO){
        var client = clientService.registerClient(clientReqDTO);
        return ResponseEntity.ok(new ApiResponse("client register successfully",client.getFirstname()));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer clientId){
        clientService.delete(clientId);
        return ResponseEntity.ok(new ApiResponse("client deleted successfully",null));
    }
}
