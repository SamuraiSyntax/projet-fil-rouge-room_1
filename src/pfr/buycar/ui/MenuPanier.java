package pfr.buycar.ui;

import java.util.Scanner;
import pfr.buycar.Panier;
import static pfr.buycar.utils.InputUtils.lireEntier;
import pfr.buycar.utils.Icons;

public class MenuPanier {

	private static final Panier PANIER = new Panier();

	public static void afficher(Scanner sc) {
		int choix;
		do {
			System.out.println("\n===== MENU PANIER =====");
			System.out.println("1️⃣  Voir le panier");
			System.out.println("2️⃣  Ajouter une voiture");
			System.out.println("3️⃣  Vider le panier");
			System.out.println("4️⃣  Valider la commande");
			System.out.println("0️⃣  Retour");
			System.out.print(Icons.FLECHE + " Votre choix : ");

			choix = lireEntier(sc);

			switch (choix) {
			case 1 -> PANIER.afficherPanier();
			case 2 -> {
				System.out.print("Nom de la voiture à ajouter : ");
				String voiture = sc.nextLine().trim();
				PANIER.ajouterArticle(voiture);
			}
			case 3 -> PANIER.viderPanier();
			case 4 -> validerCommande();
			case 0 -> System.out.println(Icons.RETOUR + " Retour au menu précédent...");
			default -> System.out.println(Icons.ATTENTION + " Choix invalide.");
			}
		} while (choix != 0);
	}

	private static void validerCommande() {
		if (PANIER.estVide()) {
			System.out.println(Icons.ATTENTION + " Votre panier est vide !");
			return;
		}

		System.out.println(Icons.CHECK + " Validation de la commande en cours...");
		System.out.println("→ Appel logique Dev 2 (Paiement / Commande)");
		System.out.println(Icons.CHECK + " Commande validée !");
		PANIER.viderPanier();
	}

	public static Panier getPanier() {
		return PANIER;
	}
}
