package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dao.DAOFactory;
import dao.Persistance;
import modele.metier.Abonnement;
import modele.metier.Client;
import modele.metier.Periodicite;
import modele.metier.Revue;



public class Main {
	static Scanner scan = new Scanner(System.in);
	
	static Boolean bool_perio=false;
	static Boolean bool_abo=false;
	static Boolean bool_client=false;
	static Boolean bool_revue=false;
	
	static Boolean create=false;
	static Boolean delete=false;
	static Boolean update=false;
	

	public static void main(String[] args) throws Exception {
																//Debut du programmme
		DAOFactory daos = null;
		System.out.println("Veuillez choisir la persistance" +
				 "1.MySQL "
				+ "2.ListeMemoire ");
		int i = scan.nextInt();
		if(i ==1)
		{
			daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		}
		else if (i == 2)
		{
			 daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);	
		}
		
		//recuperation de la table voulue
		System.out.println("Quelle table voulez-vous utiliser ? "
				+ "1.Periodicite "
				+ "2.Abonnement "
				+ "3.Client "
				+ "4.Revue ");
		int table = scan.nextInt();
		switch(table)
		{
		case 1 : bool_perio=true;
		case 2 : bool_abo=true;
		case 3 : bool_client=true;
		case 4 : bool_revue=true;
		}
		
		//recuperation de l'operation desire
		System.out.println("quel operation? "
				+ "1.Ajouter une ligne "
				+ "2.Supprimer une ligne "
				+ "3.Modifier un ligne ");
		int op = scan.nextInt();
		switch(op)
		{
		case 1 : create=true;
		case 2 : delete=true;
		case 3 : update=true;
		}
		//table Periodicite, methode d'ajout
				if(bool_perio&&create) {
					System.out.println("quel id_periode?");
					int idPerio = scan.nextInt();
					System.out.println("quel libelle?");
					scan.nextLine();
					String libelle = scan.nextLine();
					
					Periodicite per = new Periodicite(idPerio, libelle);			
					daos.getPeriodiciteDAO().create(per);
					Init();
				}
				

				//table Periodicite, methode de modification
				else if(bool_perio&&update) {
					System.out.println("modifier quelle ligne?");
					int id_periodicite = scan.nextInt();
					System.out.println("quel libelle?");
					scan.nextLine();
					String libelle = scan.nextLine();
					
					Periodicite per = new Periodicite(id_periodicite, libelle);
					daos.getPeriodiciteDAO().update(per);
					Init();
				}
				//table Periodicite, methode de suppression
				else if(bool_perio&&delete) {			
					System.out.println("supprimer quelle ligne?");
					int id_periodicite = scan.nextInt();
					
					Periodicite per = new Periodicite(id_periodicite, "");
					daos.getPeriodiciteDAO().delete(per);
					Init();
					
				}
				//table Abonnement, methode d'ajout
				else if(bool_abo&&create) {
					DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					System.out.println("quel id_client?");
					int id_client = scan.nextInt();
					System.out.println("quel id_revue?");
					int id_revue = scan.nextInt();
					System.out.println("quelle date de debut?");
					scan.nextLine();
					LocalDate date_debut = LocalDate.parse(scan.nextLine(), formatage);
					System.out.println("quelle date de fin?");
					LocalDate date_fin = LocalDate.parse(scan.nextLine(), formatage);
					
					Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue );
					daos.getAbonnementDAO().create(abo);
					Init();
				}

				

				//table Abonnement, methode de modification
				else if(bool_abo&&update) {
					DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					System.out.println("modifier quelle ligne?");
					int id_client = scan.nextInt();
					System.out.println("quel id_revue?");
					int id_revue = scan.nextInt();
					System.out.println("quelle date de debut?");
					scan.nextLine();
					LocalDate date_debut = LocalDate.parse(scan.nextLine(), formatage);
					System.out.println("quelle date de fin?");
					LocalDate date_fin = LocalDate.parse(scan.nextLine(), formatage);
					
					Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue);
					daos.getAbonnementDAO().update(abo);
					Init();
				}
//table Abonnement, methode de suppression
				else if(bool_abo&&delete) {
					System.out.println("supprimer quel client?");
					int id_client = scan.nextInt();
					System.out.println("supprimer pour quelle revue?");
					int id_revue = scan.nextInt();
					
					Abonnement abo = new Abonnement(null,null,id_client, id_revue);
					daos.getAbonnementDAO().delete(abo);
					Init();
				}
				//table Client, methode d'ajout
				else if(bool_client&&create) {
					System.out.println("quel id_client?");
					int id_client = scan.nextInt();
					System.out.println("quel nom?");
					scan.nextLine();
					String nom = scan.nextLine();
					System.out.println("quel prenom?");
					String prenom = scan.nextLine();
					System.out.println("quelle no de rue?");
					String no_rue = scan.nextLine();
					System.out.println("quelle voie?");
					String voie = scan.nextLine();
					System.out.println("quel code postal?");
					String code_postal = scan.nextLine();
					System.out.println("quelle ville?");
					String ville = scan.nextLine();
					System.out.println("quel pays?");
					String pays = scan.nextLine();
					
					Client cli = new Client(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
					daos.getClientDAO().create(cli);
					Init();
				}

				

				//table Client, methode de modif
				else if(bool_client&&update) {
					System.out.println("modifier quelle ligne?");
					int id_client = scan.nextInt();
					System.out.println("quel nom?");
					scan.nextLine();
					String nom = scan.nextLine();
					System.out.println("quel prenom?");
					String prenom = scan.nextLine();
					System.out.println("quelle rue?");
					String no_rue = scan.nextLine();
					System.out.println("quelle voie?");
					String voie = scan.nextLine();
					System.out.println("quel code postal?");
					String code_postal = scan.nextLine();
					System.out.println("quelle ville?");
					String ville = scan.nextLine();
					System.out.println("quel pays?");
					String pays = scan.nextLine();
					
					Client cli = new Client(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
					daos.getClientDAO().update(cli);
					Init();
				}
//table Client, methode de suppression
				else if(bool_client&&delete) {
					System.out.println("supprimer quelle ligne?");
					int id_client = scan.nextInt();
					
					Client cli = new Client(id_client, "", "", "", "", "", "", "");
					daos.getClientDAO().delete(cli);
					Init();
				}
				//table Revue, methode d'ajout
				else if(bool_revue&&create) {
					System.out.println("quel id_revue?");
					int id_revue = scan.nextInt();
					System.out.println("quel titre?");
					scan.nextLine();
					String titre = scan.nextLine();
					System.out.println("quelle description?");
					String description = scan.nextLine();
					System.out.println("quel tarif?");
					Double tarif_numero = scan.nextDouble();
					System.out.println("quel visuel?");
					scan.nextLine();
					String visuel = scan.nextLine();
					System.out.println("quel id_periode?");
					int id_periodicite = scan.nextInt();
					
					Revue rev = new Revue(id_revue, titre, description, tarif_numero, visuel, id_periodicite);
					daos.getRevueDAO().create(rev);
					Init();
				}

				
				//table Revue, methode de modif
				else if(bool_revue&&update) {
					System.out.println("modifier quelle ligne?");
					int id_revue = scan.nextInt();
					System.out.println("quel titre?");
					scan.nextLine();
					String titre = scan.nextLine();
					System.out.println("quelle description?");
					String description = scan.nextLine();
					System.out.println("quel tarif?");
					Double tarif_numero = scan.nextDouble();
					System.out.println("quel visuel?");
					scan.nextLine();
					String visuel = scan.nextLine();
					System.out.println("quel id_periode?");
					int id_periodicite = scan.nextInt();
								
					Revue rev = new Revue(id_revue, titre, description, tarif_numero, visuel, id_periodicite);
					daos.getRevueDAO().update(rev);
					Init();
				}
				
				
				//table Revue, methode de suppression
				else if(bool_revue&&delete) {
					System.out.println("supprimer quelle ligne?");
					int id_revue = scan.nextInt();
					
					Revue rev = new Revue(id_revue, "", "", 0, "", 1);
					daos.getRevueDAO().delete(rev);
					Init();
				}

			}
	
	public static void Init() {
		bool_perio=false;
		bool_abo=false;
		bool_client=false;
		bool_revue=false;
		
		create=false;
		delete=false;
		update=false;
	}
}