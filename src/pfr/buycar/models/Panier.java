package pfr.buycar.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe représentant un panier d'achat dans le projet BuyCar.
 * Modèle simple sans logique métier.
 */
public class Panier {

    // --- Attributs ---
    private int id_panier;
    private Date date_creation;
    private List<Voiture> voitures;
    private Utilisateur utilisateur;

    // --- Constructeurs ---
    public Panier() {
        this.date_creation = new Date();
        this.voitures = new ArrayList<>();
    }

    public Panier(int id_panier, Date date_creation, List<Voiture> voitures, Utilisateur utilisateur) {
        this.id_panier = id_panier;
        this.date_creation = date_creation;
        this.voitures = voitures != null ? voitures : new ArrayList<>();
        this.utilisateur = utilisateur;
    }

    // --- Getters / Setters ---
    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Panier{" +
                "id_panier=" + id_panier +
                ", date_creation=" + date_creation +
                ", nombre_voitures=" + (voitures != null ? voitures.size() : 0) +
                ", utilisateur=" + (utilisateur != null ? utilisateur.getNom() : "null") +
                '}';
    }
}
