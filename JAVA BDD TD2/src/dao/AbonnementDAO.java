package dao;

import java.util.ArrayList;

import modele.metier.Abonnement;


public interface AbonnementDAO extends DAO<Abonnement>{

	Abonnement getById(int idCl, int idRevue) throws Exception;

	@Override
	boolean create(Abonnement abonnement) throws Exception;

	@Override
	boolean delete(Abonnement abonnement) throws Exception;

	@Override
	boolean update(Abonnement abonnement) throws Exception;
	
	@Override
	Abonnement getById(int id)throws Exception;
	
	
	
	
	@Override
	ArrayList<Abonnement> findAll() throws Exception;
	
}
