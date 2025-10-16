package pfr.buycar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pfr.buycar.models.Client;

public class UtilisateurDao implements CRUDable<Client> {

	// private static final List<UtilisateurMock> utilisateurs = new ArrayList<>();

	private Connection connection;

	public UtilisateurDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean create(Client user) {

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
	public Client read(int id) {
		String sql = "SELECT * FROM Utilisateur WHERE id_user = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Client user = new Client(rs.getString("nom"), rs.getString("prenom"), rs.getString("nom_compte"),
						rs.getString("mot_de_passe"), rs.getInt("id_role"), rs.getString("email"));

				user.setId(rs.getInt("id_user")); // injection l'id après construction

				return user;
			}
		} catch (SQLException e) {
			System.err.println("Erreur de lecture : " + e.getMessage());
		}
		return null;
	}

	public Client findByLoginAndPassword(String compte, String password) {
		String sql = "SELECT * FROM Utilisateur WHERE nom_compte = ? AND mot_de_passe = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, compte);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Client user = new Client(rs.getString("nom"), rs.getString("prenom"), rs.getString("nom_compte"),
						rs.getString("mot_de_passe"), rs.getInt("id_role"), rs.getString("email"));
				user.setId(rs.getInt("id_user"));
				
				System.out.println(user.toString());
				
				return user;
			}

		} catch (SQLException e) {
			System.err.println("Erreur lors de la récupération de l'utilisateur : " + e.getMessage());
		}
		return null;
	}

	// Vérifie si un utilisateur existe
	public boolean isUserExist(String compte, String password) {
		String sql = "SELECT id_user FROM Utilisateur WHERE nom_compte = ? AND mot_de_passe = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, compte);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			return rs.next(); // retourne vrai si trouvé

		} catch (SQLException e) {
			System.err.println("Erreur lors de la vérification de l'utilisateur : " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Client> getAll() {
		List<Client> clients = new ArrayList<>();
		String sql = "SELECT * FROM Utilisateur";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Client client = new Client(
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("nom_compte"),
						rs.getString("mot_de_passe"),
						rs.getInt("id_role"),
						rs.getString("email")
						);
						client.setId(rs.getInt("id_user"));
						clients.add(client);
			}
			
			
		} catch (SQLException e) {
			System.out.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
		}
		
		return clients;
	}
}






















