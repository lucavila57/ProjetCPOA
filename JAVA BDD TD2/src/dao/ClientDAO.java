package dao;

import java.sql.SQLException;
import java.util.List;

import modele.metier.Client;

public interface ClientDAO extends DAO<Client>{
	
	public List<Client> getByNom(String name) throws Exception;
	
	//TODO
}
