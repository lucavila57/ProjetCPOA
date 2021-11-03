package dao;

import modele.metier.Client;

import java.util.List;

public interface ClientDAO extends DAO<Client> {

    public List<Client> getByNom(Client client) throws Exception;


}
