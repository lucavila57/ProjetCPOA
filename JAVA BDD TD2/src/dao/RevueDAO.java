package dao;

import java.util.ArrayList;

import modele.metier.Revue;

public interface RevueDAO extends DAO<Revue> {
	@Override
	boolean create(Revue revue) throws Exception;

	@Override
	boolean delete(Revue revue) throws Exception;

	@Override
	boolean update(Revue revue) throws Exception;
	
	@Override
	Revue getById(int id) throws Exception;
	
	@Override
	ArrayList<Revue> findAll() throws Exception;
}
