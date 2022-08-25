package com.mycompany.app.commands.subs;

import com.mycompany.app.models.Todo;
import com.mycompany.app.service.TodoService;
import com.mycompany.app.service.impl.TodoServiceImpl;

import picocli.CommandLine;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@CommandLine.Command(name = "add", aliases = { "create",
		"plus" }, version = "1.0.0", mixinStandardHelpOptions = true, requiredOptionMarker = '*', footerHeading = "%nCopyright %n", footer = "\tDeveloped by Juan David Sierra", description = "This is a Sub Command to 'todo' and adds the tasks to the list", header = "Add Todo SubCommand", optionListHeading = "%nOptions are%n")
public class AddTodoCommand implements Callable<Integer> {

	@CommandLine.Option(names = { "-m", "--message" }, required = true, description = "Todo note or a message")
	String[] messages;

	private TodoService service;

	public AddTodoCommand() {
		super();
		this.service = new TodoServiceImpl();
	}

	@Override
	public Integer call() throws Exception {
		List<Todo> todos = Arrays.asList(messages).stream().map(m -> this.service.createTodo(m))
				.collect(Collectors.toList());
		todos.forEach(todo -> {
			System.out.println("Id      = " + todo.getId());
			System.out.println("Message = " + todo.getMessage());
			System.out.println("Status  = " + todo.getStatus());
			System.out.println("");
		});
		return 0;
	}
}
