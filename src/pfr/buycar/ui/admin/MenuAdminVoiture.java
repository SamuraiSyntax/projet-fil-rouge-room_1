package pfr.buycar.ui.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static pfr.buycar.utils.InputUtils.lireEntier;
import pfr.buycar.utils.Icons;

public class MenuAdminVoiture {

	private static final List<String> voitures = new ArrayList<>();

	public static void afficher(Scanner sc) {
		int choix;
		boolean continuer = true;

		while (continuer) {
			System.out.println("\n===== GESTION DES VOITURES =====");
			System.out.println("1️⃣  Ajouter une voiture");
			System.out.println("2️⃣  Lister les voitures");
			System.out.println("3️⃣  Modifier une voiture");
			System.out.println("4️⃣  Supprimer une voiture");
			System.out.println("0️⃣  Retour");
			System.out.print(Icons.FLECHE + " Votre choix : ");
			choix = lireEntier(sc);

			switch (choix) {
			case 1 -> ajouter(sc);
			case 2 -> lister();
			case 3 -> modifier(sc);
			case 4 -> supprimer(sc);
			case 0 -> continuer = false;
			default -> System.out.println(Icons.ATTENTION + " Choix invalide !");
			}
		}
	}

	private static void ajouter(Scanner sc) {
		System.out.print("🚘 Nom du modèle : ");
		String voiture = sc.nextLine().trim();
		voitures.add(voiture);
		System.out.println(Icons.CHECK + " Voiture ajoutée : " + voiture);
	}

	private static void lister() {
		if (voitures.isEmpty()) {
			System.out.println(Icons.ATTENTION + " Aucune voiture enregistrée.");
			return;
		}
		System.out.println("🚗 Liste des voitures :");
		for (int i = 0; i < voitures.size(); i++) {
			System.out.println((i + 1) + ". " + voitures.get(i));
		}
	}

	private static void modifier(Scanner sc) {
		lister();
		if (voitures.isEmpty())
			return;
		System.out.print("Numéro de la voiture à modifier : ");
		int index = lireEntier(sc) - 1;
		if (index >= 0 && index < voitures.size()) {
			System.out.print("Nouveau modèle : ");
			String nouveau = sc.nextLine().trim();
			voitures.set(index, nouveau);
			System.out.println(Icons.CHECK + " Voiture mise à jour !");
		} else {
			System.out.println(Icons.ATTENTION + " Numéro invalide !");
		}
	}

	private static void supprimer(Scanner sc) {
		lister();
		if (voitures.isEmpty())
			return;
		System.out.print("Numéro de la voiture à supprimer : ");
		int index = lireEntier(sc) - 1;
		if (index >= 0 && index < voitures.size()) {
			String supprime = voitures.remove(index);
			System.out.println(Icons.DELETE + " Voiture supprimée : " + supprime);
		} else {
			System.out.println(Icons.ATTENTION + " Numéro invalide !");
		}
	}
}
