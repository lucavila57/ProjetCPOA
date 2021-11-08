package dao;

import modele.metier.Client;

import java.util.ArrayList;
import java.util.List;

public interface ClientDAO extends DAO<Client> {

    public List<Client> getByNom(Client client) throws Exception;

    @Override
	boolean create(Client client) throws Exception;

	@Override
	boolean delete(Client client) throws Exception;

	@Override
	boolean update(Client client) throws Exception;
	
	@Override
	Client getById(int id) throws Exception;

	@Override
	ArrayList<Client> findAll() throws Exception;
}
