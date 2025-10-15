package pfr.buycar.client;

import java.util.Objects;

public abstract class Utilisateur {
	
	private int id;
	private String nom;
	private String email;
	private String password;
	private String role;
	private String telephone;
	
	public Utilisateur(int id, String nom, String email, String password, String role, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.role = role;
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", email=" + email + ", password=" + password + ", role="
				+ role + ", telephone=" + telephone + "]";
	}

	

}
