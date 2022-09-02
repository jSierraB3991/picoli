package com.mycompany.app.repository.database;

import com.mycompany.app.model.Client;

import java.util.List;

public interface ClientRepository extends HibernateRepository<Client, Long> {

    List<Client> findAllLength(int length);
}
