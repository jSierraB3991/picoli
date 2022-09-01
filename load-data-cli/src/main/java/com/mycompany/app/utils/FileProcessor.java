package com.mycompany.app.utils;

import com.mycompany.app.response.ClientRequest;

import java.util.List;

public interface FileProcessor {
    List<ClientRequest> fileProcessOfClient(String stringFile);
}
