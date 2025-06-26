package com.example.bankApplication.mapper;

import com.example.bankApplication.dto.ClientReqDTO;
import com.example.bankApplication.dto.ClientRespDTO;
import com.example.bankApplication.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientReqDTO clientReqDTO){
        Client client = new Client();
        client.setFirstname(clientReqDTO.getFirstname());
        client.setLastname(clientReqDTO.getLastname());
        client.setEmail(clientReqDTO.getEmail());
        client.setPhone(clientReqDTO.getPhone());
        client.setAddress(clientReqDTO.getAddress());

        return client;
    }

    public ClientRespDTO toDto(Client client){
        ClientRespDTO clientRespDTO = new ClientRespDTO();
        clientRespDTO.setClientId(client.getClientId());
        clientRespDTO.setFirstname(client.getFirstname());
        clientRespDTO.setLastname(client.getLastname());
        clientRespDTO.setEmail(client.getEmail());
        clientRespDTO.setPhone(client.getPhone());
        clientRespDTO.setAddress(client.getAddress());

        return clientRespDTO;
    }
}
