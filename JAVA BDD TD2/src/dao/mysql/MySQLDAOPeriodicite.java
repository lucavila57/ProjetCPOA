package dao.mysql;

import dao.PeriodiciteDAO;
import modele.metier.Periodicite;

import java.sql.*;
import java.util.ArrayList;

public class MySQLDAOPeriodicite implements PeriodiciteDAO {

	public static PeriodiciteDAO Instance;

	private MySQLDAOPeriodicite() {
	}

	public static PeriodiciteDAO getInstance() {

		if (Instance == null) {
			Instance = new MySQLDAOPeriodicite();
		}
		return Instance;

	}

	@Override
	public Periodicite getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Periodicite perio = null;

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("select * from Periodicite where id_periodicite =?");
		requete.setInt(1, id);
		ResultSet res = requete.executeQuery();
		if (res.next()) {
			perio = new Periodicite(id, res.getString("libelle"));
		}

		return perio;

	}

	@Override
	public boolean create(Periodicite objet) throws SQLException {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement("Insert into Periodicite (libelle) value(?)",
				Statement.RETURN_GENERATED_KEYS);

		req.setString(1, objet.getLibelle());
		int nbLignes = req.executeUpdate();
		ResultSet res = req.getGeneratedKeys();
		if (res.next()) {
			objet.setId_perio(res.getInt(1));
		}
		return nbLignes == 1;
	}

	@Override
	public boolean update(Periodicite objet) throws SQLException {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement("update Periodicite set libelle=? where id_periodicite=?");
		req.setString(1, objet.getLibelle());
		req.setInt(2, objet.getId_perio());
		int nbLignes = req.executeUpdate();

		return nbLignes == 1;
	}

	@Override
	public boolean delete(Periodicite objet) throws SQLException {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement("delete from Periodicite where id_periodicite=?");
		req.setInt(1, objet.getId_perio());
		int nbLignes = req.executeUpdate();

		return nbLignes == 1;
	}

	@Override
	public ArrayList<Periodicite> findAll() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Periodicite> listePeriodicite = new ArrayList<>();

		Connection laConnexion = Connexion.getInstance().creeConnexion();

		PreparedStatement requete = laConnexion.prepareStatement("select * from Periodicite");

		ResultSet res = requete.executeQuery();

		if (res.next()) {
			listePeriodicite.add(new Periodicite(res.getInt("id_periodicite"), res.getString("libelle")));
		}

		return listePeriodicite;

	}
}
