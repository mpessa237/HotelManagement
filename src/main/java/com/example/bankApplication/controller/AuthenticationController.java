package com.example.bankApplication.controller;

import com.example.bankApplication.configuration.common.ApiResponse;
import com.example.bankApplication.dto.AuthenticationRequest;
import com.example.bankApplication.dto.AuthenticationResponse;
import com.example.bankApplication.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse> authenticate(@RequestBody @Validated AuthenticationRequest authenticationRequest){
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(authenticationRequest);
        return ResponseEntity.ok(new ApiResponse("Successfully authenticated",authenticationResponse));
    }
}
