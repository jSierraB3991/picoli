package com.mycompany.app.service.impl;

import com.mycompany.app.repository.database.ClientRepository;
import com.mycompany.app.response.ClientResponse;
import com.mycompany.app.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public ClientResponse saveClient(ClientResponse request) {
        return request;
    }
}
