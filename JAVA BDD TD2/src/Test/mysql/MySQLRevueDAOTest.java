package Test.mysql;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.DAOFactory;
import dao.Persistance;
import dao.RevueDAO;
import modele.metier.Revue;

class MySQLRevueDAOTest {

	RevueDAO testrevue = DAOFactory.getDAOFactory(Persistance.MYSQL).getRevueDAO();

	@Test
	void testCreate() throws Exception {
		String titre = "test";
		String description = "test";
		double tarif_numero = 2;
		String visuel = "test";
		int id_periodicite = 1;

		Revue rev = new Revue(titre, description, tarif_numero, visuel, id_periodicite);
		if (!testrevue.create(rev)) {
			fail("non créer");
		}
		testrevue.delete(rev);
	}

	@Test
	void testUpdate() throws Exception {
		String titre = "test";
		String description = "test";
		double tarif_numero = 2;
		String visuel = "test";
		int id_periodicite = 1;

		Revue rev = new Revue(titre, description, tarif_numero, visuel, id_periodicite);
		if (!testrevue.update(rev)) {
			fail("Pas encore modifie");
		}
		testrevue.delete(rev);
	}

	@Test
	void testDelete() throws Exception {
		String titre = "test";
		String description = "test";
		double tarif_numero = 2;
		String visuel = "test";
		int id_periodicite = 1;

		Revue rev = new Revue(titre, description, tarif_numero, visuel, id_periodicite);
		if (!testrevue.delete(rev)) {
			fail("non supprimé");
		}
	}

	@Test
	void testGetById() throws Exception {
		String titre = "test";
		String description = "test";
		double tarif_numero = 2;
		String visuel = "test";
		int id_periodicite = 1;

		Revue rev = new Revue(titre, description, tarif_numero, visuel, id_periodicite);

		if (!testrevue.getById(rev.getId_revue()).equals(rev)) {
			testrevue.delete(rev);
			fail("non trouve");
		}
		testrevue.delete(rev);
	}

	@Test
	void testFindAll() throws Exception {
		String titre = "test";
		String description = "test";
		double tarif_numero = 2;
		String visuel = "test";
		int id_periodicite = 1;

		Revue rev = new Revue(titre, description, tarif_numero, visuel, id_periodicite);

		if (testrevue.findAll() == null) {
			testrevue.delete(rev);
			fail("non trouvé");
		}
		testrevue.delete(rev);
	}
}