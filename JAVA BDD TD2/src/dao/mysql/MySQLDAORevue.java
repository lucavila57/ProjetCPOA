package dao.mysql;
//verifier getbyid , create update et delete 

import dao.RevueDAO;
import modele.metier.Revue;

import java.sql.*;
import java.util.ArrayList;


public class MySQLDAORevue implements RevueDAO {

    public static MySQLDAORevue Instance;

    private MySQLDAORevue() {
    }


    public static MySQLDAORevue getInstance() {

        if (Instance == null) {
            Instance = new MySQLDAORevue();
        }
        return Instance;
    }

    @Override
    public Revue getById(int idRevue) throws Exception {
        // TODO Auto-generated method stub
        Revue rev = null;
        try {
            Connection laConnexion = Connexion.getInstance().creeConnexion();
            PreparedStatement requete = laConnexion.prepareStatement("select * from periodicite where id=?");
            requete.setInt(1, idRevue);
            ResultSet res = requete.executeQuery();
            if (res.next()) {
                rev = new Revue(idRevue, res.getString(2), res.getString(3), res.getDouble(4), res.getString(5), res.getInt(6));
            }


        } catch (SQLException sqle) {
            System.out.println("pb dans insert" + sqle.getMessage());
        }
        return rev;
    }

    @Override
    public boolean create(Revue objet) throws Exception {
        // TODO Auto-generated method stub
        Connection laConnexion = Connexion.getInstance().creeConnexion();
        PreparedStatement req = laConnexion.prepareStatement("insert into Revue(id_revue,titre,description,tarif_numero,visuel, periodicite) values(?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);

        req.setInt(1, objet.getIdRevue());
        req.setString(2, objet.getTitre());
        req.setString(3, objet.getDescription());
        req.setDouble(4, objet.getTarifNumero());
        req.setString(5, objet.getVisuel());
        req.setInt(6, objet.getId_Perio());

        int res = req.executeUpdate();
        ResultSet re = req.getGeneratedKeys();
        if (re.next()) {
            objet.setIdRevue(re.getInt(1));
        }
        return res == 1;
    }

    @Override
    public boolean update(Revue objet) throws Exception {
        // TODO Auto-generated method stub
        Connection laConnexion = Connexion.getInstance().creeConnexion();
        PreparedStatement req = laConnexion.prepareStatement("Update Revue set id_revue=?, titre=?, description=?, tarif_numero=?,visuel=?, periodicite=? where id_revue=?");

        req.setInt(1, objet.getIdRevue());
        req.setString(2, objet.getTitre());
        req.setString(3, objet.getDescription());
        req.setDouble(4, objet.getTarifNumero());
        req.setString(5, objet.getVisuel());
        req.setInt(6, objet.getId_Perio());

        int res = req.executeUpdate();
        ResultSet re = req.getGeneratedKeys();
        if (re.next()) {
            objet.setIdRevue(re.getInt(1));
        }
        return res == 1;
    }

    @Override
    public boolean delete(Revue objet) throws Exception {
        // TODO Auto-generated method stub
        Connection laConnexion = Connexion.getInstance().creeConnexion();
        PreparedStatement req = laConnexion.prepareStatement("delete from Revue where id_revue=?");
        req.setInt(1, objet.getIdRevue());
        int res = req.executeUpdate();
        ResultSet re = req.getGeneratedKeys();
        if (re.next()) {
            objet.setIdRevue(re.getInt(1));
        }
        return res == 1;
    }


    @Override
    public ArrayList<Revue> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

} 
