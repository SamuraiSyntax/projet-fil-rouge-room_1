package pfr.buycar.dao;

public class VoitureMock {

	private String reference;
	private String marque;
	private String modele;
	private int annee;
	private String couleur;
	private double prix;
	private int id_categorie;
	
	public VoitureMock(String reference, String marque, String modele, int annee, String couleur, double prix, int id_categorie) {
		this.reference = reference;
		this.marque = marque;
		this.modele = modele;
		this.annee = annee;
		this.couleur = couleur;
		this.prix = prix;
		this.id_categorie = id_categorie;
	}

	public String getReference() { return reference; }

	public void setReference(String reference) { this.reference = reference; }

	public String getMarque() { return marque; }

	public void setMarque(String marque) { this.marque = marque; }

	public String getModele() { return modele; }

	public void setModele(String modele) { this.modele = modele; }

	public int getAnnee() { return annee; }

	public void setAnnee(int annee) { this.annee = annee; }
	
	public String getCouleur() {return couleur; }
	
	public void setCouleur(String couleur) { this.couleur = couleur; }
	
	public double getPrix() { return prix; }

	public void setPrix(double prix) { this.prix = prix; }
	
	public int getId_categorie() { return id_categorie; }

	public void setId_categorie(int id_categorie) { this.id_categorie = id_categorie; }

	@Override
	public String toString() {
		return "VoitureMock [reference=" + reference + ", marque=" + marque + ", modele="
				+ modele + ", annee=" + annee + ", prix=" + prix + "]";
	}
	

}
