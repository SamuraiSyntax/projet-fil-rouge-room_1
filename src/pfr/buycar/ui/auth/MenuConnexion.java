package pfr.buycar.ui.auth;

import java.sql.Connection;
import java.util.Scanner;

import pfr.buycar.dao.UtilisateurDao;
import pfr.buycar.dao.UtilisateurMock;
import pfr.buycar.ui.AbstractMenu;
import pfr.buycar.utils.Icons;

public class MenuConnexion extends AbstractMenu {
	
	private final Connection connection;
	private String[] resultatConnexion = null;
	
	public MenuConnexion(Scanner scanner, Connection connection) {
		super(scanner, "CONNEXION");
		this.connection = connection;
	}
	
	public static MenuConnexion getInstance(Scanner scanner, Connection connection) {
		return new MenuConnexion(scanner, connection);
	}
	
	@Override
	protected void afficherOptions() {
		// Pas de menu à afficher, la connexion se fait directement
	}
	
	@Override
	protected boolean traiterChoix(int choix) {
		// Cette méthode n'est pas utilisée dans ce menu
		return false;
	}
	
	@Override
	public boolean afficher() {
		afficherTitre();
		
		System.out.print(Icons.ADMIN + " Nom d'utilisateur : ");
		String login = scanner.nextLine().trim();

		System.out.print("🔑 Mot de passe : ");
		String mdp = scanner.nextLine().trim();

		UtilisateurDao userDao = new UtilisateurDao(connection);
		UtilisateurMock user = userDao.findByLogin(login);

		if (user == null) {
			System.out.println("\n" + Icons.ATTENTION + " Utilisateur inexistant !");
			return false;
		}

		if (!user.getpassword().equals(mdp)) {
			System.out.println("\n" + Icons.ATTENTION + " Mot de passe incorrect !");
			return false;
		}

		// Connexion réussie
		if (user.getRole() == 1) {
			System.out.println("\n" + Icons.CHECK + " Connexion réussie en tant qu'ADMIN !");
			resultatConnexion = new String[] { "admin", login };
		} else {
			System.out.println("\n" + Icons.CHECK + " Connexion réussie en tant que CLIENT !");
			resultatConnexion = new String[] { "client", login };
		}
		
		return true;
	}
	
	public String[] getResultatConnexion() {
		return resultatConnexion;
	}
}
