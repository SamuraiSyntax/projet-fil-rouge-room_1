package pfr.buycar.ui;

import java.util.Scanner;
import pfr.buycar.utils.Icons;
import static pfr.buycar.utils.InputUtils.lireEntier;

/**
 * Classe abstraite implémentant les fonctionnalités communes à tous les menus.
 */
public abstract class AbstractMenu implements Menu {
    
    protected final Scanner scanner;
    protected final String titre;
    
    /**
     * Constructeur avec scanner et titre du menu
     * @param scanner Scanner pour la saisie utilisateur
     * @param titre Titre du menu
     */
    public AbstractMenu(Scanner scanner, String titre) {
        this.scanner = scanner;
        this.titre = titre;
    }
    
    /**
     * Affiche le titre du menu
     */
    protected void afficherTitre() {
        System.out.println("\n===== " + titre + " =====");
    }
    
    /**
     * Affiche un message d'erreur pour un choix invalide
     */
    protected void afficherChoixInvalide() {
        System.out.println(Icons.ATTENTION + " Choix invalide !");
    }
    
    /**
     * Lit un choix entier depuis le scanner
     * @return le choix saisi par l'utilisateur
     */
    protected int lireChoix() {
        System.out.print(Icons.FLECHE + " Votre choix : ");
        return lireEntier(scanner);
    }
    
    /**
     * Affiche un message de retour au menu précédent
     */
    protected void afficherRetour() {
        System.out.println(Icons.RETOUR + " Retour au menu précédent...");
    }
    
    /**
     * Méthode abstraite pour traiter les choix du menu
     * @param choix le choix de l'utilisateur
     * @return true si on reste dans le menu, false sinon
     */
    protected abstract boolean traiterChoix(int choix);
    
    /**
     * Méthode abstraite pour afficher les options du menu
     */
    protected abstract void afficherOptions();
    
    @Override
    public boolean afficher() {
        boolean continuer = true;
        
        while (continuer) {
            afficherTitre();
            afficherOptions();
            int choix = lireChoix();
            continuer = traiterChoix(choix);
        }
        
        return continuer;
    }
}