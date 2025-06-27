package com.example.bankApplication.service;
import com.example.bankApplication.dto.ClientReqDTO;
import com.example.bankApplication.dto.ClientRespDTO;
import com.example.bankApplication.entity.Client;
import com.example.bankApplication.entity.Role;
import com.example.bankApplication.entity.User;
import com.example.bankApplication.mapper.ClientMapper;
import com.example.bankApplication.repository.ClientRepo;
import com.example.bankApplication.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class ClientService {
    private final ClientRepo clientRepo;
    private final ClientMapper clientMapper;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public ClientService(ClientRepo clientRepo, ClientMapper clientMapper, UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.clientRepo = clientRepo;
        this.clientMapper = clientMapper;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    public ClientRespDTO registerClient(ClientReqDTO clientReqDTO){
        Client client = clientMapper.toEntity(clientReqDTO);
        Client savedClient = clientRepo.save(client);

        User user = new User();
        user.setFirstname(savedClient.getFirstname());
        user.setLastname(savedClient.getLastname());
        user.setPassword(passwordEncoder.encode(savedClient.getEmail() + LocalDateTime.now().getYear()));
        user.setEmail(savedClient.getEmail());
        user.setEnabled(false);
        user.setAccountLocked(false);
        user.setRoles(Set.of(Role.ROLE_CUSTOMER));

        userRepo.save(user);
        return clientMapper.toDto(savedClient);
    }

    public void delete(Integer clientId){
        clientRepo.findById(clientId)
                .orElseThrow(()->new EntityNotFoundException("client not found!!"));
        clientRepo.deleteById(clientId);
    }
}
