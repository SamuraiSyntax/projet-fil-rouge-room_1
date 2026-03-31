package pfr.buycar.models;

import java.util.Objects;

public class Voiture {
	
	
	private String reference;
	private String marque;
	private String modele;
	private int annee;
	private String couleur;
	private double prix;
	private int id_categorie;
	
	public Voiture( String reference, String marque, String modele, int annee, String couleur,
			double prix, int id_categorie) {
		super();
		
		this.reference = reference;
		this.marque = marque;
		this.modele = modele;
		this.annee = annee;
		this.couleur = couleur;
		this.prix = prix;
		this.id_categorie = id_categorie;
	}

		

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}

	@Override
	public String toString() {
		return "Voiture [reference=" + reference + ", marque=" + marque + ", modele="
				+ modele + ", annee=" + annee + ", couleur=" + couleur + ", prix=" + prix + ", id_categorie="
				+ id_categorie + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(annee, couleur, id_categorie, marque, modele, prix, reference);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voiture other = (Voiture) obj;
		return annee == other.annee && Objects.equals(couleur, other.couleur) && id_categorie == other.id_categorie
				&&Objects.equals(marque, other.marque)
				&& Objects.equals(modele, other.modele)
				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix)
				&& Objects.equals(reference, other.reference);
	}
	
	
	
	
}
