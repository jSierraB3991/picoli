package com.example.commands.subcommands;

import picocli.CommandLine;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.Callable;
@CommandLine.Command(name = "add",
        aliases = { "create", "plus" },
        version = "1.0.0",
        mixinStandardHelpOptions = true,
        requiredOptionMarker = '*',
        footerHeading = "%nCopyright %n",
        footer = "\tDeveloped by Juan David Sierra",
        description = "This is a Sub Command to 'todo' and adds the tasks to the list",
        header = "Add Todo SubCommand",
        optionListHeading = "%nOptions are%n")
public class AddTodoSubCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-m", "--message"},
            required = true,
            description = "Todo note or a message")
    String[] messages;

    @CommandLine.Option(names = { "--create-date", "-cd" },
            required = false,
            description = "Created date from the todo[s]"
    )
    LocalDate createDate;

    @Override
    public Integer call() throws Exception {
        System.out.println("\n[add] Add Command: \nCreate Date: " + createDate);
        System.out.println("Message[s]");
        Arrays.asList(messages).forEach(System.out::println);
        return 0;
    }
}
