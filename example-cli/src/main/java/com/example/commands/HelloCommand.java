package com.example.commands;

import picocli.CommandLine;

 @CommandLine.Command(name = "hello",
         version = "1.0.0",
         mixinStandardHelpOptions = true,
         requiredOptionMarker = '*',
         description = "This is a simple Hello Command",
         header = "Sample Command",
         footerHeading = "%nCopyright %n",
         footer = "\tDeveloped by Juan David Sierra",
         optionListHeading = "%nOptions are%n")
public class HelloCommand implements Runnable {

    @CommandLine.Option(names = {"-U", "--user"},
            required = false,
            description = "Provide user name",
            paramLabel = "<user name>")
    String user;

    @Override
    public void run() {
        if (user == null || user.length() == 0) {
            System.out.println("Hello world Of Java with picocli");
        }else {
            System.out.println("Hello " + user +", Of Java with picocli");
        }
    }
}
