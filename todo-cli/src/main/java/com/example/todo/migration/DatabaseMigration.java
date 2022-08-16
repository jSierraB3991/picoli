package com.example.todo.migration;

import com.example.todo.models.Status;
import com.example.todo.service.TodoService;
import com.example.todo.service.impl.TodoServiceImpl;
import lombok.extern.java.Log;

@Log
public class DatabaseMigration {

    public static void Migration1() {
        TodoService service = new TodoServiceImpl();

        if (service.findAll().isEmpty()) {
            var helloCommand = service.createTodo("Create Hello Command");
            var todoCommand = service.createTodo("Create Todo Command");
            var listCommand = service.createTodo("Create List Command");
            var addCommand = service.createTodo("Create Add Command");
            var serviceTask = service.createTodo("Create Service for Storing data");

            log.info("Show All Tasks");
            service.findAll().forEach(System.out::println);

            service.updateStatus(helloCommand.getId(), Status.COMPLETED);
            service.updateStatus(todoCommand.getId(), Status.IN_PROGRESS);
            service.updateStatus(addCommand.getId(), Status.IN_PROGRESS);
            service.updateStatus(listCommand.getId(), Status.IN_PROGRESS);
            service.updateStatus(serviceTask.getId(), Status.COMPLETED);

            log.info("Show Update Tasks");
            service.findAll().forEach(System.out::println);
        }
    }
}
