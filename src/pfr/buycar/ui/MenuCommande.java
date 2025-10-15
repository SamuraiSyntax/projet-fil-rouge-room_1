package pfr.buycar.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pfr.buycar.Panier;
import static pfr.buycar.utils.InputUtils.lireEntier;
import pfr.buycar.utils.Icons;

public class MenuCommande {

	private static final List<String> commandes = new ArrayList<>();

	public static void afficher(Scanner sc) {
		int choix;
		do {
			System.out.println("\n===== MENU COMMANDES =====");
			System.out.println("1️⃣  Voir mes commandes");
			System.out.println("2️⃣  Passer une nouvelle commande");
			System.out.println("0️⃣  Retour");
			System.out.print(Icons.FLECHE + " Votre choix : ");

			choix = lireEntier(sc);

			switch (choix) {
			case 1 -> afficherCommandes();
			case 2 -> passerCommande();
			case 0 -> System.out.println(Icons.RETOUR + " Retour au menu précédent...");
			default -> System.out.println(Icons.ATTENTION + " Choix invalide.");
			}
		} while (choix != 0);
	}

	private static void afficherCommandes() {
		if (commandes.isEmpty()) {
			System.out.println(Icons.ATTENTION + " Vous n'avez aucune commande.");
			return;
		}

		System.out.println("📦 Liste des commandes passées :");
		for (int i = 0; i < commandes.size(); i++) {
			System.out.println((i + 1) + ". " + commandes.get(i));
		}
	}

	private static void passerCommande() {
		Panier panier = MenuPanier.getPanier();
		if (panier.estVide()) {
			System.out.println(Icons.ATTENTION + " Votre panier est vide !");
			return;
		}

		StringBuilder commande = new StringBuilder("Commande: ");
		List<String> panierItems = panier.getArticles();
		for (String item : panierItems) {
			commande.append(item).append(", ");
		}

		commandes.add(commande.toString().replaceAll(", $", ""));
		System.out.println(Icons.CHECK + " Commande validée !");
		panier.viderPanier();
	}
}
