package Test.listmemoire;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import dao.AbonnementDAO;
import dao.DAOFactory;
import dao.Persistance;
import modele.metier.Abonnement;



class ListeMemoireAboDAOTest {
	
	DAOFactory daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	AbonnementDAO labo = daos.getAbonnementDAO();

	@Test
	void testCreate() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 11;
		int  id_revue = 22;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);	
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue);
		if(!labo.create(abo)) {
			fail("Pas implemente");
		}
		labo.delete(abo);
	}

	@Test
	void testDelete() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 33;
		int  id_revue = 44;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);		
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue);
		labo.create(abo);
		
		if(!labo.delete(abo)) {
			fail("Pas supprime");
		}	
	}

	@Test
	void testUpdate() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int id_client = 55;
		int  id_revue = 66;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue);
		labo.create(abo);
		
		if(!labo.update(abo)) {
			fail("Pas modifie");
		}	
		labo.delete(abo);
	}

	@Test
	void testGetById() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 77;
		int  id_revue = 88;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue);
		labo.create(abo);
		
		if(!labo.getById(abo.getIdCl(), abo.getId_revue()).equals(abo)) {
			labo.delete(abo);
			fail("Pas trouve");			
		}
		labo.delete(abo);
	}

	@Test
	void testFindAll() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 99;
		int  id_revue = 111;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue);
		labo.create(abo);
		
		if(labo.findAll()==null) {
			labo.delete(abo);
			fail("Pas trouve");
		}
		labo.delete(abo);
	}

}
