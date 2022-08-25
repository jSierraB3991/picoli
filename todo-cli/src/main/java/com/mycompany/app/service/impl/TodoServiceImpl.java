package com.mycompany.app.service.impl;

import com.mycompany.app.models.Status;
import com.mycompany.app.models.Todo;
import com.mycompany.app.service.TodoService;

import com.mycompany.app.repository.SqliteConnectionData;

import java.util.List;

public class TodoServiceImpl implements TodoService {

	private final SqliteConnectionData sqlConnection;

	public TodoServiceImpl() {
		super();
		this.sqlConnection = new SqliteConnectionData();
	}

	@Override
	public Todo createTodo(String message) {
		this.sqlConnection.initDataBase();
		Todo todo = Todo.builder().message(message).status(Status.CREATE).build();
		return this.sqlConnection.createTodo(todo);
	}

	@Override
	public Todo updateMessage(Integer taskId, String message) throws Exception {
		this.sqlConnection.initDataBase();
		this.sqlConnection.updateMessage(taskId, message);
		return this.finById(taskId);
	}

	@Override
	public Todo updateStatus(Integer taskId, Status status) throws Exception {
		this.sqlConnection.initDataBase();
		this.sqlConnection.updateStatus(taskId, status);
		return this.finById(taskId);
	}

	@Override
	public boolean markTaskCompletedById(Integer taskId) {
		this.sqlConnection.initDataBase();
		this.sqlConnection.updateStatus(taskId, Status.COMPLETED);
		return true;
	}

	@Override
	public boolean deleteById(Integer taskId) {

		return true;
	}

	@Override
	public List<Todo> findAll() {
		this.sqlConnection.initDataBase();
		return this.sqlConnection.findAllTodoByStatus(Status.DEFAULT);
	}

	@Override
	public List<Todo> findAllByIds(List<Integer> ids) {
		this.sqlConnection.initDataBase();
		return this.sqlConnection.findAllById(ids);
	}

	@Override
	public List<Todo> findByStatus(Status status) {
		this.sqlConnection.initDataBase();
		return this.sqlConnection.findAllTodoByStatus(status);
	}

	@Override
	public Todo finById(Integer taskId) throws Exception {
		this.sqlConnection.initDataBase();
		return this.sqlConnection.findById(taskId);
	}
}
