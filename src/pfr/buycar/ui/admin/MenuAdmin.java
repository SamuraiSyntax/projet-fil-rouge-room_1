package pfr.buycar.ui.admin;

import static pfr.buycar.utils.InputUtils.lireEntier;

import java.sql.Connection;
import java.util.Scanner;

import pfr.buycar.dao.UtilisateurDao;
import pfr.buycar.dao.VoitureDao;
import pfr.buycar.utils.Icons;

public class MenuAdmin {

	public static void afficher(Scanner sc, Connection conn) {
	    UtilisateurDao userDao = new UtilisateurDao(conn);
	    VoitureDao voitureDao = new VoitureDao(conn);
		int choix;
		boolean continuer = true;

		while (continuer) {
			System.out.println("\n===== MENU ADMIN =====");
			System.out.println("1️⃣  Gérer les utilisateurs");
			System.out.println("2️⃣  Gérer les voitures");
			System.out.println("3️⃣  Gérer les commandes");
			System.out.println("0️⃣  Déconnexion");
			System.out.print(Icons.FLECHE + " Votre choix : ");

			choix = lireEntier(sc);

			switch (choix) {
			case 1 -> MenuAdminUtilisateur.afficher(sc);
			case 2 -> MenuAdminVoiture.afficher(sc);
			case 3 -> MenuAdminCommande.afficher(sc);
			case 0 -> {
				System.out.println(Icons.DECONNEXION + " Déconnexion...");
				continuer = false;
			}
			default -> System.out.println(Icons.ATTENTION + " Choix invalide.");
			}
		}
	}
}
