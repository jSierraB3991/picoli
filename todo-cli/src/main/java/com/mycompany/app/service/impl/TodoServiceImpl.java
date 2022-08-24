package com.mycompany.app.service.impl;

import com.mycompany.app.models.Status;
import com.mycompany.app.models.Todo;
import com.mycompany.app.service.TodoService;

import com.mycompany.app.repository.SqliteConnectionData;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TodoServiceImpl implements TodoService {

    private final SqliteConnectionData sqlConnection;

    public TodoServiceImpl() {
      super();
      this.sqlConnection = new SqliteConnectionData();
    }

    @Override
    public Todo createTodo(String message) {
       this.sqlConnection.initDataBase();
       Todo todo = Todo.builder()
          .message(message)
          .status(Status.CREATE)
          .build();
       this.sqlConnection.createTodo(todo);
       return todo;
    }

    @Override
    public Todo updateMessage(Long taskId, String message) {
       this.sqlConnection.initDataBase();
       this.sqlConnection.updateMessage(taskId, message);
       return null;
    }

    @Override
    public Todo updateStatus(Long taskId, Status status) {
      this.sqlConnection.initDataBase();
      this.sqlConnection.updateStatus(taskId, status);
      return null;
    }

    private Todo update(Long taskId, String message, Status status) {
       return null;
    }

    @Override
    public boolean markTaskCompletedById(Long taskId) {
        return false; 
    }

    @Override
    public boolean deleteById(Long taskId) {


        return true;
    }

    @Override
    public List<Todo> findAll() {
       this.sqlConnection.initDataBase();
        return this.sqlConnection.findAllTodo();
    }

    @Override
    public List<Todo> findAllByIds(List<Long> ids) {
       return null;
    }

    @Override
    public List<Todo> findByStatus(Status status) {
       return null;
    }

    @Override
    public Optional<Todo> finById(Long taskId) {
       return Optional.empty();
    }
}
