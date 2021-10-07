package main;

import java.sql.SQLException;
import dao.mysql.*;
import dao.*;
import connexion.Connexion;
import dao.listmemoire.*;
import modele.metier.*;

public class Main {
	public static void main(String[] arg) throws Exception {

	//Connexion laConnexion = new Connexion();
	//Connexion.creeConnexion();	

		
	System.out.println(ListeMemoirePeriodiciteDAO.getInstance().getById(1));
	System.out.println(ListeMemoirePeriodiciteDAO.getInstance().getById(2));

	
	
}
	
	
}