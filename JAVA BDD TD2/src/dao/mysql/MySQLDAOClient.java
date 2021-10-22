package dao.mysql;
// verifier getbyid et create update delete 
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ClientDAO;
import modele.metier.Abonnement;
import modele.metier.Client;
import modele.metier.Revue;

public class MySQLDAOClient implements ClientDAO{

	public static ClientDAO Instance;

	private MySQLDAOClient() {}
	
public static ClientDAO getInstance() {
		
		if(Instance==null) {
			Instance = new MySQLDAOClient();
		}
		return Instance;
		
	}
	@Override
	public Client getById(int id_cl) throws Exception {
		Client cl = null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where id_client = ? ");
			requete.setInt(1, id_cl);
			ResultSet res = requete.executeQuery();
			if (res.next()) {
				cl = new Client(res.getInt(1), res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays"));
			} 

			Connexion.fermeture(laConnexion, requete, res);
		} catch (SQLException sqle) {
			System.out.println("pb dans insert" + sqle.getMessage());
		}
		return cl;
	}

	@Override
	public boolean create(Client objet) throws Exception {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
        PreparedStatement req = laConnexion.prepareStatement("insert into Client(id_client,nom,prenom,no_rue,voie,code_postal,ville,pays) values(?,?,?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);

        req.setInt(1, objet.getIdCl());
        req.setString(2, objet.getNom());
		req.setString(3, objet.getPrenom());
		req.setString(4, objet.getNoRue());
		req.setString(5, objet.getVoie());
		req.setString(6, objet.getCodePostal());
		req.setString(7, objet.getVille());
		req.setString(8, objet.getPays());
		int res = req.executeUpdate();
		ResultSet re = req.getGeneratedKeys();
		if (re.next()) {
			objet.setIdCl(re.getInt(1));
			objet.setNom(re.getString(2));
			objet.setPrenom(re.getString(3));
			objet.setNoRue(re.getString(4));
			objet.setVoie(re.getString(5));
			objet.setCodePostal(re.getString(6));
			objet.setVille(re.getString(7));
			objet.setPays(re.getString(8));
		} 
		return res==1;
	}

	@Override
	public boolean update(Client objet) throws Exception {
		// TODO Auto-generated method stub
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement req= laConnexion.prepareStatement("Update Client set nom=?, prenom=?, no_rue=?,voie=?,code_postal=?, ville=?, pays=? where id_client=?");

	        req.setInt(1, objet.getIdCl());
	        req.setString(2, objet.getNom());
			req.setString(3, objet.getPrenom());
			req.setString(4, objet.getNoRue());
			req.setString(5, objet.getVoie());
			req.setString(6, objet.getCodePostal());
			req.setString(7, objet.getVille());
			req.setString(8, objet.getPays());
			int res = req.executeUpdate();
			ResultSet re = req.getGeneratedKeys();
			if (re.next()) {
				objet.setIdCl(re.getInt(1));
				objet.setNom(re.getString(2));
				objet.setPrenom(re.getString(3));
				objet.setNoRue(re.getString(4));
				objet.setVoie(re.getString(5));
				objet.setCodePostal(re.getString(6));
				objet.setVille(re.getString(7));
				objet.setPays(re.getString(8));
			} 
			return res==1;
	}

	@Override
	public boolean delete(Client objet) throws Exception {
		// TODO Auto-generated method stub
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement req = laConnexion.prepareStatement("delete from Client where id_client=?");
	        req.setInt(1, objet.getIdCl());
			int res = req.executeUpdate();
			ResultSet re = req.getGeneratedKeys();
			if (re.next()) {
				objet.setIdCl(re.getInt(1));
			} 
			return res==1;
	}

	@Override
	public List<Client> getByNom(Client client) throws Exception{
		// TODO Auto-generated method stub
		ArrayList<Client> resultat = new ArrayList<Client>();
		try {
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement req= laConnexion.prepareStatement("select * from client where nom = ?");
	    	req.setString(1, client.getNom());
			ResultSet res = req.executeQuery();
			if (res.next()) {
				client = new Client(res.getInt(1), res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays"));
			} 

			Connexion.fermeture(laConnexion, req, res);
		} catch (SQLException sqle) {
			System.out.println("pb dans insert" + sqle.getMessage());
		}
		return resultat;
		
	}
	@Override
	public ArrayList<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}