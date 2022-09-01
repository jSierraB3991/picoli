package com.mycompany.app.commands;

import com.mycompany.app.response.ClientRequest;
import com.mycompany.app.service.ClientService;
import com.mycompany.app.utils.ConsoleColors;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import me.tongfei.progressbar.ProgressBarStyle;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
public class LoadCommand implements Runnable {
    @CommandLine.Option(names = {"-f", "--file"},
            required = true,
            description = "Provide files when information for user for app",
            paramLabel = "<file source>")
    String[] stringFiles;

    private final ClientService service;

    @SneakyThrows
    @Override
    public void run() {
        for (var stringFile: stringFiles ) {
            showProgressBarByFile(stringFile);
        }
    }

    private void showProgressBarByFile(String stringFile) throws InterruptedException {
        var folders = stringFile.split("/");
        var fileName = folders[folders.length - 1];

        var collection = getData(stringFile);
        var pbb = new ProgressBarBuilder()
                .setStyle(ProgressBarStyle.UNICODE_BLOCK)
                .setTaskName(fileName + ":")
                .showSpeed();
        for (var clientRequest : ProgressBar.wrap(collection, pbb)) {
            //TODO REMOVE MESSAGE FOR HIBERNATE
            //service.saveClient(clientRequest);
            TimeUnit.MILLISECONDS.sleep(20);
        }
        var colorConsole = new ConsoleColors(ConsoleColors.TEXT_GREEN, ConsoleColors.TEXT_BG_BLACK, "Finish migrations for " + stringFile);
        System.out.println(colorConsole.getColoredString());
        System.out.println();
    }

    private List<ClientRequest> getData(String stringFile) {
        String[] header = {"name", "email", "address", "region", "country", "text", "numberrange"};
        var requests = new ArrayList<ClientRequest>();
        try (
                var reader = Files.newBufferedReader(Paths.get(stringFile));
                var csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader(header)
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
            for (var csvRecord : csvParser) {
                var name = csvRecord.get(header[0]);
                var email = csvRecord.get(header[1]);
                var address = csvRecord.get(header[2]);
                var region = csvRecord.get(header[3]);
                var country = csvRecord.get(header[4]);
                var text = csvRecord.get(header[5]);
                var number = csvRecord.get(header[6]);
                requests.add(ClientRequest.builder()
                        .name(name)
                        .email(email)
                        .address(address)
                        .region(region)
                        .country(country)
                        .aleatoryText(text)
                        .aleatoryNumber(Integer.parseInt(number))
                        .build());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return requests;
    }
}
