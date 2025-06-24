package com.example.bankApplication.service;

import com.example.bankApplication.dto.AuthenticationRequest;
import com.example.bankApplication.dto.AuthenticationResponse;
import com.example.bankApplication.entity.User;
import com.example.bankApplication.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){

        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        var claims = new HashMap<String,Object>();
        var user = ((User)auth.getPrincipal());
        System.out.println(user);
        claims.put("fullName",user.fullName());
        // claims.put("roles",user.getRoles());
        //claims.put("email",user.getEmail());

        var jwt = jwtService.generateToken(claims,user);

        return AuthenticationResponse.builder().token(jwt).build();
    }
}
