package pfr.buycar.ui.client;

import java.util.Scanner;

import pfr.buycar.ui.AbstractMenu;
import pfr.buycar.ui.commande.MenuCommande;
import pfr.buycar.ui.panier.MenuPanier;
import pfr.buycar.utils.Icons;

public class MenuClient extends AbstractMenu {
	
	private final boolean connecte;
	
	public MenuClient(Scanner scanner, boolean connecte) {
		super(scanner, "MENU CLIENT");
		this.connecte = connecte;
	}
	
	public static MenuClient getInstance(Scanner scanner, boolean connecte) {
		return new MenuClient(scanner, connecte);
	}

	@Override
	protected void afficherOptions() {
		System.out.println("1️⃣  Voir les voitures");
		System.out.println("2️⃣  Filtrer / Rechercher");
		if (connecte) {
			System.out.println("3️⃣  Gérer mon panier");
			System.out.println("4️⃣  Passer commande");
			System.out.println("0️⃣  Se déconnecter / Retour");
		} else {
			System.out.println("0️⃣  Retour");
		}
	}

	@Override
	protected boolean traiterChoix(int choix) {
		switch (choix) {
		case 1 -> System.out.println(Icons.VOITURE + " Liste des voitures disponibles...");
		case 2 -> System.out.println("🔍 Recherche / Filtrage (à venir)");
		case 3 -> {
			if (connecte)
				MenuPanier.getInstance(scanner).afficher();
			else
				System.out.println(Icons.ATTENTION + " Réservé aux utilisateurs connectés !");
		}
		case 4 -> {
			if (connecte)
				MenuCommande.getInstance(scanner).afficher();
			else
				System.out.println(Icons.ATTENTION + " Connectez-vous pour commander !");
		}
		case 0 -> {
			System.out.println(
					connecte ? Icons.DECONNEXION + " Déconnexion..." : Icons.RETOUR + " Retour au menu précédent");
			return false;
		}
		default -> afficherChoixInvalide();
		}
		return true;
	}
}
