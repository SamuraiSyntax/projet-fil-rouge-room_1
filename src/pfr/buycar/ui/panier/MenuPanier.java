package pfr.buycar.ui.panier;

import java.util.Scanner;
import pfr.buycar.Panier;
import pfr.buycar.ui.AbstractMenu;
import pfr.buycar.utils.Icons;

public class MenuPanier extends AbstractMenu {

	private static final Panier PANIER = new Panier();
	
	public MenuPanier(Scanner scanner) {
		super(scanner, "MENU PANIER");
	}
	
	public static MenuPanier getInstance(Scanner scanner) {
		return new MenuPanier(scanner);
	}

	@Override
	protected void afficherOptions() {
		System.out.println("1️⃣  Voir le panier");
		System.out.println("2️⃣  Ajouter une voiture");
		System.out.println("3️⃣  Vider le panier");
		System.out.println("4️⃣  Valider la commande");
		System.out.println("0️⃣  Retour");
	}
	
	@Override
	protected boolean traiterChoix(int choix) {
		switch (choix) {
		case 1 -> PANIER.afficherPanier();
		case 2 -> {
			System.out.print("Nom de la voiture à ajouter : ");
			String voiture = scanner.nextLine().trim();
			PANIER.ajouterArticle(voiture);
		}
		case 3 -> PANIER.viderPanier();
		case 4 -> validerCommande();
		case 0 -> {
			afficherRetour();
			return false;
		}
		default -> afficherChoixInvalide();
		}
		return true;
	}

	private void validerCommande() {
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
