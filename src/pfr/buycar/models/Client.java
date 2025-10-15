package pfr.buycar.models;

public class Client extends Utilisateur{
	
	
	private String adresse;
	    private String telephone;

	    public Client(int id, String nom, String email, String password, String role, String telephone) {
			super(id, nom, email, password, role, telephone);
			// TODO Auto-generated constructor stub
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		@Override
		public String toString() {
			return "Client [adresse=" + adresse + ", telephone=" + telephone + "]";
		}
	    
	    

}
