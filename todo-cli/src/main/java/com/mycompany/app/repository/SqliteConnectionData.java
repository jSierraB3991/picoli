package com.mycompany.app.repository;

import java.util.ArrayList;
import java.util.List;
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
      String sql = "CREATE TABLE IF NOT EXISTS TODO " +
                       "(message           TEXT    NOT NULL, " + 
                        " status            TEXT     NOT NULL)"; 
      stmt.executeUpdate(sql);
      stmt.close();
      connection.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
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
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
  }

  public void createTodo(Todo todo) {
    String sql = "INSERT INTO TODO (message, status) " + 
      "VALUES ('" + todo.getMessage() + "', '" + todo.getStatus().name() + "' );"; 
    insertOrUpdate(sql);
  }

  public List<Todo> findAllTodo() {
    var connection = SqliteConnection.connectd();
    Statement stmt = null;
    List<Todo> list = new ArrayList<Todo>();

    try {
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT rowid as id, message, status FROM TODO;" );
      
      while ( rs.next() ) {
         Long id = rs.getLong("id");
         String message = rs.getString("message");
         String status = rs.getString("status");
         
        list.add(Todo.builder()
             .id(id)
             .message(message)
             .status(Status.valueOf(status))
             .build());
      }
      rs.close();
      stmt.close();
      connection.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    return list;
  }

  private void updateTodo(String sql, long taskId) {
    insertOrUpdate(sql + " WHERE id = " + taskId + ";");
  }

  public void updateStatus(Long taskId, Status status) {
    String sql = "UPDATE TODO SET status = '" + status.name() +"' ";
    updateTodo(sql, taskId);
  }

  public void updateMessage(Long taskId, String message) {
    String sql = "UPDATE TODO SET message = '" + message +"' ";
    updateTodo(sql, taskId);
  }
} 
