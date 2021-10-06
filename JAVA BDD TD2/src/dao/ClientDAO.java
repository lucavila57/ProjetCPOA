package dao;

import java.util.List;

import modele.metier.Client;

public interface ClientDAO extends DAO<Client>{
	
	public List<Client> getByNom(String name);
	
	//TODO
}
