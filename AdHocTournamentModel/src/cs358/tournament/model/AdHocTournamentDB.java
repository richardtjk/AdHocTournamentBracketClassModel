package cs358.tournament.model;

/*
 * Notes:
 * 
 * To Connect to the Database
 * 
 * In order to use JDBC to connect to the database, put the mysqlconnector.jar
 * in your jre/lib/ext folder
 * 
 * OR 
 * 
 * Add the jar to the classpath c:\folder\mariadb-java-client-2.7.2.jar;
 * 
 */
import java.sql.*;

public class AdHocTournamentDB {

	public static final String URL = "jdbc:mariadb://144.13.22.59:3306";
	public static final String DATABASE_NAME = "AdHocTournament";
	public static final String USER = "appUser"; // restricted permissions user
	public static final String PASSWORD = "appUserPwd";

	private static Connection connection = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection != null)
			return connection;

		try {
			connection = DriverManager.getConnection(URL + "/" + DATABASE_NAME, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return connection;

	}

	public void finalize() throws SQLException {
		connection.close();
	}

}
