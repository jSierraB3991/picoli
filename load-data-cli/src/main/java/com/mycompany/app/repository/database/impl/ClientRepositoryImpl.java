package com.mycompany.app.repository.database.impl;

import com.mycompany.app.model.Client;
import com.mycompany.app.repository.database.ClientRepository;

import java.util.List;

public class ClientRepositoryImpl extends HibernateRepositoryImpl<Client, Long> implements ClientRepository {
    @Override
    public List<Client> findAllLength(int length) {
        return this.findAllPageFinal(Client.class, length);
    }
}
