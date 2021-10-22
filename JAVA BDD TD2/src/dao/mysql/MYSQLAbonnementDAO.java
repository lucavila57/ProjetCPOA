package dao.mysql;

//verifier getbyid, create update et delete
import modele.metier.Abonnement;
import modele.metier.Periodicite;
import modele.metier.Revue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.AbonnementDAO;

public class MYSQLAbonnementDAO implements AbonnementDAO {

	public static AbonnementDAO Instance;

	private MYSQLAbonnementDAO() {
	}

	public static AbonnementDAO getInstance() {

		if (Instance == null) {
			Instance = new MYSQLAbonnementDAO();
		}
		return Instance;

	}

	@Override
	public Abonnement getById(int id_abo) throws Exception {
		// TODO Auto-generated method stub
		Abonnement abo = null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from periodicite where id=?");
			requete.setInt(1, id_abo);
			ResultSet res = requete.executeQuery();
			if (res.next()) {
				abo = new Abonnement(res.getInt(1), null, null, null, null);
			}

			Connexion.fermeture(laConnexion, requete, res);
		} catch (SQLException sqle) {
			System.out.println("pb dans insert" + sqle.getMessage());
		}
		return abo;

	}

	@Override
	public boolean create(Abonnement objet) throws Exception {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement(
				"insert into Abonnement(id_client,id_revue,date_debut,date_fin) values(?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);

		req.setInt(1, objet.getId_abo());

		req.setDate(4, objet.getDate_deb());
		req.setDate(5, objet.getDate_fin());
		int res = req.executeUpdate();
		ResultSet re = req.getGeneratedKeys();
		if (re.next()) {
			objet.setId_abo(re.getInt(1));
			objet.setDate_deb(re.getDate(4));
			objet.setDate_fin(re.getDate(5));

		}
		return res == 1;
	}

	@Override
	public boolean update(Abonnement objet) throws Exception {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement req = laConnexion
				.prepareStatement("Update Abonnement set date_deb=?, date_fin=? where id_abo");
		req.setInt(1, objet.getId_abo());
		req.setDate(4, objet.getDate_deb());
		req.setDate(5, objet.getDate_fin());
		int res = req.executeUpdate();
		ResultSet re = req.getGeneratedKeys();
		if (re.next()) {
			objet.setId_abo(re.getInt(1));
			objet.setDate_deb(re.getDate(4));
			objet.setDate_fin(re.getDate(5));
		}
		return res == 1;

	}

	@Override
	public boolean delete(Abonnement objet) throws Exception {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement("Delete from Abonnement where id_abo");
		req.setInt(1, objet.getId_abo());
		int res = req.executeUpdate();
		ResultSet re = req.getGeneratedKeys();
		if (re.next()) {
			objet.setId_abo(re.getInt(1));
		}
		return res == 1;

	}
	@Override
	public ArrayList<Abonnement> findAll() {
		
		return null;
	}
}
