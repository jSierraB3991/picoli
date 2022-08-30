package com.mycompany.app.commands;

import com.mycompany.app.response.ClientRequest;
import com.mycompany.app.service.ClientService;
import lombok.RequiredArgsConstructor;
import picocli.CommandLine;

@CommandLine.Command(name = "load",
        version = "1.0.0",
        mixinStandardHelpOptions = true,
        requiredOptionMarker = '*',
        description = "This is a simple Hello Command",
        header = "Sample Command",
        footerHeading = "%nCopyright %n",
        footer = "\tDeveloped by Juan David Sierra",
        optionListHeading = "%nOptions are%n")
@RequiredArgsConstructor
public class LoadCommand implements Runnable  {
    @CommandLine.Option(names = {"-f", "--file"},
            required = true,
            description = "Provide files when information for user for app",
            paramLabel = "<file source>")
    String file;

    private final ClientService service;

    @Override
    public void run() {
        service.saveClient(ClientRequest.builder()
                        .address("calle luna")
                        .email("judas3991")
                        .aleatoryText("random")
                        .country("col")
                        .region("ame")
                        .aleatoryNumber(23)
                        .name("jd")
                .build());
        System.out.println(file);
    }
}
