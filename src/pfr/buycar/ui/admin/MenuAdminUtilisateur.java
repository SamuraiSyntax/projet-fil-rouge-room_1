package pfr.buycar.ui.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pfr.buycar.utils.Icons;

public class MenuAdminUtilisateur extends AbstractAdminMenu {

	private static final List<String> utilisateurs = new ArrayList<>();
	
	public MenuAdminUtilisateur(Scanner scanner) {
		super(scanner, "GESTION DES UTILISATEURS");
	}
	
	public static MenuAdminUtilisateur getInstance(Scanner scanner) {
		return new MenuAdminUtilisateur(scanner);
	}

	@Override
	protected void afficherOptions() {
		System.out.println("1️⃣  Ajouter un utilisateur");
		System.out.println("2️⃣  Lister les utilisateurs");
		System.out.println("3️⃣  Modifier un utilisateur");
		System.out.println("4️⃣  Supprimer un utilisateur");
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
		System.out.print("👤 Nom du nouvel utilisateur : ");
		String nom = scanner.nextLine().trim();
		utilisateurs.add(nom);
		System.out.println(Icons.CHECK + " Utilisateur ajouté : " + nom);
	}

	private void lister() {
		afficherListe(utilisateurs, "Aucun utilisateur enregistré.", "👥 Liste des utilisateurs :");
	}

	private void modifier() {
		modifierElement(utilisateurs, "Aucun utilisateur enregistré.", 
				"👥 Liste des utilisateurs :", 
				"Numéro de l'utilisateur à modifier : ", 
				"Nouveau nom : ");
	}

	private void supprimer() {
		supprimerElement(utilisateurs, "Aucun utilisateur enregistré.", 
				"👥 Liste des utilisateurs :", 
				"Numéro de l'utilisateur à supprimer : ");
	}
}
