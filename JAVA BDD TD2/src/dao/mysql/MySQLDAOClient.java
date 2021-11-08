package dao.mysql;
// verifier getbyid et create update delete 

import dao.ClientDAO;
import modele.metier.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAOClient implements ClientDAO {

	public static ClientDAO Instance;

	private MySQLDAOClient() {
	}

	public static ClientDAO getInstance() {

		if (Instance == null) {
			Instance = new MySQLDAOClient();
		}
		return Instance;

	}

	@Override
	public Client getById(int id_cl) throws SQLException {
		Client cl = null;

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("select * from Client where id_client = ? ");
		requete.setInt(1, id_cl);
		ResultSet res = requete.executeQuery();
		if (res.next()) {
			cl = new Client(id_cl, res.getString("nom"), res.getString("prenom"), res.getString("no_rue"),
					res.getString("voie"), res.getString("code_postal"), res.getString("ville"), res.getString("pays"));
		}

		return cl;
	}

	@Override
	public boolean create(Client objet) throws SQLException {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement(
				"insert into Client(nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);

	
		req.setString(1, objet.getNom());
		req.setString(2, objet.getPrenom());
		req.setString(3, objet.getNoRue());
		req.setString(4, objet.getVoie());
		req.setString(5, objet.getCodePostal());
		req.setString(6, objet.getVille());
		req.setString(7, objet.getPays());
		int nbLignes = req.executeUpdate();
		ResultSet res = req.getGeneratedKeys();
		if (res.next()) {
			objet.setIdCl(res.getInt(1));

		}
		return nbLignes == 1;
	}

	@Override
	public boolean update(Client objet) throws SQLException {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement(
				"Update Client set nom=?, prenom=?, no_rue=?,voie=?,code_postal=?, ville=?, pays=? where id_client=?");

		req.setInt(1, objet.getIdCl());
		req.setString(2, objet.getNom());
		req.setString(3, objet.getPrenom());
		req.setString(4, objet.getNoRue());
		req.setString(5, objet.getVoie());
		req.setString(6, objet.getCodePostal());
		req.setString(7, objet.getVille());
		req.setString(8, objet.getPays());
		int nbLignes = req.executeUpdate();

		return nbLignes == 1;
	}

	@Override
	public boolean delete(Client objet) throws SQLException {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement("delete from Client where id_client=?");
		req.setInt(1, objet.getIdCl());
		int nbLignes = req.executeUpdate();

		return nbLignes == 1;
	}

	@Override
	public List<Client> getByNom(Client client) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Client> listeClient = new ArrayList<Client>();

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement req = laConnexion.prepareStatement("select * from client where nom = ?");
		req.setString(1, client.getNom());
		ResultSet res = req.executeQuery();
		if (res.next()) {
			client = new Client(res.getInt("id_client"), res.getString("nom"), res.getString("prenom"),
					res.getString("no_rue"), res.getString("voie"), res.getString("code_postal"),
					res.getString("ville"), res.getString("pays"));
		}

		return listeClient;

	}

	@Override
	public ArrayList<Client> findAll() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Client> listeClient = new ArrayList<>();

		Connection laConnexion = Connexion.getInstance().creeConnexion();

		PreparedStatement requete = laConnexion.prepareStatement("select * from Client");

		ResultSet res = requete.executeQuery();

		if (res.next()) {
			listeClient.add(new Client(res.getInt("id_client"), res.getString("nom"), res.getString("prenom"),
					res.getString("no_rue"), res.getString("voie"), res.getString("code_postal"),
					res.getString("ville"), res.getString("pays")));
		}

		return listeClient;

	}

}