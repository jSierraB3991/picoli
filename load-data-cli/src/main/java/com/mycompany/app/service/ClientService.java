package com.mycompany.app.service;

import com.mycompany.app.response.ClientRequest;
import com.mycompany.app.response.ClientResponse;

public interface ClientService {

    ClientResponse saveClient(ClientRequest request);
}
