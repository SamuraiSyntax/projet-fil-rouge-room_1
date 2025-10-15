package pfr.buycar.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import pfr.buycar.utils.DBConnection;
import pfr.buycar.utils.Icons;

public class MenuPrincipal {

    private static final Scanner SC = new Scanner(System.in);
    private static boolean estConnecte = false;
    private static boolean estAdmin = false;
    private static Connection connection;

    public static void afficher() {
        try {
            connection = DBConnection.getConnection(); // Connexion à la BDD
        } catch (SQLException e) {
            System.err.println("Impossible de se connecter à la BDD : " + e.getMessage());
            return;
        }

        int choix = -1;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            if (!estConnecte) {
                System.out.println("1️.  Se connecter");
            } else {
                System.out.println("1️.  Se déconnecter");
            }
            System.out.println("2️.  Voir les voitures");
            System.out.println("0️.  Quitter");
            System.out.print(Icons.FLECHE + " Votre choix : ");

            choix = pfr.buycar.utils.InputUtils.lireEntier(SC);

            switch (choix) {
                case 1 -> {
                    if (!estConnecte) {
                        connecter();
                    } else {
                        deconnecter();
                    }
                }
                case 2 -> MenuClient.afficher(estConnecte, SC);
                case 0 -> {
                    System.out.println(Icons.CHECK + " Au revoir !");
                    DBConnection.closeConnection();
                }
                default -> System.out.println(Icons.ATTENTION + " Choix invalide, veuillez réessayer.");
            }

        } while (choix != 0);
    }

    private static void connecter() {
        String[] resultat = MenuConnexion.afficher(SC, connection);
        if (resultat != null) {
            estConnecte = true;
            estAdmin = "admin".equalsIgnoreCase(resultat[0]);
        }
    }

    private static void deconnecter() {
        estConnecte = false;
        estAdmin = false;
        System.out.println(Icons.DECONNEXION + " Vous êtes déconnecté.");
    }
}
