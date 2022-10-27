package com.jsierrab3991.picocli.springboot.service;

import com.jsierrab3991.picocli.springboot.response.ClientResponse;
import com.jsierrab3991.picocli.springboot.response.LazyDataResponse;

import java.util.List;

public interface ClientService {
    List<LazyDataResponse> findAllLazyData();

    List<ClientResponse> findAll(int dataNumber);
}