package pfr.buycar.ui.admin;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pfr.buycar.dao.UtilisateurDao;
import pfr.buycar.models.Client;
import pfr.buycar.utils.Icons;

public class MenuAdminUtilisateur extends AbstractAdminMenu {

	private static final List<String> utilisateurs = new ArrayList<>();
	private final Connection connection;

	public MenuAdminUtilisateur(Scanner scanner, Connection connection) {
		super(scanner, "GESTION DES UTILISATEURS");
		this.connection = connection;
	}

	public static MenuAdminUtilisateur getInstance(Scanner scanner, Connection connection) {
		return new MenuAdminUtilisateur(scanner, connection);
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
		case 0 -> {
			return false;
		}
		default -> afficherChoixInvalide();
		}
		return true;
	}

	private void ajouter() {
		UtilisateurDao userTest = new UtilisateurDao(connection);
		System.out.print("👤 Nom du nouvel utilisateur : ");
		String nom = scanner.nextLine().trim();
		System.out.print("👤 Prenom du nouvel utilisateur : ");
		String prenom = scanner.nextLine().trim();
		System.out.print("👤 Nom de Compte du nouvel utilisateur : ");
		String nom_compte = scanner.nextLine().trim();
		System.out.print("👤 Mot de passe du nouvel utilisateur : ");
		String mdp = scanner.nextLine().trim();
		System.out.print("👤 Email du nouvel utilisateur : ");
		String email = scanner.nextLine().trim();
		userTest.create(new Client(nom, prenom, nom_compte, mdp, 2, email));

//		UtilisateurDao userTest = new UtilisateurDao(conn);
//		userTest.create(new Client("Henry", "Jean", "hjean", "14455", 2, "hjean@exemple.com"));
//
		utilisateurs.add(nom);
		System.out.println(Icons.CHECK + " Utilisateur ajouté : " + nom);
	}

	private void lister() {
		UtilisateurDao user = new UtilisateurDao(connection);
		List<Client> clients = user.getAll();
		for (Client u : clients) {
		    utilisateurs.add(u.toString());
		}	
		afficherListe(utilisateurs, "Aucun utilisateur enregistré.", "👥 Liste des utilisateurs :");
	}

	private void modifier() {
		modifierElement(utilisateurs, "Aucun utilisateur enregistré.", "👥 Liste des utilisateurs :",
				"Numéro de l'utilisateur à modifier : ", "Nouveau nom : ");
	}

	private void supprimer() {
		supprimerElement(utilisateurs, "Aucun utilisateur enregistré.", "👥 Liste des utilisateurs :",
				"Numéro de l'utilisateur à supprimer : ");
	}
}
