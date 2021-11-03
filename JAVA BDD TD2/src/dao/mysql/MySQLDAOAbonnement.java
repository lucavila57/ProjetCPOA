package dao.mysql;

//verifier getbyid, create update et delete
import modele.metier.Abonnement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.AbonnementDAO;

public class MySQLDAOAbonnement implements AbonnementDAO {

    public static AbonnementDAO Instance;

    private MySQLDAOAbonnement() {
    }

    public static AbonnementDAO getInstance() {

        if (Instance == null) {
            Instance = new MySQLDAOAbonnement();
        }
        return Instance;

    }

    @Override
    public Abonnement getById(int idCl, int idRevue) throws Exception {
        // TODO Auto-generated method stub
        Abonnement abo = null;
        try {
            Connection laConnexion =  Connexion.getInstance().creeConnexion();
            PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement where id_client = ? and id_revue = ?");
            requete.setInt(1, idCl);
            requete.setInt(2, idRevue);
            ResultSet res = requete.executeQuery();
            if (res.next()) {
                abo = new Abonnement( null, null, idCl, idCl);
            }

            
        } catch (SQLException sqle) {
            System.out.println("pb dans insert" + sqle.getMessage());
        }
        return abo;

    }

    @Override
    public boolean create(Abonnement objet) throws Exception {
        // TODO Auto-generated method stub
        Connection laConnexion =  Connexion.getInstance().creeConnexion();
        PreparedStatement req = laConnexion.prepareStatement(
                "insert into Abonnement(date_debut,date_fin,id_client,id_revue) values(?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        req.setDate(1, java.sql.Date.valueOf(objet.getDateDeb()));
        req.setDate(2, java.sql.Date.valueOf(objet.getDateFin()));
        req.setInt(3, objet.getIdCl());
        req.setInt(4, objet.getIdRevue());

        int res = req.executeUpdate();
        ResultSet re = req.getGeneratedKeys();
        if (re.next()) {
            objet.setIdAbo(re.getInt(1));
        }
        return res == 1;
    }

    @Override
    public boolean update(Abonnement objet) throws Exception {
        // TODO Auto-generated method stub
        Connection laConnexion =  Connexion.getInstance().creeConnexion();
        PreparedStatement req = laConnexion
                .prepareStatement("Update Abonnement set id_abo=?, date_deb=?, date_fin=?, id_client=?, id_revue=? where id_abo=?");
        req.setInt(1, objet.getIdAbo());
        req.setDate(2, java.sql.Date.valueOf(objet.getDateDeb()));
        req.setDate(3, java.sql.Date.valueOf(objet.getDateFin()));
        req.setInt(4, objet.getIdCl());
        req.setInt(5, objet.getIdRevue());

        int res = req.executeUpdate();
        ResultSet re = req.getGeneratedKeys();
        if (re.next()) {
            objet.setIdAbo(re.getInt(1));
        }
        return res == 1;

    }

    @Override
    public boolean delete(Abonnement objet) throws Exception {
        // TODO Auto-generated method stub
        Connection laConnexion =  Connexion.getInstance().creeConnexion();
        PreparedStatement req = laConnexion.prepareStatement("Delete from Abonnement where id_abo");
        req.setInt(1, objet.getIdAbo());
        int res = req.executeUpdate();
        ResultSet re = req.getGeneratedKeys();
        if (re.next()) {
            objet.setIdAbo(re.getInt(1));
        }
        return res == 1;

    }
    @Override
    public ArrayList<Abonnement> findAll() {
        ArrayList<Abonnement> listeAbonnement = new ArrayList<>();
        try {
            Connection laConnexion = Connexion.getInstance().creeConnexion();

            PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement");

            ResultSet res = requete.executeQuery();

            while (res.next()) {
                listeAbonnement.add(new Abonnement(null,null,res.getInt("idCl"),res.getInt("idRevue")));
                }
            }



        catch(SQLException sqle){
            System.out.println("Pb dans findAll " + sqle.getMessage());
        }


        return null;
    }

    @Override
    public Abonnement getById(int id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
}
