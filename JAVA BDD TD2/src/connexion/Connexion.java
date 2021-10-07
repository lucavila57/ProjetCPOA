package connexion;

import java.sql.*;

public class Connexion {

	public static Connection creeConnexion() {

			String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/reina7u_java";
			String login = "reina7u_appli";
			url += "?serverTimezone=Europe/Paris";
			String pwd = "32015391";
			Connection maConnexion = null;
			try {
				maConnexion = DriverManager.getConnection(url, login, pwd);
			} catch (SQLException sqle) {
				System.out.println("Erreur connexion" + sqle.getMessage());
			}
			return maConnexion;
		}
	public void uneRequete() {
		try {
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			ResultSet res = requete.executeQuery("select id_periodicite, libelle from Periodicite");
			while (res.next()) {
				int no = res.getInt(1);
				String nom = res.getString("libelle");
				System.out.println(no +" "+ nom);

			}
			if (res != null)
				res.close();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());

		}
	}

	public static void fermeture(Connection laConnexion, PreparedStatement req, ResultSet res) throws SQLException {
		
		if(res != null)
			res.close();
		if(req != null)
			req.close();
		if(laConnexion != null)
			laConnexion.close();
	}

}