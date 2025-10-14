package pfr.buycar.ui;

import static pfr.buycar.utils.InputUtils.lireEntier;

import java.util.Scanner;

import pfr.buycar.utils.Icons;

public class MenuPrincipal {

	private static final Scanner SC = new Scanner(System.in);
	private static boolean estConnecte = false;
	private static boolean estAdmin = false;

	public static void afficher() {
		int choix = -1;

		do {
			System.out.println("\n===== MENU PRINCIPAL =====");
			if (!estConnecte) {
				System.out.println("1️⃣  Se connecter");
			} else {
				System.out.println("1️⃣  Se déconnecter");
			}
			System.out.println("2️⃣  Voir les voitures");
			System.out.println("0️⃣  Quitter");
			System.out.print(Icons.FLECHE + " Votre choix : ");

			choix = lireEntier(SC);

			switch (choix) {
			case 1 -> {
				if (!estConnecte) {
					connecter();
				} else {
					deconnecter();
				}
			}
			case 2 -> MenuClient.afficher(estConnecte, SC);
			case 0 -> System.out.println(Icons.CHECK + " Au revoir !");
			default -> System.out.println(Icons.ATTENTION + " Choix invalide, veuillez réessayer.");
			}

		} while (choix != 0);
	}

	private static void connecter() {
		MenuConnexion.afficher(SC);
		estConnecte = true; 
		estAdmin = false; 
	}

	private static void deconnecter() {
		estConnecte = false;
		estAdmin = false;
		System.out.println(Icons.DECONNEXION + " Vous êtes déconnecté.");
	}
}
