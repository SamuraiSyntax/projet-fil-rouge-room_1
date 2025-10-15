package pfr.buycar.models;

import java.util.List;

public class Categorie {

	private int id_categorie;
	private String nom;
	private String description;
	// Liste de voitures appartenant à cette catégorie
	private List<Voiture> voitures;
	
	
	public Categorie(int id_categorie, String nom, String description, List<Voiture> voitures) {
		super();
		this.id_categorie = id_categorie;
		this.nom = nom;
		this.description = description;
		this.voitures = voitures;
	}


	public int getId_categorie() {
		return id_categorie;
	}


	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Voiture> getVoitures() {
		return voitures;
	}


	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	} 
	
	



}
