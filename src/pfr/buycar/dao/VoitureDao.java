package pfr.buycar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VoitureDao implements CRUDable<VoitureMock>{
	
	private Connection connection;

    public VoitureDao(Connection connection) {
        this.connection = connection;
    }

	@Override
	public boolean create(VoitureMock voiture) {
		String sql = "INSERT INTO Voiture (reference, marque, modele, annee, couleur, prix, id_categorie) VALUES (?, ?, ?, ?, ?, ?, ?)";
	     
	     try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	         stmt.setString(1, voiture.getReference());
	         stmt.setString(2, voiture.getMarque());
	         stmt.setString(3, voiture.getModele());
	         stmt.setInt(4, voiture.getAnnee());
	         stmt.setString(5, voiture.getCouleur());
	         stmt.setDouble(6, voiture.getPrix());
	         stmt.setInt(7, voiture.getId_categorie());
	         stmt.executeUpdate();
	         System.out.println("Voiture ajoutée : " + voiture.getReference());
	         return true;
	        } catch (SQLException e) {
	            System.err.println("Erreur lors de l’insertion : " + e.getMessage());
	            return false;
	        }
	}

	@Override
	public VoitureMock read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(VoitureMock obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VoitureMock> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
