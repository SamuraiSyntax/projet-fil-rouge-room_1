package pfr.buycar.ui;

import java.sql.Connection;
import java.util.Scanner;

import pfr.buycar.dao.UtilisateurDao;
import pfr.buycar.dao.UtilisateurMock;
import pfr.buycar.ui.admin.MenuAdmin;
import pfr.buycar.utils.Icons;

public class MenuConnexion {

	public static String[] afficher(Scanner sc, Connection conn) {
		System.out.println("\n===== CONNEXION =====");
		System.out.print(Icons.ADMIN + " Nom d'utilisateur : ");
		String login = sc.nextLine().trim();

		System.out.print("🔑 Mot de passe : ");
		String mdp = sc.nextLine().trim();

		UtilisateurDao userDao = new UtilisateurDao(conn);
		UtilisateurMock user = userDao.findByLogin(login);

		if (user == null) {
			System.out.println("\n" + Icons.ATTENTION + " Utilisateur inexistant !");
			return null;
		}

		if (!user.getpassword().equals(mdp)) {
			System.out.println("\n" + Icons.ATTENTION + " Mot de passe incorrect !");
			return null;
		}

		// Connexion réussie, redirection selon rôle
		if (user.getRole() == 1) { // 1 = Admin
			System.out.println("\n" + Icons.CHECK + " Connexion réussie en tant qu'ADMIN !");
			MenuAdmin.afficher(sc, conn);
			return new String[] { "admin", login };
		} else {
			System.out.println("\n" + Icons.CHECK + " Connexion réussie en tant que CLIENT !");
			MenuClient.afficher(true, sc);
			return new String[] { "client", login };
		}
	}
}
