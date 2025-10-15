package pfr.buycar.models;

/**
 * Classe représentant la relation entre un utilisateur et une adresse.
 * (Table d'association PossedeAdresse)
 */
public class PossedeAdresse {

    // --- Attributs ---
    private int id_user;
    private int id_adresse;

    // --- Constructeurs ---
    public PossedeAdresse() {}

    public PossedeAdresse(int id_user, int id_adresse) {
        this.id_user = id_user;
        this.id_adresse = id_adresse;
    }

    // --- Getters / Setters ---
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    // --- toString ---
    @Override
    public String toString() {
        return "PossedeAdresse{" +
                "id_user=" + id_user +
                ", id_adresse=" + id_adresse +
                '}';
    }
}

