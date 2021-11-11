package Test.listmemoire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.DAOFactory;
import dao.Persistance;
import dao.RevueDAO;
import modele.metier.Revue;

class ListMemoireRevueDAOTest {

	DAOFactory daofac = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	RevueDAO lmrevue = daofac.getRevueDAO();

	@Test
	void testCreate() throws Exception {
		int id_revue = 1;
		String titre = "test";
		String description = "test";
		double tarif_numero = 2;
		String visuel = "test";
		int id_periodicite = 1;

		Revue rev = new Revue(id_revue, titre, description, tarif_numero, visuel, id_periodicite);
		if (!lmrevue.create(rev)) {
			fail("non créer");
		}
		lmrevue.delete(rev);
	}

	@Test
	void testUpdate() throws Exception {
		int id_revue = 1;
		String titre = "test";
		String description = "test";
		double tarif_numero = 2;
		String visuel = "1";
		int id_periodicite = 1;

		Revue rev = new Revue(id_revue, titre, description, tarif_numero, visuel, id_periodicite);
		lmrevue.create(rev);

		if (!lmrevue.update(rev)) {
			fail("non modifie");
		}
		lmrevue.delete(rev);
	}

	@Test
	void testDelete() throws Exception {
		int id_revue = 1;
		String titre = "test";
		String description = "test";
		double tarif_numero = 2;
		String visuel = "1";
		int id_periodicite = 1;

		Revue rev = new Revue(id_revue, titre, description, tarif_numero, visuel, id_periodicite);
		lmrevue.create(rev);
		if (!lmrevue.delete(rev)) {
			fail("Pas encore supprime");
		}
	}

	@Test
	void testGetById() throws Exception {
		int id_revue = 1;
		String titre = "test";
		String description = "test";
		double tarif_numero = 2;
		String visuel = "1";
		int id_periodicite = 1;

		Revue rev = new Revue(id_revue, titre, description, tarif_numero, visuel, id_periodicite);
		lmrevue.create(rev);

		if (!lmrevue.getById(rev.getId_revue()).equals(rev)) {
			lmrevue.delete(rev);
			fail("non trouve");
		}
		lmrevue.delete(rev);
	}

	@Test
	void testFindAll() throws Exception {
		int id_revue = 1;
		String titre = "test";
		String description = "test";
		double tarif_numero = 2;
		String visuel = "1";
		int id_periodicite = 1;

		Revue rev = new Revue(id_revue, titre, description, tarif_numero, visuel, id_periodicite);
		lmrevue.create(rev);

		if (lmrevue.findAll() == null) {
			lmrevue.delete(rev);
			fail("non trouve");
		}
		lmrevue.delete(rev);
	}

}