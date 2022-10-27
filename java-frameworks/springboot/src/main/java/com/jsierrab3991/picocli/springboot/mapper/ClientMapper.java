package com.jsierrab3991.picocli.springboot.mapper;

import com.jsierrab3991.picocli.springboot.model.Client;
import com.jsierrab3991.picocli.springboot.response.ClientResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientResponse toResponse(Client client);

    List<ClientResponse> toResponse(List<Client> client);
}
