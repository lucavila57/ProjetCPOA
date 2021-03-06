package dao.mysql;

import dao.*;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public AbonnementDAO getAbonnementDAO() {
        // TODO Auto-generated method stub
        return MySQLDAOAbonnement.getInstance();
    }

    @Override
    public ClientDAO getClientDAO() {
        // TODO Auto-generated method stub
        return MySQLDAOClient.getInstance();
    }

    @Override
    public RevueDAO getRevueDAO() {
        // TODO Auto-generated method stub
        return MySQLDAORevue.getInstance();
    }

    @Override
    public PeriodiciteDAO getPeriodiciteDAO() {
        // TODO Auto-generated method stub
        return MySQLDAOPeriodicite.getInstance();
    }

}
