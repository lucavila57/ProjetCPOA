package dao;

import dao.listmemoire.ListeMemoireDAOFactory;
import dao.mysql.MySQLDAOFactory;

public abstract class DAOFactory {
    public static DAOFactory getDAOFactory(Persistance cible) {
        DAOFactory daoF = null;
        switch (cible) {
            case MYSQL:
                daoF = new MySQLDAOFactory();
                break;
            case LISTE_MEMOIRE:
                daoF = new ListeMemoireDAOFactory();
                break;
            default:
                break;
        }
        return daoF;
    }

    public abstract AbonnementDAO getAbonnementDAO();

    public abstract ClientDAO getClientDAO();

    public abstract RevueDAO getRevueDAO();

    public abstract PeriodiciteDAO getPeriodiciteDAO();
}
