package com.mycompany.app.commands.subcommands;

import com.google.inject.Guice;
import com.mycompany.app.config.ApplicationConfig;
import com.mycompany.app.service.ClientService;
import com.mycompany.app.utils.ConsoleColors;
import com.mycompany.app.utils.FileProcessor;
import lombok.extern.log4j.Log4j2;
import me.tongfei.progressbar.ProgressBar;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "load",
        version = "1.0.0",
        mixinStandardHelpOptions = true,
        requiredOptionMarker = '*',
        description = "This is a Command for load data for csv files",
        header = "Load Command",
        footerHeading = "%nCopyright %n",
        footer = "\tDeveloped by Juan David Sierra",
        optionListHeading = "%nOptions are%n")
@Log4j2
public class LoadSubCommand implements Callable<Integer> {
    private ClientService service;
    private FileProcessor fileProcessor;

    public LoadSubCommand() {
        var injector = Guice.createInjector(new ApplicationConfig());
        this.service = injector.getInstance(ClientService.class);
        this.fileProcessor = injector.getInstance(FileProcessor.class);
    }

    @CommandLine.Option(names = {"-f", "--file"},
            required = true,
            description = "Provide files when information for user for app",
            paramLabel = "<file source>")
    String[] stringFiles;

    @Override
    public Integer call() throws Exception {
        for (var stringFile: stringFiles ) {
            showProgressBarByFile(stringFile);
        }
        return 1;
    }

    private void showProgressBarByFile(String stringFile) throws InterruptedException {
        var folders = stringFile.split("/");
        var fileName = folders[folders.length - 1];

        var isMigrate = service.isFileMigrate(fileName);
        if (isMigrate) {
            printLogColor("This file: " + fileName + " is a save");
            return;
        }
        log.info("Start Reading file {}", fileName);
        var collection = fileProcessor.fileProcessOfClient(stringFile);

        try (ProgressBar pb = new ProgressBar("Reading data of " + fileName, collection.size() + 1)) {
            pb.step().setExtraMessage("Save file " + fileName);
            service.saveFile(fileName);
            for (var clientRequest : collection) {
                service.saveClient(clientRequest);
                pb.step().setExtraMessage("Save data for " + clientRequest.getName());
            }
        }

        printLogColor("Finish migrations for " + fileName);
    }

    private void printLogColor(String message) {
        var colorConsole = new ConsoleColors(ConsoleColors.TEXT_GREEN, ConsoleColors.TEXT_BG_BLACK,
                message);
        System.out.println(colorConsole.getColoredString());
        System.out.println();
    }
}
