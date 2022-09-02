package com.mycompany.app.mapper;

import com.mycompany.app.model.Client;
import com.mycompany.app.response.ClientRequest;
import com.mycompany.app.response.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "jsr330")
public interface ClientMapper {
    @Mappings({
            @Mapping(source = "name", target = "name")
    })
    Client toDomain(ClientRequest request);

    ClientResponse toResponse(Client client);

    List<Client> toDomain(List<ClientRequest> request);
    List<ClientResponse> toResponse(List<Client> client);
}
