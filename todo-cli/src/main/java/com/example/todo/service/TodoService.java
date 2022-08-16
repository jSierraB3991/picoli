package com.example.todo.service;

import com.example.todo.models.Status;
import com.example.todo.models.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    Todo createTodo(String message);

    Todo updateMessage(Long taskId, String message);

    Todo updateStatus(Long taskId, Status status);

    boolean markTaskCompletedById(Long taskId);

    boolean deleteById(Long taskId);

    List<Todo> findAll();

    List<Todo> findAllByIds(List<Long> ids);

    List<Todo> findByStatus(Status status);

    Optional<Todo> finById(Long taskId);
}
