package dao;

import modele.metier.Client;

import java.util.ArrayList;
import java.util.List;

public interface ClientDAO extends DAO<Client> {

    public List<Client> getByNom(Client objet) throws Exception;

    @Override
	boolean create(Client objet) throws Exception;

	@Override
	boolean delete(Client objet) throws Exception;

	@Override
	boolean update(Client objet) throws Exception;
	
	@Override
	Client getById(int id) throws Exception;

	@Override
	ArrayList<Client> findAll() throws Exception;
}
