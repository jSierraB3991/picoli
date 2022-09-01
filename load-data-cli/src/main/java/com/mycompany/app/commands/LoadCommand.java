package com.mycompany.app.commands;

import com.mycompany.app.commands.subcommands.LazyLoad;
import com.mycompany.app.utils.ConsoleColors;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
            LazyLoad.class
        })
@RequiredArgsConstructor
public class LoadCommand implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        var colorConsole = new ConsoleColors(ConsoleColors.TEXT_GREEN, ConsoleColors.TEXT_BG_BLACK,
                "[clients] Welcome to Client CLI");
        System.out.println(colorConsole.getColoredString());
    }
}
