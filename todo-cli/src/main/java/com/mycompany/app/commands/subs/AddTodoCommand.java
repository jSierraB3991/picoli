package com.mycompany.app.commands.subs;

import com.mycompany.app.service.TodoService;
import com.mycompany.app.service.impl.TodoServiceImpl;

import picocli.CommandLine;

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
public class AddTodoCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-m", "--message"},
            required = true,
            description = "Todo note or a message")
    String[] messages;

    private TodoService service;

    public AddTodoCommand() {
      super();
      this.service = new TodoServiceImpl();
    }

    @Override
    public Integer call() throws Exception {
        Arrays.asList(messages).forEach( m -> this.service.createTodo(m));
        return 0;
    }
}
