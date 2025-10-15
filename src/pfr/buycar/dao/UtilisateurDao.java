package pfr.buycar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;





public class UtilisateurDao implements CRUDable<UtilisateurMock>{
	
	//private static final List<UtilisateurMock> utilisateurs = new ArrayList<>();
	private Connection connection;

    public UtilisateurDao(Connection connection) {
        this.connection = connection;
    }
	 @Override
	 public boolean create(UtilisateurMock user) {
		 
	     String sql = "INSERT INTO Utilisateur (nom, prenom, nom_compte, mot_de_passe, id_role, email) VALUES (?, ?, ?, ?, ?, ?)";
	     
	     try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	         stmt.setString(1, user.getNom());
	         stmt.setString(2, user.getPrenom());
	         stmt.setString(3, user.getcompte());
	         stmt.setString(4, user.getpassword());
	         stmt.setInt(5, user.getRole());
	         stmt.setString(6, user.getEmail());
	         stmt.executeUpdate();
	         System.out.println("Utilisateur ajouté : " + user.getNom());
	         return true;
	        } catch (SQLException e) {
	            System.err.println("Erreur lors de l’insertion : " + e.getMessage());
	            return false;
	        }
	    }

	@Override
	public UtilisateurMock read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(UtilisateurMock obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UtilisateurMock> getAll() {
		// TODO Auto-generated method stub
		return null;
	}	
}
