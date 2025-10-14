package pfr.buycar.ui;

import java.util.Scanner;
import pfr.buycar.utils.Icons;

public class MenuConnexion {

	public static String[] afficher(Scanner sc) {
		System.out.println("\n===== CONNEXION =====");
		System.out.print(Icons.ADMIN + " Nom d'utilisateur : ");
		String login = sc.nextLine().trim();

		System.out.print("🔑 Mot de passe : ");
		String mdp = sc.nextLine().trim();

		if (login.equalsIgnoreCase("admin") && mdp.equals("admin")) {
			System.out.println("\n" + Icons.CHECK + " Connexion réussie en tant qu'ADMIN !");
			MenuAdmin.afficher(sc);
			return new String[] { "admin", login };
		} else if (login.equalsIgnoreCase("client") && mdp.equals("client")) {
			System.out.println("\n" + Icons.CHECK + " Connexion réussie en tant que CLIENT !");
			MenuClient.afficher(true, sc);
			return new String[] { "client", login };
		} else {
			System.out.println("\n" + Icons.ATTENTION + " Identifiants invalides, retour au menu principal.");
			return null;
		}
	}
}
