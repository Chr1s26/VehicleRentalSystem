package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgsqlConnectionFactory implements ConnectionFactory {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/rental_db";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "root";
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Connection createConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

}
