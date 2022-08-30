package com.mycompany.app.mapper;

import com.mycompany.app.model.Client;
import com.mycompany.app.response.ClientRequest;
import com.mycompany.app.response.ClientResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {
    public static ClientMapper INSTANCE = new ClientMapper();

    public Client toDomain(ClientRequest request) {
        return Client.builder()
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .aleatoryText(request.getAleatoryText())
                .region(request.getRegion())
                .country(request.getCountry())
                .aleatoryNumber(request.getAleatoryNumber())
                .build();
    }
    public ClientResponse toResponse(Client client) {
        return ClientResponse.builder()
                .name(client.getName())
                .id(client.getId())
                .email(client.getEmail())
                .address(client.getAddress())
                .aleatoryText(client.getAleatoryText())
                .region(client.getRegion())
                .country(client.getCountry())
                .aleatoryNumber(client.getAleatoryNumber())
                .build();
    }

    public List<Client> toDomain(List<ClientRequest> request) {
        return request.stream().map(this::toDomain).collect(Collectors.toList());
    }
    public List<ClientResponse> toResponse(List<Client> client){
        return client.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
