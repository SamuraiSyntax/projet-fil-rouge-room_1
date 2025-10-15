package pfr.buycar.models;

/**
 * Classe représentant une adresse postale dans le projet BuyCar.
 */
public class Adresse {

    private int id_adresse;
    private String details;
    private String ville;
    private String code_postal;
    private String pays;
    private boolean est_principale;

    // --- Constructeurs ---
    public Adresse() {}

    public Adresse(int id_adresse, String details, String ville, String code_postal, String pays, boolean est_principale) {
        this.id_adresse = id_adresse;
        this.details = details;
        this.ville = ville;
        this.code_postal = code_postal;
        this.pays = pays;
        this.est_principale = est_principale;
    }

    // --- Getters et Setters ---
    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public boolean isEst_principale() {
        return est_principale;
    }

    public void setEst_principale(boolean est_principale) {
        this.est_principale = est_principale;
    }

    // --- toString (facultatif mais pratique pour afficher les infos) ---
    @Override
    public String toString() {
        return "Adresse{" +
                "id_adresse=" + id_adresse +
                ", details='" + details + '\'' +
                ", ville='" + ville + '\'' +
                ", code_postal='" + code_postal + '\'' +
                ", pays='" + pays + '\'' +
                ", est_principale=" + est_principale +
                '}';
    }
}

