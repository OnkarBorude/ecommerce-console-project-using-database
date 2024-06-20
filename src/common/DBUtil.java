package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtil {
	 static String url = "jdbc:mysql:///ecommerce";
	 static String username = "root";
	 static String password = "@onkar9765";
	private static Connection connection;
	private static Statement statement;
	static {
		
		try {
			Connection connection=DriverManager.getConnection(url, username, password);
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet resultset=statement.executeQuery(query);
		return resultset;
	}
	public static void executeQuery(String query) throws SQLException {
		statement.execute(query);
	}

}
