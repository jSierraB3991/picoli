package com.jsierrab3991.picocli.springboot.service.impl;

import com.jsierrab3991.picocli.springboot.mapper.ClientMapper;
import com.jsierrab3991.picocli.springboot.mapper.LazyDataMapper;
import com.jsierrab3991.picocli.springboot.repository.ClientRepository;
import com.jsierrab3991.picocli.springboot.repository.LazyDataRepository;
import com.jsierrab3991.picocli.springboot.response.ClientResponse;
import com.jsierrab3991.picocli.springboot.response.LazyDataResponse;
import com.jsierrab3991.picocli.springboot.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientServiceImpl  implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final LazyDataMapper lazyDataMapper;
    private final LazyDataRepository lazyDataRepository;

    @Override
    public List<LazyDataResponse> findAllLazyData() {
        return lazyDataMapper.toResponse(lazyDataRepository.findAll());
    }

    @Override
    public List<ClientResponse> findAll(int dataNumber) {
        return clientMapper.toResponse(clientRepository.findAll(PageRequest.of(0, dataNumber, Sort.by("id"))).toList());
    }
}
