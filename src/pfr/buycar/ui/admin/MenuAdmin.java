package pfr.buycar.ui.admin;

import java.sql.Connection;
import java.util.Scanner;

import pfr.buycar.dao.UtilisateurDao;
import pfr.buycar.dao.VoitureDao;
import pfr.buycar.ui.AbstractMenu;
import pfr.buycar.utils.Icons;

public class MenuAdmin extends AbstractMenu {

	private final Connection connection;
	private final UtilisateurDao userDao;
	private final VoitureDao voitureDao;

	public MenuAdmin(Scanner scanner, Connection connection) {
		super(scanner, "MENU ADMIN");
		this.connection = connection;
		this.userDao = new UtilisateurDao(connection);
		this.voitureDao = new VoitureDao(connection);
	}
	
	public static MenuAdmin getInstance(Scanner scanner, Connection connection) {
		return new MenuAdmin(scanner, connection);
	}

	@Override
	protected void afficherOptions() {
		System.out.println("1️⃣  Gérer les utilisateurs");
		System.out.println("2️⃣  Gérer les voitures");
		System.out.println("3️⃣  Gérer les commandes");
		System.out.println("0️⃣  Déconnexion");
	}

	@Override
	protected boolean traiterChoix(int choix) {
		switch (choix) {
		case 1 -> MenuAdminUtilisateur.getInstance(scanner).afficher();
		case 2 -> MenuAdminVoiture.getInstance(scanner).afficher();
		case 3 -> MenuAdminCommande.getInstance(scanner).afficher();
		case 0 -> {
			System.out.println(Icons.DECONNEXION + " Déconnexion...");
			return false; // Retourne false pour indiquer la déconnexion
		}
		default -> afficherChoixInvalide();
		}
		return true;
	}
}
