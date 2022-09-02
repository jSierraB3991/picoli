package com.mycompany.app.service;

import com.mycompany.app.response.ClientRequest;
import com.mycompany.app.response.ClientResponse;
import com.mycompany.app.response.LazyDataResponse;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    ClientResponse saveClient(ClientRequest request);

    void saveFile(String fileName);

    List<ClientResponse> findAll(int length);

    List<LazyDataResponse> findAllLazyData();

    ClientResponse findById(Long idClient);

    boolean isFileMigrate(String fileName);
}
