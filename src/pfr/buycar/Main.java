package pfr.buycar;

import java.sql.SQLException;

import pfr.buycar.ui.MenuPrincipal;

public class Main {

	public static void main(String[] args) throws SQLException {
<<<<<<< HEAD
		
		MenuPrincipal.afficher();
=======

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
>>>>>>> 596041c (maj main)

	}
}
