package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import connexion.Connexion;
import dao.RevueDAO;
import modele.metier.Revue;

public class MYSQLRevueDAO implements RevueDAO{

	public static MYSQLRevueDAO Instance;
	
	private MYSQLRevueDAO() {}

	
	public static MYSQLRevueDAO getInstance() {
		
		if (Instance==null) {
			Instance = new MYSQLRevueDAO();
		}
		return Instance;
	}
	@Override
	public Revue getById(int id_revue) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Revue objet) throws Exception {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
        PreparedStatement req = laConnexion.prepareStatement("insert into Periodicite (id) values(?)",
                Statement.RETURN_GENERATED_KEYS);

        req.setInt(1, objet.getId_revue());
        int res = req.executeUpdate();
		return false;
	}

	@Override
	public boolean update(Revue objet) throws Exception {
		// TODO Auto-generated method stub
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement req= laConnexion.prepareStatement("update Periodicite set id=?");

	        req.setInt(1, objet.getId_revue());
	        int res=req.executeUpdate();
		
		return false;
	}

	@Override
	public boolean delete(Revue objet) throws Exception {
		// TODO Auto-generated method stub
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement requete = laConnexion.prepareStatement("delete from Periodicite where id=?");
	            requete.setInt(1, objet.getId_revue());
	            int res= requete.executeUpdate();
	
		return false;
	}

}
