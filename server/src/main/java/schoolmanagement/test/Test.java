package schoolmanagement.test;

import java.sql.*;

public class Test {

	// this method is used for testing connection when user changes config
	// parameters in main form
	public static void testConnection(String dbHost, String dbPort, String dbName, String dbUsername, String dbPassword)
			throws SQLException {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?serverTimezone=UTC", dbUsername,
				dbPassword)) {
			conn.close();
			System.out.println("Successfully connected to database!");
		}
	}
}
