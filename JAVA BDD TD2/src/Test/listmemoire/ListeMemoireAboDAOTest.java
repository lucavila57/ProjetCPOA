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

	DAOFactory daofac = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	AbonnementDAO lmabo = daofac.getAbonnementDAO();

	@Test
	void testCreate() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 11;
		int id_revue = 22;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin, id_client, id_revue);
		if (!lmabo.create(abo)) {
			fail("non créer");
		}
		lmabo.delete(abo);
	}

	@Test
	void testUpdate() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int id_client = 55;
		int id_revue = 66;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin, id_client, id_revue);
		lmabo.create(abo);

		if (!lmabo.update(abo)) {
			fail("non modifié");
		}
		lmabo.delete(abo);
	}

	@Test
	void testDelete() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 33;
		int id_revue = 44;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin, id_client, id_revue);
		lmabo.create(abo);

		if (!lmabo.delete(abo)) {
			fail("Pas supprime");
		}
	}

	@Test
	void testGetById() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 77;
		int id_revue = 88;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin, id_client, id_revue);
		lmabo.create(abo);

		if (!lmabo.getById(abo.getIdCl(), abo.getId_revue()).equals(abo)) {
			lmabo.delete(abo);
			fail("Pas trouve");
		}
		lmabo.delete(abo);
	}

	@Test
	void testFindAll() throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		int id_client = 99;
		int id_revue = 111;
		LocalDate date_debut = LocalDate.parse("18/09/2018", formatage);
		LocalDate date_fin = LocalDate.parse("21/11/2021", formatage);
		Abonnement abo = new Abonnement(date_debut, date_fin, id_client, id_revue);
		lmabo.create(abo);

		if (lmabo.findAll() == null) {
			lmabo.delete(abo);
			fail("non trouvé");
		}
		lmabo.delete(abo);
	}

}
