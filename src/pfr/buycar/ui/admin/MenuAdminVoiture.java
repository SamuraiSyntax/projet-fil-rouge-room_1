package pfr.buycar.ui.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pfr.buycar.utils.Icons;

public class MenuAdminVoiture extends AbstractAdminMenu {

	private static final List<String> voitures = new ArrayList<>();
	
	public MenuAdminVoiture(Scanner scanner) {
		super(scanner, "GESTION DES VOITURES");
	}
	
	public static MenuAdminVoiture getInstance(Scanner scanner) {
		return new MenuAdminVoiture(scanner);
	}

	@Override
	protected void afficherOptions() {
		System.out.println("1️⃣  Ajouter une voiture");
		System.out.println("2️⃣  Lister les voitures");
		System.out.println("3️⃣  Modifier une voiture");
		System.out.println("4️⃣  Supprimer une voiture");
		System.out.println("0️⃣  Retour");
	}
	
	@Override
	protected boolean traiterChoix(int choix) {
		switch (choix) {
		case 1 -> ajouter();
		case 2 -> lister();
		case 3 -> modifier();
		case 4 -> supprimer();
		case 0 -> { return false; }
		default -> afficherChoixInvalide();
		}
		return true;
	}

	private void ajouter() {
		System.out.print("🚘 Nom du modèle : ");
		String voiture = scanner.nextLine().trim();
		voitures.add(voiture);
		System.out.println(Icons.CHECK + " Voiture ajoutée : " + voiture);
	}

	private void lister() {
		afficherListe(voitures, "Aucune voiture enregistrée.", "🚗 Liste des voitures :");
	}

	private void modifier() {
		modifierElement(voitures, "Aucune voiture enregistrée.", 
				"🚗 Liste des voitures :", 
				"Numéro de la voiture à modifier : ", 
				"Nouveau modèle : ");
	}

	private void supprimer() {
		supprimerElement(voitures, "Aucune voiture enregistrée.", 
				"🚗 Liste des voitures :", 
				"Numéro de la voiture à supprimer : ");
	}
}
