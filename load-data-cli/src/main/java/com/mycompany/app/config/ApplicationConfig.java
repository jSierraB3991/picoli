package com.mycompany.app.config;

import com.google.inject.AbstractModule;
import com.mycompany.app.repository.database.ClientRepository;
import com.mycompany.app.repository.database.LazyDataRepository;
import com.mycompany.app.repository.database.impl.ClientRepositoryImpl;
import com.mycompany.app.repository.database.impl.LazyDataRepositoryImpl;
import com.mycompany.app.service.ClientService;
import com.mycompany.app.service.impl.ClientServiceImpl;
import com.mycompany.app.utils.FileProcessor;
import com.mycompany.app.utils.impl.FileProcessorImpl;

public class ApplicationConfig extends AbstractModule {

    @Override
    protected void configure() {
        // REPOSITORIES
        bind(ClientRepository.class).to(ClientRepositoryImpl.class);
        bind(LazyDataRepository.class).to(LazyDataRepositoryImpl.class);

        //UTILS
        bind(FileProcessor.class).to(FileProcessorImpl.class);

        // SERVICES
        bind(ClientService.class).to(ClientServiceImpl.class);
    }
}
