package com.mycompany.app.service.impl;

import com.google.inject.Inject;
import com.mycompany.app.mapper.ClientMapper;
import com.mycompany.app.model.LazyData;
import com.mycompany.app.repository.database.ClientRepository;
import com.mycompany.app.repository.database.LazyDataRepository;
import com.mycompany.app.response.ClientRequest;
import com.mycompany.app.response.ClientResponse;
import com.mycompany.app.service.ClientService;

import java.time.LocalDateTime;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final LazyDataRepository lazyDataRepository;

    @Inject
    public ClientServiceImpl(ClientRepository clientRepository, LazyDataRepository lazyDataRepository) {
        this.clientRepository = clientRepository;
        this.lazyDataRepository = lazyDataRepository;
    }

    @Override
    public ClientResponse saveClient(ClientRequest request) {
        var client = ClientMapper.INSTANCE.toDomain(request);
        clientRepository.save(client);
        return ClientMapper.INSTANCE.toResponse(client);
    }

    @Override
    public void saveFile(String fileName) {
        lazyDataRepository.save(LazyData.builder()
                .creationDate(LocalDateTime.now())
                .name(fileName)
                .build());
    }

    @Override
    public boolean isFileMigrate(String fileName) {
        return lazyDataRepository.isFileMigrate(fileName);
    }
}
