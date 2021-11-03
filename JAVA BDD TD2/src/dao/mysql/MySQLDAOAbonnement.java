package dao.mysql;

//verifier getbyid, create update et delete

import dao.AbonnementDAO;
import modele.metier.Abonnement;

import java.sql.*;
import java.util.ArrayList;

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
    public Abonnement getById(int id_abo) throws Exception {
        // TODO Auto-generated method stub
        Abonnement abo = null;
        try {
            Connection laConnexion = Connexion.getInstance().creeConnexion();
            PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement where id=?");
            requete.setInt(1, id_abo);
            ResultSet res = requete.executeQuery();
            if (res.next()) {
                abo = new Abonnement(res.getInt(1), null, null, null, null);
            }


        } catch (SQLException sqle) {
            System.out.println("pb dans insert" + sqle.getMessage());
        }
        return abo;

    }

    @Override
    public boolean create(Abonnement objet) throws Exception {
        // TODO Auto-generated method stub
        Connection laConnexion = Connexion.getInstance().creeConnexion();
        PreparedStatement req = laConnexion.prepareStatement(
                "insert into Abonnement(id_abo,date_debut,date_fin,id_client,id_revue) values(?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);

        req.setInt(1, objet.getIdAbo());
        req.setDate(2, java.sql.Date.valueOf(objet.getDateDeb()));
        req.setDate(3, java.sql.Date.valueOf(objet.getDateFin()));
        req.setInt(4, objet.getCl().getIdCl());
        req.setInt(5, objet.getRevue().getIdRevue());

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
        Connection laConnexion = Connexion.getInstance().creeConnexion();
        PreparedStatement req = laConnexion
                .prepareStatement("Update Abonnement set id_abo=?, date_deb=?, date_fin=?, id_client=?, id_revue=? where id_abo=?");
        req.setInt(1, objet.getIdAbo());
        req.setDate(2, java.sql.Date.valueOf(objet.getDateDeb()));
        req.setDate(3, java.sql.Date.valueOf(objet.getDateFin()));
        req.setInt(4, objet.getCl().getIdCl());
        req.setInt(5, objet.getRevue().getIdRevue());

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
        Connection laConnexion = Connexion.getInstance().creeConnexion();
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

        return null;
    }
}
