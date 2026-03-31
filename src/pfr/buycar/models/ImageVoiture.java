package pfr.buycar.models;

/**
 * Classe représentant une image associée à une voiture.
 */
public class ImageVoiture {

    // --- Attributs ---
    private int id_image;
    private String url;
    private int ordre;
    private Voiture voiture;

    // --- Constructeurs ---
    public ImageVoiture() {}

    public ImageVoiture(int id_image, String url, int ordre, Voiture voiture) {
        this.id_image = id_image;
        this.url = url;
        this.ordre = ordre;
        this.voiture = voiture;
    }

    // --- Getters / Setters ---
    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    // --- toString ---
    @Override
    public String toString() {
        return "ImageVoiture{" +
                "id_image=" + id_image +
                ", url='" + url + '\'' +
                ", ordre=" + ordre +
                ", voiture_id=" + (voiture != null ? voiture.getId_voiture() : "null") +
                '}';
    }
}
