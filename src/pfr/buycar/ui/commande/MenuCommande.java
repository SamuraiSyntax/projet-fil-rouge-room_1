package pfr.buycar.ui.commande;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pfr.buycar.Panier;
import pfr.buycar.ui.AbstractMenu;
import pfr.buycar.ui.panier.MenuPanier;
import pfr.buycar.utils.Icons;

public class MenuCommande extends AbstractMenu {

	private static final List<String> commandes = new ArrayList<>();
	
	public MenuCommande(Scanner scanner) {
		super(scanner, "MENU COMMANDES");
	}
	
	public static MenuCommande getInstance(Scanner scanner) {
		return new MenuCommande(scanner);
	}

	@Override
	protected void afficherOptions() {
		System.out.println("1️⃣  Voir mes commandes");
		System.out.println("2️⃣  Passer une nouvelle commande");
		System.out.println("0️⃣  Retour");
	}
	
	@Override
	protected boolean traiterChoix(int choix) {
		switch (choix) {
		case 1 -> afficherCommandes();
		case 2 -> passerCommande();
		case 0 -> {
			afficherRetour();
			return false;
		}
		default -> afficherChoixInvalide();
		}
		return true;
	}

	private void afficherCommandes() {
		if (commandes.isEmpty()) {
			System.out.println(Icons.ATTENTION + " Vous n'avez aucune commande.");
			return;
		}

		System.out.println("📦 Liste des commandes passées :");
		for (int i = 0; i < commandes.size(); i++) {
			System.out.println((i + 1) + ". " + commandes.get(i));
		}
	}

	private void passerCommande() {
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
