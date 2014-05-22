package utwente.groep18.databaseEntries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;

import com.mysema.query.sql.PostgresTemplates;
import com.mysema.query.sql.SQLTemplates;

public class DBConnection {

	private static final String NEW_DB_URL = "jdbc:postgresql://datainfo.ewi.utwente.nl:5432/di18";
	private static final String NEW_USER = "di18";
	private static final String NEW_PASS = ".Z4J2CPz";
	
	private static Connection connection = null;
	public static final SQLTemplates dialect = new PostgresTemplates();	
	
	public static Connection getConnection() {
		if (connection == null) {
			makeConnection();
		}
		return connection;
	}

	private static synchronized void makeConnection() {
		if (connection == null) {
			try {			
				connection = (Connection) DriverManager.getConnection(NEW_DB_URL, NEW_USER, NEW_PASS);
				BasicConfigurator.configure();
			} catch (SQLException e) {
				System.err.println("Connection setup failed");
			}
		}
	}
	
	public static synchronized void closeConnection() {
		if (connection != null) {
			try {			
				connection.close();
			} catch (SQLException e) {
				System.err.println("Connection close failed");
			}
		}
	}

}
