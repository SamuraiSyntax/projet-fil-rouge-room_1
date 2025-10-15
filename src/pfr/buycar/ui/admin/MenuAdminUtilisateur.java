package pfr.buycar.ui.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static pfr.buycar.utils.InputUtils.lireEntier;
import pfr.buycar.utils.Icons;

public class MenuAdminUtilisateur {

	private static final List<String> utilisateurs = new ArrayList<>();

	public static void afficher(Scanner sc) {
		int choix;
		boolean continuer = true;

		while (continuer) {
			System.out.println("\n===== GESTION DES UTILISATEURS =====");
			System.out.println("1️⃣  Ajouter un utilisateur");
			System.out.println("2️⃣  Lister les utilisateurs");
			System.out.println("3️⃣  Modifier un utilisateur");
			System.out.println("4️⃣  Supprimer un utilisateur");
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
		System.out.print("👤 Nom du nouvel utilisateur : ");
		String nom = sc.nextLine().trim();
		utilisateurs.add(nom);
		System.out.println(Icons.CHECK + " Utilisateur ajouté : " + nom);
	}

	private static void lister() {
		if (utilisateurs.isEmpty()) {
			System.out.println(Icons.ATTENTION + " Aucun utilisateur enregistré.");
			return;
		}
		System.out.println("👥 Liste des utilisateurs :");
		for (int i = 0; i < utilisateurs.size(); i++) {
			System.out.println((i + 1) + ". " + utilisateurs.get(i));
		}
	}

	private static void modifier(Scanner sc) {
		lister();
		if (utilisateurs.isEmpty())
			return;
		System.out.print("Numéro de l’utilisateur à modifier : ");
		int index = lireEntier(sc) - 1;
		if (index >= 0 && index < utilisateurs.size()) {
			System.out.print("Nouveau nom : ");
			String nouveauNom = sc.nextLine().trim();
			utilisateurs.set(index, nouveauNom);
			System.out.println(Icons.CHECK + " Utilisateur mis à jour !");
		} else {
			System.out.println(Icons.ATTENTION + " Numéro invalide !");
		}
	}

	private static void supprimer(Scanner sc) {
		lister();
		if (utilisateurs.isEmpty())
			return;
		System.out.print("Numéro de l’utilisateur à supprimer : ");
		int index = lireEntier(sc) - 1;
		if (index >= 0 && index < utilisateurs.size()) {
			String supprime = utilisateurs.remove(index);
			System.out.println(Icons.DELETE + " Utilisateur supprimé : " + supprime);
		} else {
			System.out.println(Icons.ATTENTION + " Numéro invalide !");
		}
	}
}
