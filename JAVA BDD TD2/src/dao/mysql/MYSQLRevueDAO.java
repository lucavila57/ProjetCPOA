package dao.mysql;
//verifier getbyid , create update et delete 
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.RevueDAO;
import modele.metier.Client;
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
		Revue rev = null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from periodicite where id=?");
			requete.setInt(1, id_revue);
			ResultSet res = requete.executeQuery();
			if (res.next()) {
				rev = new Revue(res.getInt(1), res.getString(2), res.getString(3),res.getFloat(4),res.getString(5), null);
			} 

			Connexion.fermeture(laConnexion, requete, res);
		} catch (SQLException sqle) {
			System.out.println("pb dans insert" + sqle.getMessage());
		}
		return rev;
	}

	@Override
	public boolean create(Revue objet) throws Exception {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
        PreparedStatement req = laConnexion.prepareStatement("insert into Revue(id_revue,titre,description,tarif_numero,visuel) values(?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);

        req.setInt(1, objet.getId_revue());
        req.setString(2, objet.getTitre());
		req.setString(3, objet.getDescription());
		req.setDouble(4, objet.getTarif_numero());
		req.setString(5, objet.getVisuel());
		
		int res = req.executeUpdate();
		ResultSet re = req.getGeneratedKeys();
		if (re.next()) {
			objet.setId_revue(re.getInt(1));
			objet.setTitre(re.getString(2));
			objet.setDescription(re.getString(3));
			objet.setTarif_numero(re.getInt(4));
			objet.setVisuel(re.getString(5));
		} 
		return res==1;
	}

	@Override
	public boolean update(Revue objet) throws Exception {
		// TODO Auto-generated method stub
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement req= laConnexion.prepareStatement("Update Revue set titre=?, description=?, tarif_numero=?,visuel=? where id_revue=?");

	        req.setInt(1, objet.getId_revue());
	        req.setString(2, objet.getTitre());
			req.setString(3, objet.getDescription());
			req.setDouble(4, objet.getTarif_numero());
			req.setString(5, objet.getVisuel());
			
			int res = req.executeUpdate();
			ResultSet re = req.getGeneratedKeys();
			if (re.next()) {
				objet.setId_revue(re.getInt(1));
				objet.setTitre(re.getString(2));
				objet.setDescription(re.getString(3));
				objet.setTarif_numero(re.getInt(4));
				objet.setVisuel(re.getString(5));
			} 
			return res==1;
	}

	@Override
	public boolean delete(Revue objet) throws Exception {
		// TODO Auto-generated method stub
		 Connection laConnexion = Connexion.creeConnexion();
	        PreparedStatement req = laConnexion.prepareStatement("delete from Revue where id_revue=?");
	        req.setInt(1, objet.getId_revue());
			int res = req.executeUpdate();
			ResultSet re = req.getGeneratedKeys();
			if (re.next()) {
				objet.setId_revue(re.getInt(1));
			} 
			return res==1;
	}


	@Override
	public ArrayList<Revue> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

} 
