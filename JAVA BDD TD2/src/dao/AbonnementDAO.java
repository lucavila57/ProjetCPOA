package dao;

import java.util.ArrayList;

import modele.metier.Abonnement;


public interface AbonnementDAO extends DAO<Abonnement>{

	ArrayList<Abonnement> findAll();

}
