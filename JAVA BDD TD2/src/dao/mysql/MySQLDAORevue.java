package dao.mysql;
//verifier getbyid , create update et delete 

import dao.RevueDAO;
import modele.metier.Revue;

import java.sql.*;
import java.util.ArrayList;

public class MySQLDAORevue implements RevueDAO {

	public static MySQLDAORevue Instance;

	private MySQLDAORevue() {
	}

	public static MySQLDAORevue getInstance() {

		if (Instance == null) {
			Instance = new MySQLDAORevue();
		}
		return Instance;
	}

	@Override
	public Revue getById(int id_revue) throws SQLException {
		// TODO Auto-generated method stub
		Revue rev = null;

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("select * from Revue where id_revue=?");
		requete.setInt(1, id_revue);
		ResultSet res = requete.executeQuery();
		if (res.next()) {
			rev = new Revue(id_revue, res.getString("titre"), res.getString("description"),
					res.getDouble("tarif_numero"), res.getString("visuel"), res.getInt("id_periodicite"));
		}

		return rev;
	}

	@Override
	public boolean create(Revue objet) throws SQLException {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement(
				"insert into Revue(titre, description, tarif_numero, visuel, id_periodicite) values(?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);

		req.setString(1, objet.getTitre());
		req.setString(2, objet.getDescription());
		req.setDouble(3, objet.getTarifNumero());
		req.setString(4, objet.getVisuel());
		req.setInt(5, objet.getId_perio());

		int nbLignes = req.executeUpdate();
		ResultSet res = req.getGeneratedKeys();
		if (res.next()) {
			objet.setId_revue(res.getInt(1));
		}
		return nbLignes == 1;
	}

	@Override
	public boolean update(Revue objet) throws SQLException {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement(
				"Update Revue set titre=?, description=?, tarif_numero=?,visuel=?, id_periodicite=? where id_revue=?");

		req.setInt(1, objet.getId_revue());
		req.setString(2, objet.getTitre());
		req.setString(3, objet.getDescription());
		req.setDouble(4, objet.getTarifNumero());
		req.setString(5, objet.getVisuel());
		req.setInt(6, objet.getId_perio());

		int nbLignes = req.executeUpdate();
		return nbLignes == 1;
	}

	@Override
	public boolean delete(Revue objet) throws SQLException {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement("delete from Revue where id_revue=?");
		req.setInt(1, objet.getId_revue());
		int nbLignes = req.executeUpdate();

		return nbLignes == 1;
	}

	@Override
	public ArrayList<Revue> findAll() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Revue> listeRevue = new ArrayList<>();

		Connection laConnexion = Connexion.getInstance().creeConnexion();

		PreparedStatement requete = laConnexion.prepareStatement("select * from Revue");

		ResultSet res = requete.executeQuery();

		if (res.next()) {
			listeRevue.add(new Revue(res.getInt("id_revue"), res.getString("titre"), res.getString("description"),
					res.getDouble("tarif_numero"), res.getString("visuel"), res.getInt("id_periodicite")));
		}

		return listeRevue;

	}

}
