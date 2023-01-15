package com.mycompany.app.service.impl;

import com.google.inject.Inject;
import com.mycompany.app.mapper.ClientMapper;
import com.mycompany.app.mapper.LazyDataMapper;
import com.mycompany.app.model.Client;
import com.mycompany.app.model.LazyData;
import com.mycompany.app.repository.database.ClientRepository;
import com.mycompany.app.repository.database.LazyDataRepository;
import com.mycompany.app.response.ClientRequest;
import com.mycompany.app.response.ClientResponse;
import com.mycompany.app.response.LazyDataResponse;
import com.mycompany.app.service.ClientService;

import java.time.LocalDateTime;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final LazyDataRepository lazyDataRepository;
    private final ClientMapper clientMapper;
    private final LazyDataMapper lazyDataMapper;

    @Inject
    public ClientServiceImpl(ClientRepository clientRepository, LazyDataRepository lazyDataRepository,
                             ClientMapper clientMapper, LazyDataMapper lazyDataMapper) {
        this.clientRepository = clientRepository;
        this.lazyDataRepository = lazyDataRepository;
        this.clientMapper = clientMapper;
        this.lazyDataMapper = lazyDataMapper;
    }

    @Override
    public ClientResponse saveClient(ClientRequest request) {
        var client = clientMapper.toDomain(request);
        clientRepository.save(client);
        return clientMapper.toResponse(client);
    }

    @Override
    public void saveFile(String fileName) {
        lazyDataRepository.save(LazyData.builder()
                .creationDate(LocalDateTime.now())
                .name(fileName)
                .build());
    }

    @Override
    public List<ClientResponse> findAll(int length) {
        return clientMapper.toResponse(this.clientRepository.findAllLength(length));
    }

    @Override
    public List<LazyDataResponse> findAllLazyData() {
        return lazyDataMapper.toResponse(lazyDataRepository.findAll(LazyData.class));
    }

    @Override
    public ClientResponse findById(Long idClient) {
        var oClient = clientRepository.findBy(idClient, Client.class);
        if(oClient.isEmpty()){
            throw new RuntimeException("Unable Client");
        }
        return clientMapper.toResponse(oClient.get());
    }

    @Override
    public boolean isFileMigrate(String fileName) {
        return lazyDataRepository.isFileMigrate(fileName);
    }
}
