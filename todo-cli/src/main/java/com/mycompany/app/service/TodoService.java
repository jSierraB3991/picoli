package com.mycompany.app.service;

import com.mycompany.app.models.Status;
import com.mycompany.app.models.Todo;

import java.util.List;

public interface TodoService {

	Todo createTodo(String message);

	Todo updateMessage(Integer taskId, String message) throws Exception;

	Todo updateStatus(Integer taskId, Status status) throws Exception;

	boolean markTaskCompletedById(Integer taskId);

	boolean deleteById(Integer taskId);

	List<Todo> findAll();

	List<Todo> findAllByIds(List<Integer> ids);

	List<Todo> findByStatus(Status status);

	Todo finById(Integer taskId) throws Exception;
}
