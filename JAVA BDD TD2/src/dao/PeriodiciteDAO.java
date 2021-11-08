package dao;

import java.util.ArrayList;

import modele.metier.Periodicite;

public interface PeriodiciteDAO extends DAO<Periodicite> {
	@Override
	boolean create(Periodicite objet) throws Exception;

	@Override
	boolean delete(Periodicite periodicite) throws Exception;

	@Override
	boolean update(Periodicite periodicite) throws Exception;
	
	@Override
	Periodicite getById(int id) throws Exception;

	@Override
	ArrayList<Periodicite> findAll() throws Exception;

}
