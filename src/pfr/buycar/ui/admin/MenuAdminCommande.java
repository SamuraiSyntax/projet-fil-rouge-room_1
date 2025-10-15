package pfr.buycar.ui.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static pfr.buycar.utils.InputUtils.lireEntier;
import pfr.buycar.utils.Icons;

public class MenuAdminCommande {

	private static final List<String> commandes = new ArrayList<>();

	public static void afficher(Scanner sc) {
		int choix;
		boolean continuer = true;

		while (continuer) {
			System.out.println("\n===== GESTION DES COMMANDES =====");
			System.out.println("1️⃣  Voir toutes les commandes");
			System.out.println("2️⃣  Supprimer une commande");
			System.out.println("0️⃣  Retour");
			System.out.print(Icons.FLECHE + " Votre choix : ");
			choix = lireEntier(sc);

			switch (choix) {
			case 1 -> lister();
			case 2 -> supprimer(sc);
			case 0 -> continuer = false;
			default -> System.out.println(Icons.ATTENTION + " Choix invalide !");
			}
		}
	}

	private static void lister() {
		if (commandes.isEmpty()) {
			System.out.println(Icons.ATTENTION + " Aucune commande enregistrée.");
			return;
		}
		System.out.println("📦 Liste des commandes :");
		for (int i = 0; i < commandes.size(); i++) {
			System.out.println((i + 1) + ". " + commandes.get(i));
		}
	}

	private static void supprimer(Scanner sc) {
		lister();
		if (commandes.isEmpty())
			return;
		System.out.print("Numéro de la commande à supprimer : ");
		int index = lireEntier(sc) - 1;
		if (index >= 0 && index < commandes.size()) {
			String supprime = commandes.remove(index);
			System.out.println(Icons.DELETE + " Commande supprimée : " + supprime);
		} else {
			System.out.println(Icons.ATTENTION + " Numéro invalide !");
		}
	}
}
