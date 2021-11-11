package Test.mysql;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import dao.AbonnementDAO;
import dao.DAOFactory;
import dao.Persistance;
import modele.metier.Abonnement;



class MySQLAbonnementDAOTest {
	AbonnementDAO testabo = DAOFactory.getDAOFactory(Persistance.MYSQL).getAbonnementDAO();

	@Test
	void testCreate() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int id_client = 11;
		int  id_revue = 22;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client,id_revue);
		if(!testabo.create(abo)) {
			fail("non créer");
		}
		testabo.delete(abo);
	}
	
	

	@Test
	void testUpdate() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 22;
		int  id_revue = 33;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue );
		if(!testabo.update(abo)) {
			fail("non modifie");
		}	
		testabo.delete(abo);
	}

	@Test
	void testDelete() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 33;
		int id_revue = 44;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin, id_client, id_revue);
		if (!testabo.delete(abo)) {
			fail("non supprime");
		}
	}
	@Test
	void testGetById() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 11;
		int  id_revue = 22;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue );		testabo.create(abo);
	 	
		if(!testabo.getById(abo.getIdCl(), abo.getId_revue()).equals(abo)) {
			testabo.delete(abo);
			fail("non trouve");
		}
		testabo.delete(abo);

	}
	
	@Test
	void testFindAll() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 99;
		int  id_revue = 111;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);	
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue );
		testabo.create(abo);
		
		if(testabo.findAll()==null) {
			testabo.delete(abo);
			fail("non trouve");
		}
		testabo.delete(abo);
	}

}

