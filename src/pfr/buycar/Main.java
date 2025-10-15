package pfr.buycar;

import java.sql.Connection;
import java.sql.SQLException;

import pfr.buycar.dao.DBConnection;
import pfr.buycar.dao.UtilisateurDao;
import pfr.buycar.dao.VoitureDao;
import pfr.buycar.dao.VoitureMock;
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

		userTest.create(new clientMock("Pierre", "Jean", "pjean", "14485", 2, "pjean@exemple.com"));

		VoitureDao voitureTest = new VoitureDao(conn);

		voitureTest.create(new VoitureMock("SUV004", "Toyota", "RAV4", 2010, "Rouge", 15000, 3));

		// Methode getAll à définir dans l'interface CRUD
		// System.out.println("Utilisateurs : " + userTest.getAll());

		DBConnection.closeConnection();
	}
}
