package com.mycompany.app.config;

import com.google.inject.AbstractModule;
import com.mycompany.app.repository.database.ClientRepository;
import com.mycompany.app.repository.database.impl.ClientRepositoryImpl;
import com.mycompany.app.service.ClientService;
import com.mycompany.app.service.impl.ClientServiceImpl;

public class ApplicationConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(ClientRepository.class).to(ClientRepositoryImpl.class);
        bind(ClientService.class).to(ClientServiceImpl.class);
    }
}
