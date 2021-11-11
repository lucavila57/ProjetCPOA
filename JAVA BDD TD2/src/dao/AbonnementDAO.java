package dao;

import java.util.ArrayList;

import modele.metier.Abonnement;


public interface AbonnementDAO extends DAO<Abonnement>{

	Abonnement getById(int idCl, int idRevue) throws Exception;

	@Override
	boolean create(Abonnement objet) throws Exception;

	@Override
	boolean delete(Abonnement objet) throws Exception;

	@Override
	boolean update(Abonnement objet) throws Exception;
	
	
	@Override
	ArrayList<Abonnement> findAll() throws Exception;
	
}
