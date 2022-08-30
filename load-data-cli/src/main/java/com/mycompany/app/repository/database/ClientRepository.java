package com.mycompany.app.repository.database;

import com.mycompany.app.model.Client;

public class ClientRepository extends HibernateRepository<Client> {

    public void save(Client client){
        this.saveModel(client);
    }
}
