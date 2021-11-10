package dao;

import java.util.ArrayList;

import modele.metier.Revue;

public interface RevueDAO extends DAO<Revue> {
	@Override
	boolean create(Revue objet) throws Exception;

	@Override
	boolean delete(Revue objet) throws Exception;

	@Override
	boolean update(Revue objet) throws Exception;
	
	@Override
	Revue getById(int id_revue) throws Exception;
	
	@Override
	ArrayList<Revue> findAll() throws Exception;
}
