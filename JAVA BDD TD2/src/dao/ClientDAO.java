package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.metier.Client;

public interface ClientDAO extends DAO<Client>{
	
	public List<Client> getByNom(Client client) throws Exception;

	ArrayList<Client> findAll();
	
	//TODO
}
