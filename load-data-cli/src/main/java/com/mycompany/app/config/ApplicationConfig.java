package com.mycompany.app.config;

import com.mycompany.app.repository.database.ClientRepository;
import com.mycompany.app.service.ClientService;
import com.mycompany.app.service.impl.ClientServiceImpl;

public class ApplicationConfig {

    public static ClientRepository clientRepository() {
        return new ClientRepository();
    }

    public static ClientService clientService() {
        return new ClientServiceImpl(clientRepository());
    }
}
