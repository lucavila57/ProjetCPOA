package dao.mysql;
// verifier getbyid et create update delete 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			PreparedStatement requete = laConnexion.prepareStatement("select * from periodicite where id=?");
			requete.setInt(1, id_cl);
			ResultSet res = requete.executeQuery();
			if (res.next()) {
				cl = new Client(res.getInt(1), res.getString(2),  res.getString(3),  res.getString(4),  res.getString(5),  res.getString(6),  res.getString(7),  res.getString(8));
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
        PreparedStatement req = laConnexion.prepareStatement("insert into Periodicite (id) values(?)",
                Statement.RETURN_GENERATED_KEYS);

        req.setInt(1, objet.getId_cl());
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
	        PreparedStatement req= laConnexion.prepareStatement("update Periodicite set id=?");

	        req.setInt(1, objet.getId_cl());
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
	        PreparedStatement req = laConnexion.prepareStatement("delete from Periodicite where id=?");
	        req.setInt(1, objet.getId_cl());
			int res = req.executeUpdate();
			ResultSet re = req.getGeneratedKeys();
			if (re.next()) {
				objet.setId_cl(re.getInt(1));
			} 
			return res==1;
	}

	@Override
	public List<Client> getByNom(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}