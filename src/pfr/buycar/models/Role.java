package pfr.buycar.models;

	
	/**
	 * Classe représentant un rôle d'utilisateur dans le projet BuyCar.
	 * Exemple : "Client", "Administrateur", etc.
	 */
	public class Role {

	    // --- Attributs ---
	    private int id_role;
	    private String nom;

	    // --- Constructeurs ---
	    public Role() {}

	    public Role(int id_role, String nom) {
	        this.id_role = id_role;
	        this.nom = nom;
	    }

	    // --- Getters et Setters ---
	    public int getId_role() {
	        return id_role;
	    }

	    public void setId_role(int id_role) {
	        this.id_role = id_role;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    // --- toString ---
	    @Override
	    public String toString() {
	        return "Role{" +
	                "id_role=" + id_role +
	                ", nom='" + nom + '\'' +
	                '}';
	    }
	}



