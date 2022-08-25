package com.mycompany.app.commands.subs;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.Callable;

import com.mycompany.app.models.Status;
import com.mycompany.app.service.TodoService;
import com.mycompany.app.service.impl.TodoServiceImpl;

import picocli.CommandLine;

@CommandLine.Command(name = "update", aliases = { "mod",
		"change" }, description = "This is a Sub Command and update todo", version = "1.0.0", mixinStandardHelpOptions = true, requiredOptionMarker = '*', footerHeading = "%nCopyright %n", footer = "\tDeveloped by Juan David Sierra", header = "Update Todo SubCommand", optionListHeading = "%nOptions are%n")
public class UpdateTodoCommand implements Callable<Integer> {

	@CommandLine.Option(names = { "-i", "--id" }, required = true, description = "Id of message")
	Integer[] ids;

	@CommandLine.Option(names = { "-m", "--message" }, description = "Todo note or a message")
	String message;

	@CommandLine.Option(names = { "-s", "--status" }, description = "Todo status %nIN_PROGRESS%nCOMPLETED")
	Status status;

	@CommandLine.Option(names = { "-c", "--complete" }, description = "Mark all todo With Status Complete")
	boolean markComplete;

	private final TodoService service;

	public UpdateTodoCommand() {
		this.service = new TodoServiceImpl();
	}

	@Override
	public Integer call() throws Exception {
		if (markComplete) {
			Arrays.asList(ids).forEach(this.service::markTaskCompletedById);
		} else {
			if (Objects.nonNull(message)) {
				if (ids.length > 1) {
					throw new Exception("Invalid todo with alone message");
				}
				var todo = this.service.updateMessage(ids[0], message);
				System.out.println("Id      = " + todo.getId());
				System.out.println("Message = " + todo.getMessage());
				System.out.println("Status  = " + todo.getStatus());
				System.out.println("");
			}
			if (Objects.nonNull(status) && !Status.DEFAULT.equals(status)) {
				Arrays.asList(ids).forEach(id -> {
					try {
						this.service.updateStatus(id, status);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
			}
		}
		return 0;
	}

}
