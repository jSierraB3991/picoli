package com.mycompany.app.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqliteConnection {

	public static Connection connectd() {
		Connection connection = null;

		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:todo.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return connection;
	}
}
