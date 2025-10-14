package pfr.buycar.dao;

/*
* Classe pour tester la création d'utilisateur en base de données
* A remplacer par la vrai classe abstraite Utilisateur
*/


public abstract class UtilisateurMock {
	
	private int id;
    private String nom;
    private String prenom;
    private String compte;
    private String password;
    private int role;
    private String email;
    
    
    //Constructeur utilisateur
	public UtilisateurMock(String nom, String prenom, String compte,String password,int role, String email) {
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
    
    
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setCompte(String compte) { this.compte = compte; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(int role) { this.role = role; }
    public void setEmail(String email) { this.email = email; }


	@Override
	public String toString() {
		return "UtilisateurMock [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}

}
