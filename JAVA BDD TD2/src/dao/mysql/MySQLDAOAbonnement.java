package dao.mysql;

//verifier getbyid, create update et delete
import modele.metier.Abonnement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.AbonnementDAO;

public class MySQLDAOAbonnement implements AbonnementDAO {

	public static AbonnementDAO Instance;

	private MySQLDAOAbonnement() {
	}

	public static AbonnementDAO getInstance() {

		if (Instance == null) {
			Instance = new MySQLDAOAbonnement();
		}
		return Instance;

	}

	@Override
	public Abonnement getById(int idCl, int idRevue) throws SQLException {
		// TODO Auto-generated method stub
		Abonnement abo = null;

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = laConnexion
				.prepareStatement("select * from Abonnement where id_client = ? and id_revue = ?");
		requete.setInt(1, idCl);
		requete.setInt(2, idRevue);
		ResultSet res = requete.executeQuery();
		if (res.next()) {
			abo = new Abonnement(null,null, idCl, idCl);
		}

		return abo;

	}

	@Override
	public boolean create(Abonnement objet) throws SQLException {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement(
				"insert into Abonnement(date_debut,date_fin,id_client,id_revue) values(?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		req.setDate(1, java.sql.Date.valueOf(objet.getDateDeb()));
		req.setDate(2, java.sql.Date.valueOf(objet.getDateFin()));
		req.setInt(3, objet.getIdCl());
		req.setInt(4, objet.getId_revue());

		int nbLignes = req.executeUpdate();
		ResultSet res = req.getGeneratedKeys();
		if (res.next()) {
			objet.setIdAbo(res.getInt(1));

		}
		return nbLignes == 1;
	}

	@Override
	public boolean update(Abonnement objet) throws SQLException {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement(
				"update Abonnement set date_debut = ?, date_fin = ? where id_client = ? and id_revue = ?");

		req.setDate(1, java.sql.Date.valueOf(objet.getDateDeb()));
		req.setDate(2, java.sql.Date.valueOf(objet.getDateFin()));
		req.setInt(3, objet.getIdCl());
		req.setInt(4, objet.getId_revue());

		int nbLignes = req.executeUpdate();

		return nbLignes == 1;

	}

	@Override
	public boolean delete(Abonnement objet) throws SQLException {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion
				.prepareStatement("delete from Abonnement where id_client = ? and id_revue = ?");
		req.setInt(1, objet.getIdCl());
		req.setInt(2, objet.getId_revue());
		int nbLignes = req.executeUpdate();

		return nbLignes == 1;

	}

	@Override
	public ArrayList<Abonnement> findAll() throws SQLException {
		ArrayList<Abonnement> listeAbonnement = new ArrayList<>();

		Connection laConnexion = Connexion.getInstance().creeConnexion();

		PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement");

		ResultSet res = requete.executeQuery();

		if (res.next()) {
			listeAbonnement.add(new Abonnement(null, null, res.getInt("id_client"), res.getInt("id_revue")));
		}

		return listeAbonnement;
	}

	@Override
	public Abonnement getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
