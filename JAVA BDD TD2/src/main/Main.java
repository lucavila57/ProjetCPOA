package main;

import java.sql.SQLException;
import dao.mysql.*;
import dao.*;
import connexion.Connexion;
import dao.listmemoire.*;
import modele.metier.*;

public class Main {
	public static void main(String[] arg) throws Exception {

	

	System.out.println("Voici la liste des Periodicites de la classe Liste memoire : ");
	System.out.println(ListeMemoirePeriodiciteDAO.getInstance().getById(1));
	System.out.println(ListeMemoirePeriodiciteDAO.getInstance().getById(2));
	
	Periodicite perio1 = new Periodicite(3,"Anuelle");
	ListeMemoirePeriodiciteDAO.getInstance().create(perio1);
	System.out.println("Je cree un objet periodicite et je l'affiche : ");
	System.out.println(ListeMemoirePeriodiciteDAO.getInstance().getById(3));
	
	
	System.out.println("Je modifie un objet periodicite et je l'affiche : ");
	Periodicite perio2 = new Periodicite(3,"Tous les jours");
	ListeMemoirePeriodiciteDAO.getInstance().update(perio2);
	System.out.println(ListeMemoirePeriodiciteDAO.getInstance().getById(3));

	
	System.out.println("Je supprime un objet periodicite : ");
	ListeMemoirePeriodiciteDAO.getInstance().delete(perio2);
	//System.out.println(ListeMemoirePeriodiciteDAO.getInstance().getById(3));//affiche une erreur car l'id 3 est supprimer
	System.out.println("Aucun objet ne possede l'ID 3 donc l'objet a bien etait supprime ");


	System.out.println("====================================================================");
	
	Connexion laConnexion = new Connexion();
	Connexion.creeConnexion();
	System.out.println("Voici la liste des Periodicites du MY SQL : ");
	Periodicite perio3 = new Periodicite(1,"Mensuelle");
	MYSQLPeriodiciteDAO.getInstance().create(perio3);
	System.out.println(MYSQLPeriodiciteDAO.getInstance().getById(1));

	
	System.out.println("Je modifie un objet periodicite et je l'affiche : ");
	Periodicite perio4 = new Periodicite(1,"Tous les jours");
	MYSQLPeriodiciteDAO.getInstance().update(perio4);
	System.out.println(MYSQLPeriodiciteDAO.getInstance().getById(1));

	System.out.println("Je supprime un objet periodicite : ");
	MYSQLPeriodiciteDAO.getInstance().delete(perio4);
	//System.out.println(ListeMemoirePeriodiciteDAO.getInstance().getById(3));//affiche une erreur car l'id 3 est supprimer
	System.out.println("Aucun objet ne possede l'ID 3 donc l'objet a bien etait supprime  ");

}
	
	
}