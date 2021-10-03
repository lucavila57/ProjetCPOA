package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import connexion.Connexion;
import dao.ClientDAO;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Client objet) throws Exception {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
        PreparedStatement req = laConnexion.prepareStatement("insert into Periodicite (id) values(?)",
                Statement.RETURN_GENERATED_KEYS);

        req.setInt(1, objet.getId_cl());
        int res = req.executeUpdate();
		return false;
	}

	@Override
	public boolean update(Client objet) throws Exception {
		// TODO Auto-generated method stub
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement req= laConnexion.prepareStatement("update Periodicite set id=?");

	        req.setInt(1, objet.getId_cl());
	        int res=req.executeUpdate();
		
		return false;
	}

	@Override
	public boolean delete(Client objet) throws Exception {
		// TODO Auto-generated method stub
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement requete = laConnexion.prepareStatement("delete from Periodicite where id=?");
	            requete.setInt(1, objet.getId_cl());
	            int res= requete.executeUpdate();
	
		return false;
	}

	@Override
	public List<Client> getByNom() {
		// TODO Auto-generated method stub
		return null;
	}
	
}