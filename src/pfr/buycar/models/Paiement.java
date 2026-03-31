package pfr.buycar.models;


import java.util.Date;

import pfr.buycar.utils.IPayable;

/**
 * Classe représentant un paiement dans le projet BuyCar.
 * Implémente l'interface IPayable pour simuler l'exécution d'un paiement.
 */
public class Paiement implements IPayable {

    // --- Attributs ---
    private int id_paiement;
    private String methode;
    private float remise;
    private Date date_paiement;
    private String etat;
    private Commande commande;

    // --- Constructeurs ---
    public Paiement() {}

    public Paiement(int id_paiement, String methode, float remise, Date date_paiement, String etat, Commande commande) {
        this.id_paiement = id_paiement;
        this.methode = methode;
        this.remise = remise;
        this.date_paiement = date_paiement;
        this.etat = etat;
        this.commande = commande;
    }

    // --- Getters / Setters ---
    public int getId_paiement() {
        return id_paiement;
    }

    public void setId_paiement(int id_paiement) {
        this.id_paiement = id_paiement;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    public float getRemise() {
        return remise;
    }

    public void setRemise(float remise) {
        this.remise = remise;
    }

    public Date getDate_paiement() {
        return date_paiement;
    }

    public void setDate_paiement(Date date_paiement) {
        this.date_paiement = date_paiement;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

     
       // --- toString ---
    @Override
    public String toString() {
        return "Paiement{" +
                "id_paiement=" + id_paiement +
                ", methode='" + methode + '\'' +
                ", remise=" + remise +
                ", date_paiement=" + date_paiement +
                ", etat='" + etat + '\'' +
                ", commande_id=" + (commande != null ? commande.getId_commande() : "null") +
                '}';
    }

	@Override
	public boolean effectuerPaiement() {
		// TODO Auto-generated method stub
		return false;
	}
}

