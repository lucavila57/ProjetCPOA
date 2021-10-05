package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connexion.Connexion;
import dao.AbonnementDAO;
import dao.PeriodiciteDAO;
import modele.metier.Periodicite;

public class MYSQLPeriodiciteDAO implements PeriodiciteDAO {

	public static PeriodiciteDAO Instance;

	private MYSQLPeriodiciteDAO() {
	}

	public static PeriodiciteDAO getInstance() {

		if (Instance == null) {
			Instance = new MYSQLPeriodiciteDAO();
		}
		return Instance;

	}

	@Override
	public Periodicite getById(int id) throws Exception {
		// TODO Auto-generated method stub
		Periodicite perio = null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from periodicite where id=?");
			requete.setInt(1, id);
			ResultSet res = requete.executeQuery();
			if (res.next()) {
				perio = new Periodicite(res.getInt(1), res.getString(2));
			} 

			Connexion.fermeture(laConnexion, requete, res);
		} catch (SQLException sqle) {
			System.out.println("pb dans insert" + sqle.getMessage());
		}
		return perio;

	}

	@Override
	public boolean create(Periodicite objet) throws Exception {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement("insert into Periodicite (libelle) values(?)",
				Statement.RETURN_GENERATED_KEYS);

		req.setString(1, objet.getLibelle());
		int res = req.executeUpdate();
		ResultSet re = req.getGeneratedKeys();
		if (re.next()) {
			objet.setId(re.getInt(1));
		} 
		return res==1;
	}

	@Override
	public boolean update(Periodicite objet) throws Exception {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement("update Periodicite set libelle=? where libelle=?");

		req.setString(1, objet.getLibelle());
		int res = req.executeUpdate();
		ResultSet re = req.getGeneratedKeys();
		if (re.next()) {
			objet.setId(re.getInt(1));
		} 
		return res==1;
	}
	
	@Override
	public boolean delete(Periodicite objet) throws Exception {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement("delete from Periodicite where id=?");
		req.setString(1, objet.getLibelle());
		int res = req.executeUpdate();
		ResultSet re = req.getGeneratedKeys();
		if (re.next()) {
			objet.setId(re.getInt(1));
		} 
		return res==1;
	}
}


