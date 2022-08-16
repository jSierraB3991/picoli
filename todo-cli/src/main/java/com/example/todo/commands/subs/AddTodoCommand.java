package com.example.todo.commands.subs;

import com.example.todo.service.TodoService;
import com.example.todo.service.impl.TodoServiceImpl;
import lombok.extern.java.Log;
import picocli.CommandLine;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
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
@Log
public class AddTodoCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-m", "--message"},
            required = true,
            description = "Todo note or a message")
    String[] messages;

    @CommandLine.Option(names = { "--create-date", "-cd" },
            required = false,
            description = "Created date from the todo[s]"
    )
    LocalDate createDate;

    private final TodoService service;

    public AddTodoCommand() {
        this.service = new TodoServiceImpl();
    }

    @Override
    public Integer call() throws Exception {
        if (Objects.isNull(this.createDate)) {
            Arrays.asList(messages)
                    .forEach(message -> {
                        var todo = service.createTodo(message);
                        log.info(todo.toString());
                    });
        } else {
            Arrays.asList(messages)
                    .forEach(message -> {
                        var todo = service.createTodo(message, createDate);
                        log.info(todo.toString());
                    });
        }
        return 0;
    }
}