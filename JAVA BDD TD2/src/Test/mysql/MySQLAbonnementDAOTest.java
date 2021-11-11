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
	AbonnementDAO mabo = DAOFactory.getDAOFactory(Persistance.MYSQL).getAbonnementDAO();

	@Test
	void testCreate() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int id_client = 11;
		int  id_revue = 22;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client,id_revue);
		if(!mabo.create(abo)) {
			fail("Pas implemente");
		}
		mabo.delete(abo);
	}
	
	@Test
	void testDelete() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 33;
		int  id_revue = 44;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue );
		if(!mabo.delete(abo)) {
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
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue );
		if(!mabo.update(abo)) {
			fail("Pas modifie");
		}	
		mabo.delete(abo);
	}

	@Test
	void testGetById() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 77;
		int  id_revue = 88;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue );		mabo.create(abo);
	 	
		if(!mabo.getById(abo.getIdCl(), abo.getId_revue()).equals(abo)) {
			mabo.delete(abo);
			fail("Pas trouve");
		}
		mabo.delete(abo);

	}
	
	@Test
	void testFindAll() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 99;
		int  id_revue = 111;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);	
		Abonnement abo = new Abonnement(date_debut, date_fin,id_client, id_revue );
		mabo.create(abo);
		
		if(mabo.findAll()==null) {
			mabo.delete(abo);
			fail("Pas trouve");
		}
		mabo.delete(abo);
	}

}

