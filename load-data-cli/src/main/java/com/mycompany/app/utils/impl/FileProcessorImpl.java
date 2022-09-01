package com.mycompany.app.utils.impl;

import com.mycompany.app.response.ClientRequest;
import com.mycompany.app.utils.FileProcessor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FileProcessorImpl implements FileProcessor {

    public List<ClientRequest> fileProcessOfClient(String stringFile) {
        String[] header = {"name", "email", "address", "region", "country", "text", "numberrange"};
        return fileProcess(header, stringFile, (csvRecord) -> {
                var name = csvRecord.get(header[0]);
                var email = csvRecord.get(header[1]);
                var address = csvRecord.get(header[2]);
                var region = csvRecord.get(header[3]);
                var country = csvRecord.get(header[4]);
                var text = csvRecord.get(header[5]);
                var number = csvRecord.get(header[6]);
                return ClientRequest.builder()
                        .name(name)
                        .email(email)
                        .address(address)
                        .region(region)
                        .country(country)
                        .aleatoryText(text)
                        .aleatoryNumber(Integer.parseInt(number))
                        .build();
        });
    }

    private <T> List<T> fileProcess(String[] headers, String fileName, Function<CSVRecord, T> funcIterable) {
        var requests = new ArrayList<T>();
        try (
                var reader = Files.newBufferedReader(Paths.get(fileName));
                var csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader(headers)
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim())
        ) {

            for (var record : csvParser) {
                requests.add(funcIterable.apply(record));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return requests;
    }
}
