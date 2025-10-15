package pfr.buycar.ui.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pfr.buycar.utils.Icons;

public class MenuAdminCommande extends AbstractAdminMenu {

	private static final List<String> commandes = new ArrayList<>();
	
	public MenuAdminCommande(Scanner scanner) {
		super(scanner, "GESTION DES COMMANDES");
	}
	
	public static MenuAdminCommande getInstance(Scanner scanner) {
		return new MenuAdminCommande(scanner);
	}

	@Override
	protected void afficherOptions() {
		System.out.println("1️⃣  Voir toutes les commandes");
		System.out.println("2️⃣  Supprimer une commande");
		System.out.println("0️⃣  Retour");
	}
	
	@Override
	protected boolean traiterChoix(int choix) {
		switch (choix) {
		case 1 -> lister();
		case 2 -> supprimer();
		case 0 -> { return false; }
		default -> afficherChoixInvalide();
		}
		return true;
	}

	private void lister() {
		afficherListe(commandes, "Aucune commande enregistrée.", "📦 Liste des commandes :");
	}

	private void supprimer() {
		supprimerElement(commandes, "Aucune commande enregistrée.", 
				"📦 Liste des commandes :", 
				"Numéro de la commande à supprimer : ");
	}
}
