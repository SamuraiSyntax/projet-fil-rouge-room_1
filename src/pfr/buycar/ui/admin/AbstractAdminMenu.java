package pfr.buycar.ui.admin;

import java.util.List;
import java.util.Scanner;
import pfr.buycar.ui.AbstractMenu;
import pfr.buycar.utils.Icons;

/**
 * Classe abstraite pour les menus d'administration avec fonctionnalités CRUD
 */
public abstract class AbstractAdminMenu extends AbstractMenu {
    
    /**
     * Constructeur avec scanner et titre du menu
     * @param scanner Scanner pour la saisie utilisateur
     * @param titre Titre du menu
     */
    public AbstractAdminMenu(Scanner scanner, String titre) {
        super(scanner, titre);
    }
    
    /**
     * Affiche la liste des éléments
     * @param elements Liste des éléments à afficher
     * @param messageVide Message à afficher si la liste est vide
     * @param titreListage Titre de la liste
     */
    protected void afficherListe(List<String> elements, String messageVide, String titreListage) {
        if (elements.isEmpty()) {
            System.out.println(Icons.ATTENTION + " " + messageVide);
            return;
        }
        System.out.println(titreListage);
        for (int i = 0; i < elements.size(); i++) {
            System.out.println((i + 1) + ". " + elements.get(i));
        }
    }
    
    /**
     * Supprime un élément de la liste
     * @param elements Liste des éléments
     * @param messageVide Message si la liste est vide
     * @param titreListage Titre de la liste
     * @param messagePrompt Message pour demander l'élément à supprimer
     */
    protected void supprimerElement(List<String> elements, String messageVide, 
                                   String titreListage, String messagePrompt) {
        afficherListe(elements, messageVide, titreListage);
        if (elements.isEmpty())
            return;
        System.out.print(messagePrompt);
        int index = pfr.buycar.utils.InputUtils.lireEntier(scanner) - 1;
        if (index >= 0 && index < elements.size()) {
            String supprime = elements.remove(index);
            System.out.println(Icons.DELETE + " Élément supprimé : " + supprime);
        } else {
            System.out.println(Icons.ATTENTION + " Numéro invalide !");
        }
    }
    
    /**
     * Modifie un élément de la liste
     * @param elements Liste des éléments
     * @param messageVide Message si la liste est vide
     * @param titreListage Titre de la liste
     * @param messagePrompt Message pour demander l'élément à modifier
     * @param messageNouvelleValeur Message pour demander la nouvelle valeur
     */
    protected void modifierElement(List<String> elements, String messageVide, 
                                  String titreListage, String messagePrompt, 
                                  String messageNouvelleValeur) {
        afficherListe(elements, messageVide, titreListage);
        if (elements.isEmpty())
            return;
        System.out.print(messagePrompt);
        int index = pfr.buycar.utils.InputUtils.lireEntier(scanner) - 1;
        if (index >= 0 && index < elements.size()) {
            System.out.print(messageNouvelleValeur);
            String nouveau = scanner.nextLine().trim();
            elements.set(index, nouveau);
            System.out.println(Icons.CHECK + " Élément mis à jour !");
        } else {
            System.out.println(Icons.ATTENTION + " Numéro invalide !");
        }
    }
}