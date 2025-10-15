package pfr.buycar.ui;

import java.util.Scanner;
import static pfr.buycar.utils.InputUtils.lireEntier;
import pfr.buycar.utils.Icons;

public class MenuClient {

	public static void afficher(boolean connecte, Scanner sc) {
		int choix;
		boolean continuer = true;

		while (continuer) {
			System.out.println("\n===== MENU CLIENT =====");
			System.out.println("1️⃣  Voir les voitures");
			System.out.println("2️⃣  Filtrer / Rechercher");
			if (connecte) {
				System.out.println("3️⃣  Gérer mon panier");
				System.out.println("4️⃣  Passer commande");
				System.out.println("0️⃣  Se déconnecter / Retour");
			} else {
				System.out.println("0️⃣  Retour");
			}
			System.out.print(Icons.FLECHE + " Votre choix : ");

			choix = lireEntier(sc);

			switch (choix) {
			case 1 -> System.out.println(Icons.VOITURE + " Liste des voitures disponibles...");
			case 2 -> System.out.println("🔍 Recherche / Filtrage (à venir)");
			case 3 -> {
				if (connecte)
					MenuPanier.afficher(sc);
				else
					System.out.println(Icons.ATTENTION + " Réservé aux utilisateurs connectés !");
			}
			case 4 -> {
				if (connecte)
					MenuCommande.afficher(sc);
				else
					System.out.println(Icons.ATTENTION + " Connectez-vous pour commander !");
			}
			case 0 -> {
				System.out.println(
						connecte ? Icons.DECONNEXION + " Déconnexion..." : Icons.RETOUR + " Retour au menu précédent");
				continuer = false;
			}
			default -> System.out.println(Icons.ATTENTION + " Choix invalide.");
			}
		}
	}
}
