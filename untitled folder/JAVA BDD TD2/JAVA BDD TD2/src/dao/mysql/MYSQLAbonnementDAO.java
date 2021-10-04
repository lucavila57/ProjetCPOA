package dao.mysql;

import modele.metier.Abonnement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import connexion.Connexion;
import dao.AbonnementDAO;


public class MYSQLAbonnementDAO implements AbonnementDAO{

	public static AbonnementDAO Instance;
	
	private MYSQLAbonnementDAO() {}
	
	public static AbonnementDAO getInstance() {
		
		if(Instance==null) {
			Instance = new MYSQLAbonnementDAO();
		}
		return Instance;
		
	}

	@Override
	public Abonnement getById(int id_abo) throws Exception {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean create(Abonnement objet) throws Exception {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
        PreparedStatement req = laConnexion.prepareStatement("insert into Periodicite (id) values(?)",
                Statement.RETURN_GENERATED_KEYS);

        req.setInt(1, objet.getId_abo());
        int res = req.executeUpdate();
		
		return false;
	}

	@Override
	public boolean update(Abonnement objet) throws Exception {
		// TODO Auto-generated method stub
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement req= laConnexion.prepareStatement("update Periodicite set id=?");

	        req.setInt(1, objet.getId_abo());
	        int res=req.executeUpdate();
		
		return false;
	}

	@Override
	public boolean delete(Abonnement objet) throws Exception {
		// TODO Auto-generated method stub
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement requete = laConnexion.prepareStatement("delete from Periodicite where id=?");
	            requete.setInt(1, objet.getId_abo());
	            int res= requete.executeUpdate();
	
		return false;
	}

}
