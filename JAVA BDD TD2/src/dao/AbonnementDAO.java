package dao;

import modele.metier.Abonnement;


public interface AbonnementDAO extends DAO<Abonnement>{

	Abonnement getById(int idCl, int idRevue) throws Exception;



}
