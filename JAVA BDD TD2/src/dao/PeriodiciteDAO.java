package dao;

import java.util.ArrayList;

import modele.metier.Periodicite;

public interface PeriodiciteDAO extends DAO<Periodicite>{

	ArrayList<Periodicite> findAll();

	
}
