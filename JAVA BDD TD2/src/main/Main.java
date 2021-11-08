package main;

import java.util.Scanner;

import dao.DAOFactory;
import dao.Persistance;
import modele.metier.Periodicite;



public class Main {
	static Scanner sc = new Scanner(System.in);
	
	static Boolean b_per=false;
	static Boolean b_abo=false;
	static Boolean b_cli=false;
	static Boolean b_rev=false;
	
	static Boolean create=false;
	static Boolean delete=false;
	static Boolean update=false;
	

	public static void main(String[] args) throws Exception {
																//Debut du programmme
		DAOFactory daos = null;
		System.out.println(
				 "1.MySQL "
				+ "2.ListeMemoire ");
		int i = sc.nextInt();
		if(i ==1)
		{
			daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		}
		else if (i == 2)
		{
			 daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);	
		}
		
		//recuperation de la table voulue
		System.out.println("operation sur quel table? "
				+ "1.Periodicite "
				+ "2.Abonnement "
				+ "3.Client "
				+ "4.Revue ");
		int table = sc.nextInt();
		switch(table)
		{
		case 1 : b_per=true;
		case 2 : b_abo=true;
		case 3 : b_cli=true;
		case 4 : b_rev=true;
		}
		
		//recuperation de l'operation desire
		System.out.println("quel operation? "
				+ "1.Ajouter une ligne "
				+ "2.Supprimer une ligne "
				+ "3.Modifier un ligne ");
		int op = sc.nextInt();
		switch(op)
		{
		case 1 : create=true;
		case 2 : delete=true;
		case 3 : update=true;
		}
		//table Periodicite, methode d'ajout
				if(b_per&&create) {
					System.out.println("quel id_periode?");
					int idPerio = sc.nextInt();
					System.out.println("quel libelle?");
					sc.nextLine();
					String libelle = sc.nextLine();
					
					Periodicite per = new Periodicite(idPerio, libelle);			
					daos.getPeriodiciteDAO().create(per);
					Init();
				}
	}
	public static void Init() {
		b_per=false;
		b_abo=false;
		b_cli=false;
		b_rev=false;
		
		create=false;
		delete=false;
		update=false;
	}
}