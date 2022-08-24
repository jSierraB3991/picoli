package com.mycompany.app.service;

import com.mycompany.app.models.Status;
import com.mycompany.app.models.Todo;

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
