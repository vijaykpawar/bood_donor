package com.donor.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	private static String username;
	private static String password;
	private static String connection_url;

	static {
		try {
			username = PropertyDataLoader.getInstance().getMessage("username");
			password = PropertyDataLoader.getInstance().getMessage("password");
			connection_url = PropertyDataLoader.getInstance().getMessage(
					"connection_url");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	Connection connection = null;

	public Connection getConnection() {
		try {
			String USERNAME = username;
			String PASSWORD = password;
			String URL = connection_url;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
