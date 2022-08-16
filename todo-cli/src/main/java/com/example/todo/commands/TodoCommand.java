package com.example.todo.commands;

import com.example.todo.commands.subs.AddTodoCommand;
import com.example.todo.commands.subs.ListTodoCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "todo",
        version = "1.0.0",
        mixinStandardHelpOptions = true,
        requiredOptionMarker = '*',
        description = "This is a Todo Tool which will help us to manage todo activities",
        header = "Todo CLI",
        optionListHeading = "%nOptions are%n",
        footerHeading = "%nCopyright %n",
        footer = "\tDeveloped by Juan David Sierra",
        commandListHeading = "%nSubcommands are %n",
        subcommandsRepeatable = true,
        subcommands = {
                AddTodoCommand.class,
                ListTodoCommand.class
        })
public class TodoCommand implements Callable<Integer> {

    final Integer SUCCESS = 0;

    @Override
    public Integer call() throws Exception {
        System.out.println("[todo] Welcome to Todo");
        return SUCCESS;
    }
}