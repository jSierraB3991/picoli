package com.jsierrab3991.picocli.springboot.command;

import com.jsierrab3991.picocli.springboot.subcommands.ListSubCommand;
import com.jsierrab3991.picocli.springboot.utils.Colors;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@CommandLine.Command(name = "clients",
        version = "1.0.0",
        mixinStandardHelpOptions = true,
        requiredOptionMarker = '*',
        description = "This is a CLI for lazy clients",
        optionListHeading = "%nOptions are%n",
        header = "Clients CLI",
        footerHeading = "%nCopyright %n",
        footer = "\tDeveloped by Juan David Sierra",
        subcommandsRepeatable = true,
        subcommands = {
                ListSubCommand.class,
        })
@RequiredArgsConstructor
@Component
public class LoadCommand implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        var colorConsole = new Colors(Colors.TEXT_GREEN, Colors.TEXT_BG_BLACK,
                "[clients] Welcome to Client CLI");
        System.out.println(colorConsole.getColoredString());
    }
}