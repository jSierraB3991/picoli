package com.mycompany.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mycompany.app.models.Status;
import com.mycompany.app.models.Todo;

public class SqliteConnectionData {

	public void initDataBase() {
		var connection = SqliteConnection.connectd();
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS TODO " + "( id INT AUTO_INCREMENT NOT NULL, "
					+ "message           TEXT    NOT NULL, " + " status            TEXT     NOT NULL)";
			stmt.executeUpdate(sql);
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	private void insertOrUpdate(String sql) {
		var connection = SqliteConnection.connectd();
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	private List<Todo> find(String sql) {
		var connection = SqliteConnection.connectd();
		Statement stmt = null;
		List<Todo> list = new ArrayList<Todo>();

		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String message = rs.getString("message");
				Status statusEnum = Status.valueOf(rs.getString("status"));

				list.add(Todo.builder().id(id).message(message).status(statusEnum).build());
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return list;
	}

	public Todo createTodo(Todo todo) {
		Integer id = findAllTodoByStatus(Status.DEFAULT).size() + 1;
		String sql = "INSERT INTO TODO (id, message, status) " + "VALUES (" + id + ", '" + todo.getMessage() + "', '"
				+ todo.getStatus().name() + "' );";
		insertOrUpdate(sql);
		todo.setId(id);
		return todo;
	}

	public List<Todo> findAllTodoByStatus(Status status) {
		String sql = "SELECT id, message, status FROM TODO";
		if(Status.DEFAULT != status) {
			sql = sql + " WHERE status == '" + status.name() + "';";
		}else {
			sql = sql + ";";
		}
		return find(sql);
	}
	
	public Todo findById(Integer taskId) throws Exception {
		String sql = "SELECT id, message, status FROM TODO WHERE id == " + taskId + ";";
		List<Todo> list = find(sql);
		if(list.size() < 1) {
			throw new Exception("Invalid Todo With id: " + taskId);
		} 
		return list.get(0);
	}
	
	public List<Todo> findAllById(List<Integer> ids) {
		String idsJoin = ids.stream().map(id -> id.toString()).collect(Collectors.joining(","));
		String sql = "SELECT id, message, status FROM TODO WHERE id IN (" + idsJoin + ");";
		return find(sql);
	}

	private void updateTodo(String sql, Integer taskId) {
		insertOrUpdate(sql + " WHERE id = " + taskId + ";");
	}

	public void updateStatus(Integer taskId, Status status) {
		String sql = "UPDATE TODO SET status = '" + status.name() + "' ";
		updateTodo(sql, taskId);
	}

	public void updateMessage(Integer taskId, String message) {
		String sql = "UPDATE TODO SET message = '" + message + "' ";
		updateTodo(sql, taskId);
	}
}
