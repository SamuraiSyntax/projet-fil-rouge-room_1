package pfr.buycar.models;

/**
 * Classe représentant le statut d'une commande dans le projet BuyCar.
 * Contient un identifiant, un libellé et une description.
 */
public class StatutCommande {

    private int id_statut;
    private String statut;
    private String description;

    // --- Constructeurs ---
    public StatutCommande() {}

    public StatutCommande(int id_statut, String statut, String description) {
        this.id_statut = id_statut;
        this.statut = statut;
        this.description = description;
    }

    // --- Getters / Setters ---
    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // --- toString ---
    @Override
    public String toString() {
        return "StatutCommande{" +
                "id_statut=" + id_statut +
                ", statut='" + statut + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
