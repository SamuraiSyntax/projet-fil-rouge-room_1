package pfr.buycar.ui;

import java.util.Scanner;
import static pfr.buycar.utils.InputUtils.lireEntier;
import pfr.buycar.utils.Icons;

public class MenuAdmin {

	public static void afficher(Scanner sc) {
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
			case 1 -> System.out.println("👥 Gestion des utilisateurs (à venir)");
			case 2 -> System.out.println("🚗 Gestion des voitures (à venir)");
			case 3 -> System.out.println("📦 Gestion des commandes (à venir)");
			case 0 -> {
				System.out.println(Icons.DECONNEXION + " Déconnexion...");
				continuer = false; // Sort de la boucle pour revenir au menu principal
			}
			default -> System.out.println(Icons.ATTENTION + " Choix invalide.");
			}
		}
	}
}
