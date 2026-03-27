package pfr.buycar.models;

import java.util.Date;

/**
 * Classe représentant une commande dans le projet BuyCar.
 * Modèle simple sans logique métier.
 */
public class Commande {

    private int id_commande;
    private Date date_creation;
    private Date date_modification;
    private Panier panier;
    private StatutCommande statut;
    private Adresse adresseLivraison;
    private Utilisateur utilisateur;

    // --- Constructeurs ---
    public Commande() {}

    public Commande(int id_commande, Date date_creation, Date date_modification,
                    Panier panier, StatutCommande statut,
                    Adresse adresseLivraison, Utilisateur utilisateur) {
        this.id_commande = id_commande;
        this.date_creation = date_creation;
        this.date_modification = date_modification;
        this.panier = panier;
        this.statut = statut;
        this.adresseLivraison = adresseLivraison;
        this.utilisateur = utilisateur;
    }

    // --- Getters / Setters ---
    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_modification() {
        return date_modification;
    }

    public void setDate_modification(Date date_modification) {
        this.date_modification = date_modification;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
    }

    public Adresse getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(Adresse adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // --- toString (facultatif mais utile pour les tests console) ---
    @Override
    public String toString() {
        return "Commande{" +
                "id_commande=" + id_commande +
                ", date_creation=" + date_creation +
                ", date_modification=" + date_modification +
                ", panier=" + panier +
                ", statut=" + statut +
                ", adresseLivraison=" + adresseLivraison +
                ", utilisateur=" + (utilisateur != null ? utilisateur.getNom() : "null") +
                '}';
    }
}

