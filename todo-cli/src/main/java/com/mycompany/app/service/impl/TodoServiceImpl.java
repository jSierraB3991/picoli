package com.mycompany.app.service.impl;

import com.mycompany.app.models.Status;
import com.mycompany.app.models.Todo;
import com.mycompany.app.service.TodoService;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TodoServiceImpl implements TodoService {

    @Override
    public Todo createTodo(String message) {
       System.out.println(message); 
       return null;
    }

    @Override
    public Todo createTodo(String message, LocalDate date) {
      System.out.println(message);
      System.out.println(date);
      return null;
    }

    @Override
    public Todo updateMessage(Long taskId, String message) {
      return null;
    }

    @Override
    public Todo updateStatus(Long taskId, Status status) {
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
        return null;
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
