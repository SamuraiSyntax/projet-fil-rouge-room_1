package pfr.buycar;

import java.sql.Connection;
import java.sql.SQLException;

import pfr.buycar.dao.DBConnection;
import pfr.buycar.dao.UtilisateurDao;
import pfr.buycar.dao.clientMock;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("===Test de la connexion à la base de données===");
		
		Connection conn = DBConnection.getConnection();
		
		if (conn != null) {
            System.out.println("Connexion active : " + conn);
        } else {
            System.err.println("Échec de la connexion à la base !");
        }
		
		System.out.println("\n=== Tests DAO ===");
		
		UtilisateurDao userTest = new UtilisateurDao(conn);
		
		userTest.create(new clientMock("Dupont", "Serge", "sdupont", "12345", 2, "serge@exemple.com"));
		
			
		// Methode getAll à définir dans l'interface CRUD
		//System.out.println("Utilisateurs : " + userTest.getAll());
		
		 DBConnection.closeConnection();

	}

}
