package com.example.todo.commands.subs;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "list",
        aliases = { "ls", "show" },
        description = "This is a Sub Command and lists all the tasks as per the parameters",
        version = "1.0.0",
        mixinStandardHelpOptions = true,
        requiredOptionMarker = '*',
        footerHeading = "%nCopyright %n",
        footer = "\tDeveloped by Juan David Sierra",
        header = "List Todo SubCommand",
        optionListHeading = "%nOptions are%n")
public class ListTodoCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        return 0;
    }
}