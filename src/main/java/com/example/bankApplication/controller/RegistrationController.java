package com.example.bankApplication.controller;

import com.example.bankApplication.configuration.common.ApiResponse;
import com.example.bankApplication.dto.RegistrationRequest;
import com.example.bankApplication.service.RegistrationService;
import jakarta.mail.MessageRemovedException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody @Validated RegistrationRequest registrationRequest) throws MessageRemovedException {
        var user = registrationService.register(registrationRequest);
        return ResponseEntity.ok(new ApiResponse("user register successfully",user.getFirstname()));
    }
}
