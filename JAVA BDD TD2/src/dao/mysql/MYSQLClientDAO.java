package dao.mysql;
// verifier getbyid et create update delete 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.ClientDAO;
import modele.metier.Abonnement;
import modele.metier.Client;

public class MYSQLClientDAO implements ClientDAO{

	public static ClientDAO Instance;

	private MYSQLClientDAO() {}
	
public static ClientDAO getInstance() {
		
		if(Instance==null) {
			Instance = new MYSQLClientDAO();
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
        PreparedStatement req = laConnexion.prepareStatement("insert into Client(id_client,nom,prenom,no_rue,voie,code_postal, ville,pays) values(?,?,?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);

        req.setInt(1, objet.getId_cl());
        req.setString(2, objet.getNom());
		req.setString(3, objet.getPrenom());
		req.setString(4, objet.getNo_rue());
		req.setString(5, objet.getVoie());
		req.setString(6, objet.getCode_postal());
		req.setString(7, objet.getVille());
		req.setString(8, objet.getPays());
		int res = req.executeUpdate();
		ResultSet re = req.getGeneratedKeys();
		if (re.next()) {
			objet.setId_cl(re.getInt(1));
		} 
		return res==1;
	}

	@Override
	public boolean update(Client objet) throws Exception {
		// TODO Auto-generated method stub
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement req= laConnexion.prepareStatement("Update Client set nom=?, prenom=?, no_rue=?,voie=?,code_postal=?, ville=?, pays=? where id_client=?");

	        req.setInt(1, objet.getId_cl());
	        req.setString(2, objet.getNom());
			req.setString(3, objet.getPrenom());
			req.setString(4, objet.getNo_rue());
			req.setString(5, objet.getVoie());
			req.setString(6, objet.getCode_postal());
			req.setString(7, objet.getVille());
			req.setString(8, objet.getPays());
			int res = req.executeUpdate();
			ResultSet re = req.getGeneratedKeys();
			if (re.next()) {
				objet.setId_cl(re.getInt(1));
			} 
			return res==1;
	}

	@Override
	public boolean delete(Client objet) throws Exception {
		// TODO Auto-generated method stub
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement req = laConnexion.prepareStatement("delete from Client where id_client=?");
	        req.setInt(1, objet.getId_cl());
			int res = req.executeUpdate();
			ResultSet re = req.getGeneratedKeys();
			if (re.next()) {
				objet.setId_cl(re.getInt(1));
			} 
			return res==1;
	}

	@Override
	public List<Client> getByNom(String name) throws Exception{
		// TODO Auto-generated method stub
		ArrayList<Client> resultat = new ArrayList<Client>();
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement req= laConnexion.prepareStatement("select * from client where nom = ?");
	    	req.setString(1, name);
			ResultSet res = req.executeQuery();
			if (res.next()) {
				name = new Client(res.getInt(1), res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays"));
			} 

			Connexion.fermeture(laConnexion, req, res);
		} catch (SQLException sqle) {
			System.out.println("pb dans insert" + sqle.getMessage());
		}
		return name;
		
	}
	
}