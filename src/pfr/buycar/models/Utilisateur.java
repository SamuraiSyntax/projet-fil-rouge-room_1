package pfr.buycar.models;

public abstract class Utilisateur {
	
	private int id;
	private String nom;
	private String prenom;
	private String compte;
	private String email;
	private String password;
	private int role;
	private String telephone;
	
	public Utilisateur(String nom, String prenom, String compte,String password,int role, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.compte = compte;
		this.password = password;
		this.role = role;
		this.email = email;
	}

	//Getter et Setter
	public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getcompte() { return compte; }
    public String getpassword() { return password; }
    public int getRole() { return role; }
    public String getEmail() { return email; }
    
    
    public void setId(int id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setCompte(String compte) { this.compte = compte; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(int role) { this.role = role; }
    public void setEmail(String email) { this.email = email; }
    
    

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", email=" + email + ", password=" + password + ", role="
				+ role + ", telephone=" + telephone + "]";
	}

	

}
