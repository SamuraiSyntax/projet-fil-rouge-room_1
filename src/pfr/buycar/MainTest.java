//package pfr.buycar;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import pfr.buycar.dao.UtilisateurDao;
//import pfr.buycar.dao.VoitureDao;
//import pfr.buycar.models.Client;
//import pfr.buycar.utils.DBConnection;
//
//public class MainTest {
//
//	public static void main(String[] args) throws SQLException {
//		
//		System.out.println("===Test de la connexion à la base de données===");
//
//		Connection conn = DBConnection.getConnection();
//
//		if (conn != null) {
//			System.out.println("Connexion active : " + conn);
//		} else {
//			System.err.println("Échec de la connexion à la base !");
//		}
//
//		System.out.println("\n=== Tests DAO ===");
//
//		UtilisateurDao userTest = new UtilisateurDao(conn);
//
//		userTest.create(new Client("Henry", "Jean", "hjean", "14455", 2, "hjean@exemple.com"));
//
//		VoitureDao voitureTest = new VoitureDao(conn);
//		
//		
//		System.out.println(userTest.isUserExist("hjean", "14455"));
//		
//		DBConnection.closeConnection();
//
//	}
//
//}
