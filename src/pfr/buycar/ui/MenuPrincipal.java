package pfr.buycar.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import pfr.buycar.ui.admin.MenuAdmin;
import pfr.buycar.ui.auth.MenuConnexion;
import pfr.buycar.ui.client.MenuClient;
import pfr.buycar.utils.DBConnection;
import pfr.buycar.utils.Icons;

public class MenuPrincipal extends AbstractMenu {

	private boolean estConnecte = false;
	private boolean estAdmin = false;
	private final Connection connection;

	public MenuPrincipal(Scanner scanner, Connection connection) {
		super(scanner, "MENU PRINCIPAL");
		this.connection = connection;
	}

	public static void demarrer() {
		Scanner sc = new Scanner(System.in);
		Connection connection = null;
		
		try {
			connection = DBConnection.getConnection();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à la BDD : " + e.getMessage());
			return;
		}

		MenuPrincipal menuPrincipal = new MenuPrincipal(sc, connection);
		menuPrincipal.afficher(true);
		
		sc.close();
		DBConnection.closeConnection();
	}

	public boolean afficher(boolean boucle) {
		boolean continuer = true;

		while (continuer && boucle) {
			afficherTitre();
			afficherOptions();
			int choix = lireChoix();
			continuer = traiterChoix(choix);
		}

		return continuer;
	}

	@Override
	protected void afficherOptions() {
		if (!estConnecte) {
			System.out.println("1️⃣  Se connecter");
		} else {
			System.out.println("1️⃣  Se déconnecter");
		}
		System.out.println("2️⃣  Voir les voitures");
		System.out.println("0️⃣  Quitter");
	}

	@Override
	protected boolean traiterChoix(int choix) {
		switch (choix) {
		case 1:
			if (!estConnecte) {
				connecter();
			} else {
				deconnecter();
			}
			return true;
		case 2:
			MenuClient menuClient = new MenuClient(scanner, estConnecte);
			menuClient.afficher();
			return true;
		case 0:
			System.out.println(Icons.CHECK + " Au revoir !");
			return false;
		default:
			afficherChoixInvalide();
			return true;
		}
	}

	private void connecter() {
		MenuConnexion menuConnexion = MenuConnexion.getInstance(scanner, connection);
		boolean connexionReussie = menuConnexion.afficher();

		if (connexionReussie) {
			String[] resultat = menuConnexion.getResultatConnexion();
			estConnecte = true;
			estAdmin = "admin".equalsIgnoreCase(resultat[0]);

			if (estAdmin) {
				// Quand on revient du menu admin
				MenuAdmin menuAdmin = new MenuAdmin(scanner, connection);
				boolean resteConnecte = menuAdmin.afficher();
				if (!resteConnecte) {
					estConnecte = false;
					estAdmin = false;
				}
			} else {
				// Quand on revient du menu client
				MenuClient menuClient = new MenuClient(scanner, estConnecte);
				boolean resteConnecte = menuClient.afficher();
				if (!resteConnecte) {
					estConnecte = false;
				}
			}
		}
	}

	private void deconnecter() {
		estConnecte = false;
		estAdmin = false;
		System.out.println(Icons.DECONNEXION + " Vous êtes déconnecté.");
		System.out.println("🔁 Retour au menu principal...");
	}
}
