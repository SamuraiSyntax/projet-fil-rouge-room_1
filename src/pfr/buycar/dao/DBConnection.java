package pfr.buycar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/bdd_projet_fil_rouge_room_1";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static Connection connection;
	
	private DBConnection() {}
	
	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(URL , USER, PASSWORD);
				System.out.println("Connexion réussie à la base de données !");
			}catch (ClassNotFoundException e) {
				throw new SQLException("Pilote JDBC introuvable : ");
			}
		}
		return connection;
	}
	
	public static void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				System.out.println("Connexion fermée.");
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la fermeture : ");
		}
	}
}




