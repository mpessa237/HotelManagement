package com.example.bankApplication.service;

import com.example.bankApplication.dto.RegistrationRequest;
import com.example.bankApplication.entity.Role;
import com.example.bankApplication.entity.User;
import com.example.bankApplication.repository.UserRepo;
import jakarta.mail.MessageRemovedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class RegistrationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    //pour la coherence des data
    @Transactional
    public User register(RegistrationRequest registrationRequest)throws MessageRemovedException{
        User user = new User();
        user.setFirstname(registrationRequest.getFirstname());
        user.setLastname(registrationRequest.getLastname());
        user.setPassword(registrationRequest.getPassword());
        user.setEmail(registrationRequest.getEmail());
        //pour encoder le password
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setEnabled(false);
        user.setAccountLocked(false);
        user.setRoles(Set.of(Role.ROLE_CUSTOMER));

        return userRepo.save(user);
    }
}
