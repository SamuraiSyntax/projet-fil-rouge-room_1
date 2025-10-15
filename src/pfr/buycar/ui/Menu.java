package pfr.buycar.ui;

/**
 * Interface définissant le comportement commun à tous les menus de l'application.
 */
public interface Menu {
    
    /**
     * Affiche le menu et gère les interactions avec l'utilisateur.
     * @return boolean indiquant si l'utilisateur reste connecté (true) ou se déconnecte (false)
     */
    boolean afficher();
}