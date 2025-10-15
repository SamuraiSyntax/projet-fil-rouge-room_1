package pfr.buycar.models;

public class Administrateur extends Utilisateur {
	
	
	// --- Attributs spécifiques ---
    private String codeAdmin;

		
	public Administrateur(int id, String nom, String email, String password, String role, String telephone) {
		super(id, nom, email, password, role, telephone);
		// TODO Auto-generated constructor stub
	}

	

    // --- Méthodes spécifiques à l'administrateur ---
    public void afficherInfosAdmin() {
        System.out.println("👑 Administrateur : " + getNom());
        System.out.println("Email : " + getEmail());
        System.out.println("Code admin : " + codeAdmin);
    }

    // --- Redéfinition de toString ---
    @Override
    public String toString() {
        return "Administrateur{" +
                "id=" + getId() +
                ", nom='" + getNom() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", role='" + getRole() + '\'' +
                ", codeAdmin='" + codeAdmin + '\'' +
                '}';
    }

}
