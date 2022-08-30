package com.mycompany.app.repository.database;

import com.mycompany.app.model.Client;

public class ClientRepository extends HibernateRepository<Client> {

    public Client save (Client client){
        return this.saveModel(client);
    }
}
